# Agrigator
# RESTful Web-application is written using the following technologies: 
  - Maven 
  - Hibernate 
  - PostgresSQL DB 
  - Spring Boot
### Short description of the project
  - Standalone application providing REST API

### Prerequisites:
- Java 19
- PostgresSQL

# Data model
## ER diagram for the data model


## RESTful API

**1. API Description of general methods for Products**

METHOD | PATH | DESCRIPTION
------------|-----|------------
POST | /api/users | register new employee
DELETE | /api/users/{id} | delete user by id
PUT | /api/users/{id} | update department by id
GET | /api/product/find/all | get all products
GET | /api/product/find/{id} | get product by id
GET | /api/product/find/title | product search by by title
GET | /api/product/find/category | get product by category

**2. API Description of general methods for Products only for admin**

METHOD | PATH | DESCRIPTION
------------|-----|------------
POST | /api/product/save | save new products
DELETE | /api/product/delete/{id} | delete product by id
DELETE | /api/clean | clean db

**3. API Description of test methods for Products**

METHOD | PATH | DESCRIPTION
------------|-----|------------
GET | /api/product/category/drive_technology | get products by category Drive technology
GET | /api/product/category/automation_technology | get products by category Automation_technology

### My application requests in Postman
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/d9af219fea3fe665c736?action=collection%2Fimport)