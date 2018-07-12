set echo on
CREATE OR REPLACE PACKAGE service_request
IS

PROCEDURE new_request (
	p_service_name			IN		VARCHAR2) ;


PROCEDURE add_argument (
	arg_name				IN		VARCHAR2,
	arg 					IN		VARCHAR2) ;


PROCEDURE add_argument (
	arg_name				IN		VARCHAR2,
	arg 					IN		DATE) ;


PROCEDURE add_argument (
	arg_name				IN		VARCHAR2,
	arg 					IN		NUMBER) ;


PROCEDURE issue_request ;


FUNCTION get_argument
RETURN VARCHAR2 ;

function get_pipe_name return varchar2;


END service_request ;
/


CREATE OR REPLACE PACKAGE BODY service_request
IS
	argument	VARCHAR2(4096) ;
	service_name	service_rqst.service_rqst_cd%TYPE ;
	pipe_nm		service_rqst.pipe_nm%TYPE ;
	validate_flg	service_rqst.validate_flg%TYPE ;
	receive_time_out NUMBER ;
	session_name	VARCHAR2(80) ;
	need_comma	BOOLEAN := FALSE ;
/**
* BEGIN a new request, discard any argument construction from prior requests.
*/

PROCEDURE validate_arg (
	p_service_rqst_cd		IN			VARCHAR2,
	p_arg					IN			VARCHAR2,
	p_data_type				IN			VARCHAR2,
	p_msg					IN OUT		VARCHAR2 )
IS
	CURSOR parm_cur IS
	SELECT	*
	FROM	service_rqst_parms
	WHERE	service_rqst_cd		=	p_service_rqst_cd
	  AND	parm_nm				=	p_arg
	  AND	parm_data_type		=	p_data_type ;

	parm_rec						parm_cur%ROWTYPE ;
BEGIN
	OPEN parm_cur ;
	FETCH parm_cur INTO parm_rec ;
	IF parm_cur%NOTFOUND THEN
		p_msg	:=  '@Argument ' || p_arg || ' having datatype ' || p_data_type
			|| ' passed to service request ' ||  p_service_rqst_cd ||
			' is invalid@';
	END IF;
	CLOSE parm_cur ;

	IF p_msg IS NULL THEN
		p_msg	:=	'OK' ;
	END IF;

END	validate_arg ;


PROCEDURE new_request (
	p_service_name			IN		VARCHAR2)
IS
	CURSOR svc_cur IS
	SELECT	*
	FROM	service_rqst
	WHERE	service_rqst_cd		=	p_service_name ;

	svc_rec					svc_cur%ROWTYPE ;
BEGIN
	--ut.set_module('Service Request ' || p_service_name , 'User= ' || ut_user_pkg.get_user_nm) ;
	OPEN svc_cur ;
	FETCH svc_cur INTO svc_rec ;
	IF svc_cur%NOTFOUND THEN
		CLOSE svc_cur ;
        RAISE_APPLICATION_ERROR(-20011, '@Invalid Service Request: ''' ||
			p_service_name || '''' ||
		    ' No entry in service_rqst with that name.@') ;
	END IF;
	CLOSE svc_cur ;

	service_name	:=	p_service_name ;
	pipe_nm			:=	svc_rec.pipe_nm ;
	need_comma		:=	FALSE ;
	argument		:=	'' ;
	validate_flg	:=	svc_rec.validate_flg ;
END ;



PROCEDURE add_argument (
	arg_name				IN		VARCHAR2,
	arg 					IN		VARCHAR2)
IS
	my_msg						VARCHAR2(255) ;
BEGIN
	IF validate_flg = 'Y' THEN
		validate_arg(service_name, arg_name, 'VARCHAR2', my_msg) ;
	END IF;

	IF my_msg != 'OK' THEN
		RAISE_APPLICATION_ERROR(-20099, my_msg) ;
	END IF;

	IF need_comma THEN
		argument := argument || ',' ;
	END IF ;

	argument := argument || arg_name || ',V,' || length(arg) || ',' ||arg ;

	need_comma := TRUE ;

END add_argument ;


PROCEDURE add_argument (
	arg_name				IN		VARCHAR2,
	arg 					IN		DATE)
IS
	my_msg						VARCHAR2(255) ;
BEGIN
	IF validate_flg = 'Y' THEN
		validate_arg(service_name, arg_name, 'DATE', my_msg) ;
	END IF;

	IF my_msg != 'OK' THEN
		RAISE_APPLICATION_ERROR(-20099, my_msg) ;
	END IF;

	IF need_comma THEN
		argument := argument || ',' ;
	END IF ;

	argument := argument || arg_name || ',D,' || TO_CHAR(arg,'YYYY/MM/DD') ;

	need_comma := TRUE ;

END add_argument ;


PROCEDURE add_argument (
	arg_name				IN		VARCHAR2,
	arg 					IN		NUMBER)
IS
	my_msg						VARCHAR2(255) ;
BEGIN
	IF validate_flg = 'Y' THEN
		validate_arg(service_name, arg_name, 'NUMBER', my_msg) ;
	END IF;

	IF my_msg != 'OK' THEN
		RAISE_APPLICATION_ERROR(-20099, my_msg) ;
	END IF;

	IF need_comma THEN
		argument := argument || ',' ;
	END IF ;

	argument := argument || arg_name ||  ',N,' || TO_CHAR(arg) ;

	need_comma := TRUE ;

END add_argument ;


PROCEDURE issue_request
IS
	pipe_rc						NUMBER ;
BEGIN

	session_name := dbms_pipe.unique_session_name ;
	--dbms_pipe.purge(pipe_nm) ;
	dbms_pipe.pack_message(service_name) ;
	dbms_pipe.pack_message(session_name) ;
	dbms_pipe.pack_message(argument) ;
	--pipe_rc := dbms_pipe.send_message('PipeRequest') ;
		dbms_application_info.set_action('SR.IR Before Send on' || pipe_nm) ;
	pipe_rc := dbms_pipe.send_message(pipe_nm) ;
	dbms_application_info.set_action('SR.IR After Send on' || pipe_nm) ;
	argument := '' ;
END issue_request ;


FUNCTION get_argument
RETURN VARCHAR2
IS
BEGIN
	RETURN argument ;
END	get_argument ;


FUNCTION get_response (
	receive_time_out 		IN		NUMBER)
RETURN VARCHAR2
IS
	pipe_rc				NUMBER			:=	NULL ;
	rc					VARCHAR2(4096)	:=	NULL ;
BEGIN
	IF (receive_time_out IS NULL) THEN
		rc := dbms_pipe.receive_message(session_name) ;
	ELSE
		rc := dbms_pipe.receive_message(session_name,receive_time_out) ;
	END IF ;
	 dbms_pipe.UNPACK_MESSAGE(rc) ;
	RETURN rc ;
END get_response ;

function get_pipe_name return varchar2 is
begin
   return 'PipeRequest';
end get_pipe_name;


END service_request ;
/

