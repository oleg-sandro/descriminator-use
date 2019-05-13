/*
creation of the database 'service'
*/
CREATE SCHEMA `service` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

/*
creation of the table 'dictionary'
*/
CREATE TABLE `service`.`dictionary` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `discriminator` VARCHAR(15) NULL,
  `name` VARCHAR(31) NOT NULL,
  `ext_id` INT,
  PRIMARY KEY (`id`));

/*
creation of the table 'user'
*/
CREATE TABLE `service`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(31) NOT NULL,
  `password` VARCHAR(63) NOT NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id`));

/*
adding of new foreign key for table 'user'
*/
ALTER TABLE `service`.`user`
ADD INDEX `fk_dictionary_user_idx` (`id_role` ASC) VISIBLE;
;
ALTER TABLE `service`.`user`
ADD CONSTRAINT `fk_dictionary_user`
  FOREIGN KEY (`id_role`)
  REFERENCES `service`.`dictionary` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
