# first-rest-project
RESTful web service project with CRUD methods

---
Folder with MySQL database creation and data populating commands – FirstRestProject/src/main/resources/database/

initDB.sql //creation of database and tables
popDB.sql //data populating in database tables

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
