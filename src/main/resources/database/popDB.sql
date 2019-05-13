/*
creation of 2 records in  the table 'dictionary'
*/
INSERT INTO `service`.`dictionary` (`discriminator`, `name`) VALUES ('role', 'user');
INSERT INTO `service`.`dictionary` (`discriminator`, `name`) VALUES ('role', 'admin');

/*
creation of 1 record in  the table 'user'
*/
INSERT INTO `service`.`user` (`login`, `password`, `id_role`) VALUES ('user', 'qwerty', '2');