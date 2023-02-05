# Nirmitee-PreInterview-Task
Nirmitee PreInterview Task

Spring Boot Starter
This springboot starter project is using jpa and web modules of spring boot to interact with database and exposing REST endpoints for distribution.
It is using some userful libraries which works very well with springboot and makes your development easy.

# Datebase : postresql
This project uses postresql as database for handling CRUD request at Persistense layer. 

Lombok
Using Lombok library is very userful which auto generates getter/setter and implements toString() and hashCode() methods of your model libraries at compile time. It keeps the model classes neat and clean. See the usage of @Data annotation in entity User.java and model classes.
Need to install lombok plugin in IDE tool. For intellij download the lombok.jar From terminal execute the jar
$ java -jar lombok.jar

# Project Description

This spring boot project handles vehicle databases and provide a complete REST view endpoints for End-use and have the below functionalitites

- REST api exploring basic main HTTP verbs
- API Error Handling (Handled through HttpStatus provided by package - org.springframework.http.HttpStatus, Haven't created seperate class for this)
- Unit Test (write one unit testcase, will add more)


# POSTMAN - REST Api testing

All the REST endpoints are tested through Postman application.


# Unit Testing

- Added some unit testing for demo purpose, will add more



