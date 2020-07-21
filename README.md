# RetailManagementApplication

## Technologies
1. Spring Boot 
2. Mongo DB
3. Maven 

## Build the project

1. Install latest maven on your system
2. Make sure maven is correctly
   mvn --version
3. Browse to a folder in the project where pom.xml is located 
   cd <project_location>/pom.xml
4. Execute below command to build maven project. 
   mvn clean install
5. For running Spring boot application, choose either A or B given below.
   
## A) Run the project using maven command

1. Execute below command
   mvn spring-boot:run
2. Browse to http://localhost:8080/swagger-ui.html
3. Swagger will run on this given url.
4. On swagger, list of APIs will be available with sample data

## B) Create a jar and then run the project 

1. Execute below command
   java -jar <jar_file_full_path_name>
2. Browse to http://localhost:8080/swagger-ui.html
3. Swagger will run on this given url.
4. On swagger, list of APIs will be available with sample data

## Few points to note 

1. Mongo DB is deployed in Cloud
2. Database, Collection, Documents are created in MongoDB Clous for testing purpose.
