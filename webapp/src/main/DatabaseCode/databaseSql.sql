CREATE TABLE Location
(
  location_id serial      NOT NULL,
  latitude    FLOAT        NOT NULL,
  longitude   FLOAT        NOT NULL,
  city        VARCHAR(255) NOT NULL,
  PRIMARY KEY (location_id)
);
CREATE TABLE App_User
(
  user_id       serial      NOT NULL,
  user_password VARCHAR(255) NOT NULL,
  user_name     VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
);
CREATE TABLE Activity
(
  activity_id serial  NOT NULL,
  title       VARCHAR(255) NOT NULL,
  type        VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  location_id INTEGER REFERENCES Location (location_id),
  user_id     INTEGER REFERENCES App_User (user_id),
  PRIMARY KEY (activity_id)
);

INSERT  INTO LOCATION (latitude, longitude, city)
VALUES (57.6877304,11.9788552,'gothenburg');

INSERT  INTO  APP_USER(user_password, user_name)
VALUES ('qwerty','DukeA');

INSERT  INTO ACTIVITY (title, type, description, location_id, user_id)
VALUES ('Monaden','JOGGING','Nice jogging experiance',1,1);