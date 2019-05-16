# first-rest-project
RESTful web service project with CRUD methods

---
**Technology Stack**

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
h2 Database

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

In result you must get the following graphic schema of the database:
![Graphic Schema of the Database](https://i.imgur.com/8m2QtUU.png)

To populate the new clean database `service` by data you must execute the following commands in SQL editor of MySQL Workbench.

The creation of 2 records in the table `dictionary`:
```sql
INSERT INTO `service`.`dictionary` (`discriminator`, `name`) VALUES ('role', 'user');
INSERT INTO `service`.`dictionary` (`discriminator`, `name`) VALUES ('role', 'admin');
```

The creation of 1 record in  the table `user`:
```sql
INSERT INTO `service`.`user` (`login`, `password`, `id_role`) VALUES ('user', 'qwerty', '2');
```

---
h2 Project Structure

---

> `src\main\resources` – resources directory
> `src\main\java` – sources directory

The main files, which directory `src\main\resources` contains:

* `db.properties` - file with definitions of MySQL, Hibernate and c3p0 library connection pooling properties

The main packages and files, which directory `src\main\java` contains in the package `com.example`:

> package `entities` - `@Entity` classes
* `User` - model class corresponding `user` table in the database

> package `model` - \[deprecated\] model classes from old project `helloworld`
* `Message` - \[deprecated\] model class for old project `helloworld` performance

> package `controller` - `@Controller` classes
* `UserController` - controller class for `User` class
* `MessageController` - \[deprecated\] controller class for old project `helloworld` performance

> package `service` - `@Service` classes
* `UserService` - service interface for `User` class
* `UserServiceImpl` - service class for for `User` class

> package `dao` - `@Repository` classes
* `UserDao` - DAO interface for `User` class
* `UserDaoImpl` - DAO class for `User` class

> package `confiruration` - `@Configuration` classes
* `WebConfiguration` - class for configuring the Spring MVC for application
* `AppConfiguration` - class for configuring the Hibernate ORM with Spring MVC application
* `WebInitializer` - class for initialization of Servlet container (used instead of web.xml)
