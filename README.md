# CapitoleConsulting Test Code

## Installation
Import with IDE as a Maven Project

## Database
Can access to h2 console on: http://localhost:8080/h2-console

Used FLYWAY as a database tool migration

## Execution
Run EcommerceApplication.java

## Example of request: 

http://localhost:8080/getPrice?applicationDate=2020-06-14%2010:00:00&productId=35455&brandId=1

## Tests
Test 5 cases scenarios mentioned in the document:

Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)

Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)

Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)

Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)


