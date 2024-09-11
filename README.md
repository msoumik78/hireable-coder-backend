# Functionality : Exposes the transaction history and transfer service
This repo contains a spring boot based simple REST service which has endpoints for:
- Displaying list of transactions
- Create a transfer


# Technical details and Pre-requisites
- Written using Spring Boot framework and Java



# How to run locally
- Clone / checkout this branch (branch-4) to your laptop
- Ensure that you have JDK22 and Maven3.8.5 available
- Now compile the spring boot project using the below command:
  (`mvn clean package -DskipTests`)
- Now run the spring boot project using the below command :
  (`java --enable-preview -jar target/bank-customers-transaction-1.0-SNAPSHOT.jar`)
- Now create 2 transactions for customerId =2 so that these transactions show up in the transaction history page:
curl -H 'Content-Type: application/json' -d '{ "customerId" : 1, "fromAccount":"1111155555","toAccount":"22224444", "amount":20,"transactionDate":"2024-09-12"}' -X POST http://localhost:8085/api/1/transactions
curl -H 'Content-Type: application/json' -d '{ "customerId" : 1, "fromAccount":"1111155555","toAccount":"999999999", "amount":5,"transactionDate":"2024-05-12"}' -X POST http://localhost:8085/api/1/transactions

