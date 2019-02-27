CREATE TABLE LOCATION
(
  latitude    float        not null,
  longitude   float        not null,
  city        VARCHAR(255) not null,
  location_id integer      NOT NULL,
  primary key (location_id)
);
CREATE TABLE APP_USERS
(
  user_id       integer UNIQUE NOT NULL,
  user_password VARCHAR(255)   NOT NULL,
  user_name     VARCHAR(255)   NOT NULL,
  primary key (user_id)
);
CREATE TABLE ACTIVITY
(
  ACTIVITY_id    VARCHAR(16) not null,
  Title       VARCHAR(255) not null,
  Activity    VARCHAR(255) not null,
  Description VARCHAR(255),
  location_id integer references LOCATION (location_id),
  user_id     integer references APP_USERS (user_id),
  primary key (ACTIVITY_id)
);

INSERT  INTO LOCATION (latitude, longitude, city, location_id)
VALUES (57.6877304,11.9788552,'Gothenburg',1);

INSERT  INTO  APP_USERS(user_id, user_password, user_name)
VALUES (1,'qwerty','DukeA');

INSERT  INTO ACTIVITY (ACTIVITY_id, Title, Activity, Description, location_id, user_id)
VALUES (1,'Monaden','Jogging','Nice jogging experiance',1,1);