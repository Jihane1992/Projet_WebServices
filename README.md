#Jihane HARKATI

#Spring Boot APis API with Spring Boot, Mysql, JPA and Hibernate
This project was developed using SpringBoot Spring Initializr and the following dependencies were selected:

    ### 1 Web
    ### 2 JPA
    ### 3 Lombok
   
In this zip,there are 3 minis projects: service rest, service soap and client

#Requirement 

    ### Java - 1.8.x
    ### Maven - 3.x.x
    ### Mysql - 5.x.x

#Steps to Setup

# Rest Service

## 1. create a database in mysql "hotel_webservices"

    Create database hotel_webservices;
    
## 2. Change some informations in  src/main/resources/application.properties

    1.mysql username and password as per your installation
     change spring.datasource.username and  
     spring.datasource.password as per your mysql installation
   
    2.spring.jpa.hibernate.ddl-auto=create  for the first running
    but after you have to chnage it in update 
   
## 3. Launch the rest service and interact with it

From the project root folder, run the command below to launch the application:

$ mvn clean spring-boot:run
The app will start running at http://localhost:9191.

Explore Rest API

The app defines following CRUD API.

GET http://localhost:9191/deletebookinghotel/{idreservation}

POST http://localhost:9191/addUserer
        {  
    "email":"jihane.negoce@gmail.com",
    "password":"test",
    "firstname":"test",
    "lastname":"test",
    "phone":"0668580094",
    "adresse":"rue à Fontainebleau"
    }
    
GET http://localhost:9191/bookingall/

GET http://localhost:9191/hotel/{id}

GET localhost:9191/hotels/filter?datein=2020-11-18&dateout=2020-11-30&nbrroom=5

GET http://localhost:9191/savebookinghotel?datein=2020-11-18&dateout=2020-11-23&idhotel=7&iduser=3&nbroom=3

You can test them using postman or any other rest client.

## 4. Launch the soap service and interact with it

From the Soap project root folder, run the command below to launch Soap service:
mvn spring-boot:run

The app will start running at http://localhost:8087

WSDL : http://localhost:8087/ws/hotelbooking.wsdl

you can test it with a client like Soapui or any other soap client.

#HotelBooking Client

Created By the tools used in your course :Axis2: Tomcat v7.0 Sever

after importing the client in eclipse , right click on the ClientMain class, select Run As → Java Application, if you get “Welcome to Hotel Booking
Enter your name : ” in the console, you are successful.




