# Functionality : Exposes a very simple REST service
This repo contains a spring boot based very simple REST service which exposes the below endpoint:
/api/1/profile/{customerName}


# Technical details and Pre-requisites
- Written using Spring Boot framework and Java.



# How to run locally
- Clone / checkout this branch (branch-2a) to your laptop
- Ensure that you have JDK22 and Maven3.8.5 available
- Now compile the spring boot project using the below command:
  (`mvn clean package -DskipTests`)
- Now run the spring boot project using the below command :
  (`java --enable-preview -jar target/sb-backend-0.0.1-SNAPSHOT.jar`)
- Now access the below URL:
  (`curl  http://localhost:8080/api/1/profile/Dany`)

curl http://localhost:8080/api/1/bank-customers/name1
curl -H 'Content-Type: application/json' -d '{ "loginName":"user1","password":"password", "name": "name1", "age": 41, "city": "kolkata", "state": "wb", "profession": "service"}' -X POST http://localhost:8080/api/1/bank-customers
curl -H 'Content-Type: application/json' -d '{ "loginName":"user2","password":"password", "name": "name2", "age": 42, "city": "kolkata", "state": "wb", "profession": "service"}' -X POST http://localhost:8080/api/1/bank-customers
