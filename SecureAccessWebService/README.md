# Project SecureAccessWebService

## Description
This project is a part of the course "API and Webservice" at Campus Mölndal, Sweden.
This project is a Java-based RESTful API server, configured using Maven, designed to provide CRUD functionality with a local database for data storage.
The API exposes endpoints for the client to perform CRUD operations on the database.
The API is secured using JWT tokens and the client must provide a valid token to access the endpoints.
Depending on the role of the user, the client can access different endpoints. 
CRUD operations can be performed on the user and order table by the admin, and only read and create operations can be performed by the user.
The CRUD operations can be performed on the user entity and the order entity.


## Installation
#### Javaversion: 17 java version 17.0.1
#### Database: MySQL
#### API platform: Postman
+ Download and install [IntelliJ](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
+ Download and install [MySQL](https://dev.mysql.com/downloads/mysql/)
+ Download and install [Postman](https://www.postman.com/downloads/)
+ Clone the projects on GitHub [SecureAccessWebService](https://github.com/clarabrorson/SecureAccessWebService)
+ Open the project in your IDE
+ Create a database in MySQL with the name "security"
+ Change the username and password in the application.properties file to your own username and password.
+ Launch Spring Boot from the SecureAccessWebServiceApplication.java
#### User access:
+ Open Postman and create a POST request to http://localhost:8080/auth/register with the following body:
```
{
    "username": "your name",
    "password": "your password"
}
```
+ Create a POST request to http://localhost:8080/auth/login with the same body as above.
+ Copy the token from the response.
+ Use the token as a Bearer token in the Authorization tab in Postman.
+ Use Postmans different methods to access the endpoints. (GET, POST)

#### Endpoints for user:
+ http://localhost:8080/user/
+ http://localhost:8080/user/users
+ http://localhost:8080/user/{id}
+ http://localhost:8080/user/createOrder
+ http://localhost:8080/user/allOrders
+ http://localhost:8080/user/order/{id}

#### Admin access:
+ Open Postman and create a POST request to http://localhost:8080/auth/login with the following body:
```
{
    "username": "admin",
    "password": "password"
}
```
+ Copy the token from the response.
+ Use the token as a Bearer token in the Authorization tab in Postman.
+ Use Postmans different methods to access the endpoints. (GET, POST, PUT, DELETE)

#### Endpoints for admin:
+ http://localhost:8080/admin/
+ http://localhost:8080/admin/users
+ http://localhost:8080/admin/{id}
+ http://localhost:8080/admin/delete/{id}
+ http://localhost:8080/admin/update (Include payload in Body -> raw -> JSON) {id, username, password}
+ http://localhost:8080/admin/order/{id}
+ http://localhost:8080/admin/allOrders
+ http://localhost:8080/admin/createOrder
+ http://localhost:8080/admin/deleteOrder/{id}
+ http://localhost:8080/admin/updateOrder (Include payload in Body -> raw -> JSON) {id, productName, quantity}


## Execution
To run the program, open the project in your IDE and run the SecureAccessWebServiceApplication.java 

## Dependencies
+ Spring Boot Starter Web
+ Spring Boot Starter Data JPA 
+ Spring Boot Starter Security
+ Spring Boot Starter OAuth2 Resource Server
+ Spring Boot Starter Crypto
+ MySQL Connector Java
+ Spring Boot Starter Test
+ Spring Boot Starter Security Test

## Credits
The project is based on the following repository:
[Unknownkoder - Spring security login system](https://github.com/unknownkoder/spring-security-login-system)

## License
[MIT License](https://choosealicense.com/licenses/mit/)



