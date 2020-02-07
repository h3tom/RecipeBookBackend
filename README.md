# Recipe Book Backend
###### #JAVA #Spring Boot, Data, Security #Hibernate #MySQL #jjwt #REST #JSON

Spring boot REST API backend for Recipe Book application. Secured with (Java) JSON Web Token (in ver. 2).

| HTTP method | Resource | Details |
| --- | --- | --- |
| POST  | /auth/signin | Log in User |
| POST  | /auth/signup | Sign up new User |
| GET  | /recipe/{id} | Return a Recipe with given id |
| GET  | /recipe/all | Return all Recipes |
| POST  | /recipe | Create a new Recipe |
| PUT  | /recipe | Update a Recipe |
| DELETE  | /recipe/{id} | Delete a Recipe with given id |

#### Ver 2.0

Major changes:
+ Added authorization and security with (Java) JSON Web Token
+ Created new Controller for Authorization
+ Created new Entities User and Role
+ Created DTOs
+ Created Converters (Entity/DTO -> DTO/Entity)
+ Created needed services and repositories

#### Ver 1.0 (till 06.02.2020)

Simple backend without authorization. Two Entities and and Controller with CRUD methods (nothing fancy).
