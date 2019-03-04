CREATE TABLE LOCATION
(
  latitude    float        not null,
  longitude   float        not null,
  city        VARCHAR(255) not null,
  location_id serial      NOT NULL,
  primary key (location_id)
);
CREATE TABLE APP_USERS
(
  user_id       serial NOT NULL,
  user_password VARCHAR(255)   NOT NULL,
  user_name     VARCHAR(255)   NOT NULL,
  primary key (user_id)
);
CREATE TABLE ACTIVITY
(
  Activity_id    serial not null,
  Title       VARCHAR(255) not null,
  Activity    VARCHAR(255) not null,
  Description VARCHAR(255),
  location_id integer references LOCATION (location_id),
  user_id     integer references APP_USERS (user_id),
  primary key (ACTIVITY_id)
);

INSERT  INTO LOCATION (latitude, longitude, city)
VALUES (57.6877304,11.9788552,'Gothenburg');

INSERT  INTO  APP_USERS(user_password, user_name)
VALUES ('qwerty','DukeA');

INSERT  INTO ACTIVITY (Title, Activity, Description, location_id, user_id)
VALUES ('Monaden','Jogging','Nice jogging experiance',1,1);