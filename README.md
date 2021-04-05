# user-service
User Information for the Message Service

## Messaging Service API
This API is a Spring Boot application with MongoDB backend. This application is developed with [Level 2 of the Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html) in mind.


## Architecture
The Architecture shows the high level visual display of how each component work together, but this project only contains the Spring boot REST API how how it connects to the MongoDB database backend. The frontend is not implemented, but could be implemented with React.js, Angular or VUE.js frontend or any other frontend frameworks whenever needed.

![Architecture of the project](https://persistentminds.com/wp-content/uploads/2021/04/Messaging-Service.png)

## Scope of the Project
The following contains the list of the functionalities of the application:
* This application creates users
* It also gets all users
* It gets users by Username 
* The other application is [Message-Service project](https://github.com/ademolakazeem/messaging-service.git) on this repository.


## Out of Scope
* Because of time constraints, this project does not have test cases
* You can find a small number of test cases that tests save and find all for both `MessageService` and `MessageController` in [Message-Service project](https://github.com/ademolakazeem/messaging-service.git) on this repository
* The whole essence of this test is to show that this could be implemented

## Requirements  (Prerequisites)
Before you can run this application, you need to first install the following:
* Maven
* MongoDB database
* [Message-Service project](https://github.com/ademolakazeem/messaging-service.git) is the completion of this project that handles actual messaging

## Deployment
Here are steps taken to be able to run this project successfully:

Please see the [Deployment section of the messaging-service ReadMe](https://github.com/ademolakazeem/messaging-service/blob/main/README.md) on how to deploy this application using docker

or

* Clone or Download this project
* Start your MongoDB database
* Open the Application.properties in this project and create the database using the name in the Application.properties (UserDB)
* Make sure that the port address is the same with one in the properties file (27017)
* Run `$ mvn clean install` in order to build the project
* Next, Run `$ mvn spring-boot:run` to run the Spring Boot application
* If everything goes as planned, your application should be able to open in port: 8880
* Please do not forget to add swagger-ui.html in front of the localhost: e.g. http://localhost:8880/swagger-ui.html

## Video Demo of the application
Please click on the image below in order to view a short Video Demo of the application.

[![Watch the video](https://persistentminds.com/wp-content/uploads/2021/04/Messaging-Service.png)](https://youtu.be/RSD8-FDedQo)

