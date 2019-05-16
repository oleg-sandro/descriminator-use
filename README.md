# first-rest-project
RESTful web service project with CRUD methods
---
Technology stack
---
* Java 8
* Intellij IDEA
* MySQL
* MySQL Workbench
* Spring MVC
* Hibernate
* Maven
* Tomcat
* Git

---
Database
---
To create a clean database with 2 tables inside (`dictionary` and `user`) you must execute the following commands in SQL editor of MySQL Workbench. 

The creation of the database `service`:
```sql
CREATE SCHEMA `service` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
```

The creation of the table `dictionary`:
```sql
CREATE TABLE `service`.`dictionary` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `discriminator` VARCHAR(15) NULL,
  `name` VARCHAR(31) NOT NULL,
  `ext_id` INT,
  PRIMARY KEY (`id`));
```

The creation of the table `user`:
```sql
CREATE TABLE `service`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(31) NOT NULL,
  `password` VARCHAR(63) NOT NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id`));
```

The adding of a new foreign key for table `user`:
```sql
ALTER TABLE `service`.`user`
ADD INDEX `fk_dictionary_user_idx` (`id_role` ASC) VISIBLE;
;
ALTER TABLE `service`.`user`
ADD CONSTRAINT `fk_dictionary_user`
  FOREIGN KEY (`id_role`)
  REFERENCES `service`.`dictionary` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
```


---
File with database connection properties:
FirstRestProject/src/main/resources/db.properties

---
Folder with Java sources - FirstRestProject/src/main/java/com/example/ 

package entities - Entity-classes:
    class User - model class from MySQL database
    
package controller - Controller-classes:
    UserController - controller for User class
    
package service - Service-classes:
    interface UserService - service interface
    class UserServiceImp - service class
    
package dao - Repository-classes:
    interface UserDao - dao interface
    class UserDaoImpl - dao class
    
package configuration - Configuration-classes:
    class WebConfiguration - Spring configuraion class
    class AppConfiguration - Hibernate ORM ocnfiguration class
    class WebInintializer - class with initialization of servlet container (opposed to web.xml)
