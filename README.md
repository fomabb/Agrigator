# Agrigator
# RESTful Web-application is written using the following technologies: 
  - Maven 
  - Hibernate 
  - PostgresSQL DB 
  - Spring Boot
  - Spring Security
  - JSOUP
### Short description of the project
  - Standalone application providing REST API

### Prerequisites:
- Java 19
- PostgresSQL

# Data model
## ER diagram for the data model

![redm_db.png](src/main/resources/img/readme_db.png)

## RESTful API

**1. API Description of general methods for Products**

METHOD | PATH | DESCRIPTION
------------|-----|------------
GET | /api/product/find/all | get all products
GET | /api/product/find/{id} | get product by id
GET | /api/product/find/title | product search by by title
GET | /api/product/find/category | get product by category

**2. API Description of general methods for Products only for admin**

METHOD | PATH               | DESCRIPTION
------------|--------------------|------------
POST | /login             | visit to admin page
POST | /logout            | exit from admin page
GET | /admin/find/all    | get all products
GET | /admin/user/all    | get all users
DELETE | /admin/delete/{id} | delete product by id
DELETE | /admin/clean       | clean db

**3. API Description of test methods for Products**

METHOD | PATH                                        | DESCRIPTION
------------|---------------------------------------------|------------
GET | /api/product/category/drive_technology      | get products by category Drive technology
GET | /api/product/category/everything | get products by category everything else you need
GET | /api/product/test                           | get all products DTO for test

### My application requests in Postman
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/d9af219fea3fe665c736?action=collection%2Fimport)
