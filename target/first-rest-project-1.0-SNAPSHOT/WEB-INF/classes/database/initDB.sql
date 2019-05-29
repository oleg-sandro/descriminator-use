--
-- Database creation with name `service`
--

CREATE SCHEMA `service` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `service`;

--
-- Table structure for table `dictionary`
--

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discriminator` varchar(15) NOT NULL,
  `name` varchar(31) NOT NULL,
  `ext_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_dictionary` (`discriminator`,`name`)
);

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(31) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id_role` int(11) NOT NULL,
  `name` varchar(31) DEFAULT NULL,
  `surname` varchar(31) DEFAULT NULL,
  `email` varchar(31) NOT NULL,
  `birth` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_user_username` (`username`),
  UNIQUE KEY `un_user_email` (`email`),
  KEY `fk_user_dictionary_idx` (`id_role`),
  CONSTRAINT `fk_user_dictionary` FOREIGN KEY (`id_role`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(127) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `country` varchar(31) DEFAULT NULL,
  `producer` varchar(31) DEFAULT NULL,
  `genre` varchar(15) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `when_start` timestamp NOT NULL,
  `when_finish` timestamp NOT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;

CREATE TABLE `hall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `description` varchar(127) DEFAULT NULL,
  `rows` varchar(45) NOT NULL,
  `cols` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_hall` (`number`)
);

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hall` int(11) NOT NULL,
  `row` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_seat` (`id_hall`,`row`,`number`),
  KEY `fk_seat_hall_idx` (`id_hall`),
  CONSTRAINT `fk_seat_hall` FOREIGN KEY (`id_hall`) REFERENCES `hall` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;

CREATE TABLE `session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_film` int(11) NOT NULL,
  `when_start` timestamp NOT NULL,
  `id_hall` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_session` (`when_start`,`id_hall`),
  KEY `fk_session_film_idx` (`id_film`),
  KEY `fk_session_hall_idx` (`id_hall`),
  CONSTRAINT `fk_session_film` FOREIGN KEY (`id_film`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_session_hall` FOREIGN KEY (`id_hall`) REFERENCES `hall` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_session` int(11) NOT NULL,
  `id_seat` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_ticket` (`id_session`,`id_seat`),
  KEY `fk_ticket_user_idx` (`id_user`),
  KEY `fk_ticket_session_idx` (`id_session`),
  KEY `fk_ticket_seat_idx` (`id_seat`),
  CONSTRAINT `fk_ticket_seat` FOREIGN KEY (`id_seat`) REFERENCES `seat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ticket_session` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ticket_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);
