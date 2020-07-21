# RetailManagementApplication

## Technologies
1. Spring Boot 
2. Mongo DB
3. Maven 

## Build the project

1. Install latest maven on your system
2. Make sure maven is correctly <br>
   mvn --version
3. Browse to a folder in the project where pom.xml is located <br>
   cd <project_location>/pom.xml
4. Execute below command to build maven project <br>
   mvn clean install
5. For running Spring boot application, choose either A or B given below.
   
## A) Run the project using maven command

1. Execute below command to run the project <br>
   mvn spring-boot:run
2. Browse to http://localhost:8080/swagger-ui.html
3. Swagger will run on the above url at port 8080 (configurable)
4. On swagger, list of APIs will be available with sample data to try on

## B) Create a jar and then run the project 

1. Execute below command to create a jar <br>
   mvn clean package
2. Jar will get generated in project under 'target' folder
3. Execute below command to run the project <br>
   java -jar <jar_file_full_path_name>
4. Browse to http://localhost:8080/swagger-ui.html
5. Swagger will run on the abve url at port 8080 (configurable)
6. On swagger, list of APIs will be available with sample data to try on

## Few points to note 

1. Mongo DB is deployed in Cloud
2. Database, Collection, Documents are created in MongoDB (Cloud) for testing purpose.
