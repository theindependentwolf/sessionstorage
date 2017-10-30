# Session Storage
# Session Storage

This application is used to demonstrate session storage. It currently has two options, mysql and redis.

## Requirements

1. MySQL
2. Redis
3. STS (Spring Tool Suite) or an IDE
4. Maven


## Environment

1. Linux Ubuntu


## SetUp Instructions

1. Install MySQL ($sudo apt-get install mysql-server) and Redis (https://www.digitalocean.com/community/tutorials/how-to-install-and-configure-redis-on-ubuntu-16-04)

2. Download the project repository using git clone or just download the zip file.

3. Import the project in STS or create a maven project and copy the respective files from the download.

4. Configure application.properties file with MySQL and Redis credentials. 

5. Set system parameter in RunTimeConfiguration  (-DsessionType=mysql). There are two options as of now; 'mysql' or 'redis'.

6. Run the Spring Boot application or export the project as war using Maven build. 


## MySQL and Redis Config 

1. MySQL

Create a database for your project to use the name in the URL. (CREATE DATABASE <database name>). Create a mysql user with access to that database and add the following to the aplication.properties file.  

#MySQL Config - DO NOT USE "ROOT". THIS IS ONLY FOR EXAMPLE.

spring.jpa.hibernate.ddl-auto=create

spring.datasource.url=jdbc:mysql://localhost:3306/scenedoc

spring.datasource.username=user

spring.datasource.password=pwd

2. Redis

These are the defaults for Redis

#Redis Config

spring.redis.host=localhost

spring.redis.password=secret

spring.redis.port=6379



## Build/Deploy Instructions

1. To do a maven build, download project, go to the same location as the pom.xml file and run the following command. 

$mvn package

This creates a jar in the project folder with the same name as the artifact name in the pom.xml file. 


2. Go to the target folder containing the jar and run the application using the following command (replace with your jar file name if necessary)

$java -jar gs-spring-boot-0.1.0.jar



## Notes:

1. The session type does not persist over sessions. In order to do that, the session type must be stored in a database or the system properties must be changed dynamically. It will only take affect after the application restarts.

2. The Redis storage doesn't really work. It just redirects to the MySQL storage. 




### Working Video

https://streamable.com/py56g
