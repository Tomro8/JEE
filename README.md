# Final Project JEE: V1 





## Before starting the project

As discussed with you, we decided to use a **MySQL** database also for the version 1 of the project.
Please follow those steps to run our application:



In **Netbeans**: Clone Project from **GitHub Repository** https://github.com/Tomro8/JEE

- You have to specify the path for a dependency with file `mysql-connector-java-5.1.23-bin.jar` that is located in the root folder of this repository (`\JEE-master\mysql-connector-java-5.1.23-bin.jar`):
  - to do so either right click on project and find "resolve dependancy problems" and indicate the path to that file
  - or right click on project, go to properties, then library, and add the file to the libraries of the project
- You need to host the database. Therefore 
  - launch "Wamp" and either a create profile corresponding to the db information located in `JEE-master\Projet_v1\src\java\jee\model\utils\db.properties`. Or change values in this file.
  Please mind the port number
  - import our database located in : `JEE-master\Projet_v1\web\WEB-INF\projet.sql`
- Application is ready to be built.




# Final Project JEE: V2




## Before starting the project

For the V2 of the project we had some difficulties using JPA on Netbeans.
But we managed to run it on Eclipse using **Tomcat 8.5** (instead of Glassfish for V1)
We are still using **MySql**

This is a **Maven** project. Since we use JPA, all information related to the database can be find in the file `JEE-master\src\main\resource\META-INF\persistance.xml` therefore we removed the **db.properties** file.

We did not manage to put the project on AWS or on any cloud platform.
In the pipeline, we have been as far as **Jenkins**. You can find a file explaining how we configured Jenkins: `rootRepo\Jenkins.pdf`

You may have to do some trouble shooting if you want to run the project on Eclipse regarding the properties of the project: the java build path and project facets.
Java 1.7 is required
