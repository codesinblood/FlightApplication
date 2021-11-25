INSERT INTO mydb.airline (Name,Logo,status) values ('Indigo',NULL,'A');
INSERT INTO mydb.airline (Name,Logo,status) values ('SpiceJet',NULL,'A');

INSERT INTO mydb.flight (FLIGHTUUID,MODEL,AIRLINEID,status) values ('ING-001','AIRBUS',1,'A');
INSERT INTO mydb.flight (FLIGHTUUID,MODEL,AIRLINEID,status) values ('ING-002','AIRBUS',1,'A');
INSERT INTO mydb.flight (FLIGHTUUID,MODEL,AIRLINEID,status) values ('SPC-001','BOEING',1,'A');
INSERT INTO mydb.flight (FLIGHTUUID,MODEL,AIRLINEID,status) values ('SPC-002','BOEING',1,'I');

INSERT INTO mydb.route (FROMCITY,TOCITY,PRICE,FLIGHTID, DEPARTURETIME, ARRIVALTIME,STATUS) values ('Chennai','Mumbai','4500.20','1','05:00:00','06:30:00','A');
INSERT INTO mydb.route (FROMCITY,TOCITY,PRICE,FLIGHTID, DEPARTURETIME, ARRIVALTIME,STATUS) values ('Chennai','Hyderabad','7400.20','2','07:00:00','08:15:00','A');
INSERT INTO mydb.route (FROMCITY,TOCITY,PRICE,FLIGHTID, DEPARTURETIME, ARRIVALTIME,STATUS) values ('Chennai','Jaipur','12300.20','3','10:00:00','12:30:00','A');
INSERT INTO mydb.route (FROMCITY,TOCITY,PRICE,FLIGHTID, DEPARTURETIME, ARRIVALTIME,STATUS) values ('Jaipur','Chennai','6523.20','4','17:00:00','19:30:00','A');

