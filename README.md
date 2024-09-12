# Functionality : Creates a JWT on log in and verifies the JWT on subsequent reqyuests
This repo contains a spring boot based simple REST service which has capabilities for:
- Creating a JWT during login
- Validating


# Technical details and Pre-requisites
- Written using Spring Boot framework and Java.
- JWT creation and validation done using nimbus library (https://connect2id.com/products/nimbus-jose-jwt)



# How to run locally
- Clone / checkout this branch (branch-2a) to your laptop
- Ensure that you have JDK22 and Maven3.8.5 available
- Now compile the spring boot project using the below command:
  (`mvn clean package -DskipTests`)
- Now run the spring boot project using the below command :
  (`java --enable-preview -jar target/bank-customers-core-main-1.0-SNAPSHOT.jar`)
- Now populate some profile data of some customers using below commands:
curl -H 'Content-Type: application/json' -d '{ "loginName":"user1","password":"password", "name": "name1", "age": 41, "city": "kolkata", "state": "wb", "profession": "service"}' -X POST http://localhost:8080/api/1/bank-customers
curl -H 'Content-Type: application/json' -d '{ "loginName":"user2","password":"password", "name": "name2", "age": 42, "city": "kolkata", "state": "wb", "profession": "service"}' -X POST http://localhost:8080/api/1/bank-customers
- Now populate some products data for the corresponding customer profiles using below commands:
curl -H 'Content-Type: application/json' -d '{ "customerId":1, "productName": "ACCOUNT", "productNumber": "11111188888", "productBalance": 100.8}' -X POST http://localhost:8080/api/1/products
curl -H 'Content-Type: application/json' -d '{ "customerId":1, "productName": "ACCOUNT", "productNumber": "44444222222", "productBalance": 200}' -X POST http://localhost:8080/api/1/products
