drop table if exists mydb.route;
drop table if exists mydb.flight;
drop table if exists mydb.airline;

CREATE TABLE mydb.airline (
    AIRLINEID int NOT NULL AUTO_INCREMENT,
    NAME varchar(255) NOT NULL,
    LOGO BLOB,
	STATUS varchar(1) NOT NULL,
	PRIMARY KEY(AIRLINEID)
);


CREATE TABLE mydb.flight (
    FLIGHTID int NOT NULL AUTO_INCREMENT,
    FLIGHTUUID varchar(255) UNIQUE,
    MODEL varchar(255),
    MAKE varchar(255),
    AIRLINEID int,
	status varchar(1) NOT NULL,
	PRIMARY KEY(FLIGHTID),
    FOREIGN KEY (AIRLINEID) REFERENCES mydb.airline(AIRLINEID)
);

CREATE TABLE mydb.route (
	ROUTEID int NOT NULL AUTO_INCREMENT,
	FROMCITY varchar(255) NOT NULL,
	TOCITY varchar(255) NOT NULL,
	PRICE DECIMAL(50,10)  NOT NULL,
	FLIGHTID int, 
	DEPARTURETIME TIME NOT NULL,
	ARRIVALTIME TIME NOT NULL,
	STATUS varchar(1) NOT NULL,
	PRIMARY KEY(ROUTEID),
	FOREIGN KEY (FLIGHTID) REFERENCES mydb.flight(FLIGHTID)
);