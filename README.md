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



## Notes:

1. The session type does not persist over sessions. In order to do that, the session type must be stored in a database or the system properties must be changed dynamically. It will only take affect after the application restarts.




### Working Video

https://streamable.com/py56g
