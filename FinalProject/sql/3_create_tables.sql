USE `series_catalog_db` ;

CREATE TABLE `users` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `login` VARCHAR ( 32 ) NOT NULL UNIQUE , `password` VARCHAR ( 255 ) NOT NULL , `role` TINYINT NOT NULL CHECK ( `role` IN ( 0 , 1 , 2 ) ) , PRIMARY KEY ( `id` ) ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `countries` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `name` VARCHAR ( 255 ) NOT NULL , PRIMARY KEY ( `id` ) ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `categories` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `name` VARCHAR ( 255 ) NOT NULL , PRIMARY KEY ( `id` ) ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `user_info` ( `user_id` INTEGER NOT NULL UNIQUE , `country_id` INTEGER , `email` VARCHAR ( 255 ) UNIQUE , `sex` CHAR ( 1 ) CHECK ( `sex` IN (  'м' ,   'ж' ) ) , `birth_date` DATE , FOREIGN KEY ( `user_id` ) REFERENCES `users` ( `id` ) ON
UPDATE CASCADE ON
DELETE
CASCADE,
FOREIGN KEY ( `country_id` ) REFERENCES `countries` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `serials` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `name` VARCHAR ( 255 ) NOT NULL , `premier_date` DATE NOT NULL , `image_path` VARCHAR ( 255 ) , `description` TEXT , `country_id` INTEGER , `category_id` INTEGER , PRIMARY KEY ( `id` ) , FOREIGN KEY ( `country_id` ) REFERENCES `countries` ( `id` ) ON
UPDATE CASCADE ON
DELETE
RESTRICT,
FOREIGN KEY ( `category_id` ) REFERENCES `categories` ( `id` ) ON
UPDATE CASCADE ON
DELETE RESTRICT ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `see_later` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `user_id` INTEGER NOT NULL , `serial_id` INTEGER NOT NULL , PRIMARY KEY ( `id` ) , FOREIGN KEY ( `user_id` ) REFERENCES `users` ( `id` ) ON
UPDATE CASCADE ON
DELETE
CASCADE,
FOREIGN KEY ( `serial_id` ) REFERENCES `serials` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;

CREATE TABLE `watched_serials` ( `id` INTEGER NOT NULL AUTO_INCREMENT , `user_id` INTEGER NOT NULL , `serial_id` INTEGER NOT NULL , PRIMARY KEY ( `id` ) , FOREIGN KEY ( `user_id` ) REFERENCES `users` ( `id` ) ON
UPDATE CASCADE ON
DELETE
CASCADE,
FOREIGN KEY ( `serial_id` ) REFERENCES `serials` ( `id` ) ON
UPDATE CASCADE ON
DELETE CASCADE ) DEFAULT CHARACTER SET utf8;