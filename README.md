# Functionality : Asynchronously receives payment notifications and updates balance 
This repo contains a spring boot based service which listens for an incoming message and updates the database.


# Technical details and Pre-requisites
- Written using Spring Boot framework and Java.
- NATS server running at port 4222



# How to run locally
- Clone / checkout this branch (branch-5b) to your laptop
- Ensure that you have JDK22 and Maven3.8.5 available
- Now compile the spring boot project using the below command:
  (`mvn clean package -DskipTests`)
- Now run the spring boot project using the below command :
  (`java --enable-preview -jar target/bank-customers-core-main-1.0-SNAPSHOT.jar`)
- Now populate some profile data of some customers using below commands:
curl -H 'Content-Type: application/json' -d '{ "loginName":"user1","password":"password", "name": "name1", "age": 41, "city": "kolkata", "state": "wb", "profession": "service", "email": "name1@gmail.com", "address": "Park Street Kolkata 700002"}' -X POST http://localhost:8080/api/1/bank-customers
curl -H 'Content-Type: application/json' -d '{ "loginName":"user2","password":"password", "name": "name2", "age": 42, "city": "kolkata", "state": "wb", "profession": "service" , "email": "name2@gmail.com", "address": "Hyatt Mumbai"}' -X POST http://localhost:8080/api/1/bank-customers
- Now populate some products data for the corresponding customer profiles using below commands:
curl -H 'Content-Type: application/json' -d '{ "customerId":1, "productName": "ACCOUNT", "productNumber": "11111188888", "productBalance": 100.8}' -X POST http://localhost:8080/api/1/products
curl -H 'Content-Type: application/json' -d '{ "customerId":1, "productName": "ACCOUNT", "productNumber": "44444222222", "productBalance": 200}' -X POST http://localhost:8080/api/1/products
