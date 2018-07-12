package org.javautil.oracle;

public class SessionInfo {
	private int sid;
    private int serial;
    private int spid;
    private int pid;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public SessionInfo(int sid, int serial, int spid, int pid) {
		super();
		this.sid = sid;
		this.serial = serial;
		this.spid = spid;
		this.pid = pid;
	}

}
