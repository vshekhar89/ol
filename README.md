# ol
This project creates a REST API that returns the information of business contained in csv file in JSON format.</br>
The project uses SpringData JPA framework to create a H2 database that contains the information about each businesses.<br>

<h3>Source Files</h3>
<h4>1)  Application.java </h4>
This class starts the spring application and intializes the REST service.</br>
This class also reads the business information from the csv file and enters the information in the database.

<h4>2) Business.java</h4>
This class defines the information fields for each business.

<h4>3) BusinessRepository.java</h4>
This class defines the interface for the string data repository. The implmentation of the repository and the methods are 
provided by Spring Data at run-time.

<h4>4) RestConfig.java</h4>
This class defines a method that changes the default page size of 20 to 50.

<h3> Testing instructions </h3>
1) Download the contents of this git repo in a folder on the local machine.</br>
2) Open the terminal and go to the folder.</br>
3) run the application using ./gradlew bootRun.</br>
4) Open the web browser and test the application using the links below.

<h3>Links</h3>
1) <http://localhost:8080/business> - get the information of first 50 business and the pagination metadata.</br>
2) <http://localhost:8080/business?page=3> -  get the information of 50 business on page 3(id 150- 199) and the pagination metadata.</br>
3) <http://localhost:8080/business/search> - overview of the API


