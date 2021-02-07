**welcome to the Task List app**

Here's the documentation of the app 

* **Application Description**
- This app responsible for monitoring the development process of the buildings for Golden Real Estate Company 
depending on the status for every activity per the person (employee)

* **Assumptions :** No assumptions , just using java flyway-db dependency to init dummy data into db
  <hr>
*  **Application features** 

- Able to monitor the progress of the company activities per building
- Able to monitor the progress of the building
- Status entity for adding more status in the future with colors for better user interface
- Using docker-compose for fast productivity  
- Good  UI/ UX design 
- d3.js charts for a monitor the activity per user 
- Search bar to search by name in the projects' grid view
  <hr>

*  **Tech stack** 
   
  - Java Spring Boot for BE 
  - VueJs for FE
  - d3 for charts visualisation
  - postgres for db 
  - docker to create postgres container
  - swagger for docs 

*  **How to run the app** 

1- clone the app `git clone git@github.com:ahmedamasha/REIT.git`

**FE (vuejs , yarn)**

 - go to home of the project  `cd REIT/reit_web` then `yarn install` then `yarn run build`

- back to `REIT/` As long as am using spring boot as BE so it has jetty embedded server , and configured ,


<br><br>
in console once you run using this CMD : `mvn spring-boot:run`   on jetty embedded  server
 <br>
After running the app ,  for BE , you will find all endpoints with docs here in swagger

`http://localhost:5500/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#`

<br>

<hr>

you will notice
<br><br>
`2021-02-06 18:45:03.374  INFO 33843 --- [           main] o.s.b.web.embedded.jetty.JettyWebServer  : Jetty started on port(s) 5500 (http/1.1) with context path '/'
`

<hr>

**_Bonus_**

- Using d3 library for visualization with charts in home page for activities per an employee that assigned to + some analytics and number refer to the progress.


* **Use Docker**
      
    - Using docker-compose file **Recommended in development**
    - cd REIT , then run `mvn clean install` &  run `docker-compose build` or directly  `docker-compose up`
    - then the project exposed to 5500 port 
    - then hit `http://localhost:5500/#/home`
  <hr>

    - U can also run (Docker Native) For DB (postgres) : 


`docker run --name postgresql -p 5432:5432  -e POSTGRESQL_USERNAME=Sylvain -e ALLOW_EMPTY_PASSWORD=yes  -e POSTGRESQL_DATABASE=test  bitnami/postgresql:latest`
 
  then create `tests`  db manually 
  
<hr>

 **Image from the product :**  

![alt text](./doc/img_1.png)

<hr>

![alt text](./doc/img_2.png)