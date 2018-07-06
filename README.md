# Bravi Test solution

### Technologies

- Java 8
  - Spring-boot
  - Spring MVC
  - Spring Data
  - Lombok
  - Jackson
  - Swagger
  - maven
  - spock framework
  - Junit
  - mockito  
- ReactJs
  - TypeScript
  - Angular 5
  - SASS
  - Angular CLI
- Docker
  - nginx

That solution is compose by 3 different applications

First one
### Brackets
   This application is a java application 
   All test are passing. 
   You can see this application running in tests cases

### Person
  This application is a java 8 application with spring-boot framework.
  Basically that application expose Rest Endpoints where it's possible to realize ao CRUD operations to manipulate Person entity.

There are 3 way to run Person application.

1 - running jar 
That way you must have java 8 installed.
Inside the folder dist in project folder have a file named person.jar, you can copy file anywhere you want and run the follow command.
`java -jar person.jar`

2 - running with maven
That way you must have java 8 installed and maven installed.
Inside the folder `person` in project folder run the follow command.
`mvn spring-boot:run`

3 - running with docker
That way you must have docker installed
Inside the project folder root run the follows commands
`docker build -t bravi-solution .`

after the image built

`docker run -p 80:80 -p 8080:8080 bravi-solution`

for all ways after application deployed

access http://localhost:8080

you will be redirect to swagger api description.

###Weather
This application is a angular 5 aplication.
This application has a HTML 5 interface where is possible to inform a city name in English and will show the weather current in city informed

Taking in hands the services provided by http://openweathermap.org/api

thera are 2 ways to run wether application

1 - running with npm and nodejs
That way you must have installed NodeJs version 8.* or higher.
Inside the `wether`folder execute the folloes commands
  `npm install`
after all dependencies installed
  `npm start`
and to access the application
  http://localhost:4200

2 - running with docker
That way you must have docker installed
Inside the project folder root run the follows commands
`docker build -t bravi-solution .`

after the image built

`docker run -p 80:80 -p 8080:8080 bravi-solution`

After application deployed

access http://localhost

any question please email me: erick.p.rocha@gmail.com