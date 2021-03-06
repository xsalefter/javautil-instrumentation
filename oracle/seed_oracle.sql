INSERT INTO org VALUES (1, 'F-L', 'Frito-Lay');
INSERT INTO org VALUES (2, 'GM', 'General Mills');
INSERT INTO org VALUES (3, 'HVEND', 'Hershey Vending');
INSERT INTO org VALUES (4, 'HFUND', 'Hershey Fund Raising');
INSERT INTO org VALUES (5, 'HCONC', 'Hershey Concession');
INSERT INTO org VALUES (6, 'SNYDERS', 'Snyder''s of Hanover');
INSERT INTO org VALUES (7, 'KELLOGG', 'Kellogg, Keebler');
INSERT INTO org VALUES (8, 'KARS', 'Kar Nut Product (Kar''s)');
INSERT INTO org VALUES (9, 'MARS', 'Mars Chocolate ');
INSERT INTO org VALUES (10, 'POORE', 'Inventure Group (Poore Brothers)');
INSERT INTO org VALUES (11, 'WOW', 'WOW Foods');
INSERT INTO org VALUES (12, 'CADBURY', 'Cadbury Adam USA, LLC');
INSERT INTO org VALUES (13, 'MONOGRAM', 'Monogram Food');
INSERT INTO org VALUES (14, 'JUSTBORN', 'Just Born');
INSERT INTO org VALUES (15, 'HOSTESS', 'Hostess, Dolly Madison');
INSERT INTO org VALUES (16, 'SARALEE', 'Sara Lee');
INSERT INTO org VALUES (17, 'ExoticTx', 'Exotic Texas');
INSERT INTO org VALUES (18, 'EXOTICTX', 'Texas Exotic Foods');
--
INSERT INTO org_distrib VALUES (18, '0000000001');
--
INSERT INTO org_mfr VALUES (1, '0000000020');
INSERT INTO org_mfr VALUES (2, '0000000030');
INSERT INTO org_mfr VALUES (3, '0000000040');
INSERT INTO org_mfr VALUES (4, '0000000050');
INSERT INTO org_mfr VALUES (5, '0000000055');
INSERT INTO org_mfr VALUES (6, '0000000060');
INSERT INTO org_mfr VALUES (7, '0000000080');
INSERT INTO org_mfr VALUES (8, '0000000115');
INSERT INTO org_mfr VALUES (9, '0000000135');
INSERT INTO org_mfr VALUES (10, '0000000145');
INSERT INTO org_mfr VALUES (11, '0000000150');
INSERT INTO org_mfr VALUES (12, '0000000160');
INSERT INTO org_mfr VALUES (13, '0000000170');
INSERT INTO org_mfr VALUES (14, '0000000185');
INSERT INTO org_mfr VALUES (15, '0000000190');
INSERT INTO org_mfr VALUES (16, '0000000210');
INSERT INTO org_mfr VALUES (17, '0000000005');

drop sequence org_seq;
create sequence org_seq start with 19;
