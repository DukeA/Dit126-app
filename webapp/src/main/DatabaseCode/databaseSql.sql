CREATE TABLE Location
(
  location_id INTEGER      NOT NULL,
  latitude    FLOAT        NOT NULL,
  longitude   FLOAT        NOT NULL,
  city        VARCHAR(255) NOT NULL,
  PRIMARY KEY (location_id)
);
CREATE TABLE App_User
(
  user_id       INTEGER      NOT NULL,
  user_password VARCHAR(255) NOT NULL,
  user_name     VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
);
CREATE TABLE Activity
(
  activity_id VARCHAR(16)  NOT NULL,
  title       VARCHAR(255) NOT NULL,
  type        VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  location_id INTEGER REFERENCES Location (location_id),
  user_id     INTEGER REFERENCES App_User (user_id),
  PRIMARY KEY (activity_id)
);

INSERT  INTO Location (latitude, longitude, city, location_id)
VALUES (57.6877304,11.9788552,'Gothenburg',1);

INSERT  INTO App_User (user_id, user_password, user_name)
VALUES (1,'qwerty','DukeA');

INSERT  INTO Activity (activity_id, title, type, description, location_id, user_id)
VALUES (1,'Monaden','Jogging','Nice jogging experiance',1,1);