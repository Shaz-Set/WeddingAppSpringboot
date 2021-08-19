DROP TABLE IF EXISTS drink_Packages;

CREATE TABLE drink_Packages (
                              id LONG AUTO_INCREMENT  PRIMARY KEY,
                              price double(250) DEFAULT NULL,
                              name VARCHAR(250) NOT NULL,
                              detail VARCHAR(500) NOT NULL

);

DROP TABLE IF EXISTS wedding_Packages;

CREATE TABLE wedding_Packages (
                               id LONG AUTO_INCREMENT  PRIMARY KEY,
                               hours INT(250) NOT NULL,
                               styles VARCHAR(250) NOT NULL,
                               price double(250) DEFAULT NULL
);

DROP TABLE IF EXISTS add_Ons;

CREATE TABLE add_Ons (
                               id Long AUTO_INCREMENT  PRIMARY KEY,
                               name VARCHAR(250) NOT NULL,
                               detail VARCHAR(500) NOT NULL,
                               price double(250) DEFAULT NULL
);



