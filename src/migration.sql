DROP DATABASE IF EXISTS hobby_hopper_db;

CREATE DATABASE IF NOT EXISTS hobby_hopper_db;

USE hobby_hopper_db;

CREATE TABLE IF NOT EXISTS users(
                                    id INT AUTO_INCREMENT NOT NULL,
                                    username VARCHAR(30),
                                    email VARCHAR(255),
                                    password VARCHAR(255),
                                    location VARCHAR(255),
                                    DOB DATETIME,
                                    image VARCHAR(255),
                                    is_admin BOOLEAN,
                                    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS categories(
                                         id INT NOT NULL AUTO_INCREMENT,
                                         category_name VARCHAR(255),
                                         PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS events(
                                     id INT AUTO_INCREMENT NOT NULL,
                                     created_event DATETIME,
                                     updated_event DATETIME,
                                     event_name VARCHAR(255),
                                     event_description TEXT,
                                     reference_url VARCHAR(1000),
                                     address VARCHAR(255),
                                     start_date DATE,
                                     start_time TIME,
                                     end_date DATE,
                                     end_time TIME,
                                     is_age_restricted BOOLEAN,
                                     is_public BOOLEAN,
                                     RSVPable BOOLEAN,
                                     image_url VARCHAR(225),
                                     is_reported BOOLEAN,
                                     category_id INT,
                                     FOREIGN KEY (category_id) REFERENCES categories(id),
                                     PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS hobbies(
                                      id INT NOT NULL AUTO_INCREMENT,
                                      hobby_name VARCHAR(255),
                                      PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS hobbies_users(
                                            user_id INT,
                                            hobby_id INT,
                                            FOREIGN KEY (user_id) REFERENCES users(id),
                                            FOREIGN KEY (hobby_id) REFERENCES hobbies(id)
);

CREATE TABLE IF NOT EXISTS events_hobbies(
                                             event_id INT,
                                             hobby_id INT,
                                             FOREIGN KEY (event_id) REFERENCES events(id),
                                             FOREIGN KEY (hobby_id) REFERENCES hobbies(id)
);

CREATE TABLE IF NOT EXISTS expertise(
                                        id INT NOT NULL AUTO_INCREMENT,
                                        expertise VARCHAR(255),
                                        description VARCHAR(500),
                                        PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users_events(
                                           user_id INT,
                                           event_id INT,
                                           is_owner BOOLEAN,
                                           expertise INT,
                                           FOREIGN KEY (user_id) REFERENCES users(id),
                                           FOREIGN KEY (event_id) REFERENCES events(id),
                                           FOREIGN KEY (expertise) REFERENCES expertise(id)
);

CREATE TABLE IF NOT EXISTS images(
                                     id INT AUTO_INCREMENT,
                                     url VARCHAR(255),
                                     image_description VARCHAR(255),
                                     event_id INT,
                                     PRIMARY KEY (id),
                                     FOREIGN KEY (event_id) REFERENCES events(id)

);