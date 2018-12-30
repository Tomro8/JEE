#Final Project JEE: V1 





##Before starting the project

As discussed with you, we decided to use a **MySQL** database also for the version 1 of the project.
Please follow those steps to run our application:



In **Netbeans**: Clone Project from **GitHub Repository** https://github.com/Tomro8/JEE_v1


- You have to specify the path for a dependency with file mysql-connector-java-5.1.23-bin.jar that is located in the root folder of this repository (\Repo_Projet_V1\mysql-connector-java-5.1.23-bin.jar):
  - to do so either right click on project and find "resolve dependancy problems" and indicate the path to that file
  - or right click on project, go to properties, then library, and add the file to the libraries of the project

- You need to host the database. Therefore 
  - launch "Wamp" and either a create profile corresponding to the db information located in Repo_Projet_V1\Projet_v1\src\java\jee\model\utils\db.properties. Or change values in this file
  - import our database located in : Repo_Projet_V1\Projet_v1\web\WEB-INF\projet.sql

- Application is ready to be built.