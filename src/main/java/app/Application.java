package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author vimalendu
 * @date 08/11/2016
 * @version 1.0
 */

@SpringBootApplication
public class Application {

	/**
	 * Main class to start the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * This method reads the 50k_businesses.csv file  using the CSVJdbc.jar 
	 * and creates a database that contains the business information
	 * @param BusinessRepository- respository that holds the business data
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(BusinessRepository repository) {
		return (args) -> {
			
			try{
				//get the CSVJdbc driver
				Class.forName("org.relique.jdbc.csv.CsvDriver");
				
				//creates a connection with the csv file
				Connection conn = DriverManager.getConnection("jdbc:relique:csv:bin/resources/csv");
				
				//the code below gets the data of each business from csv file and 
				//enters it in to the database
				Statement stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery("SELECT * FROM 50k_businesses");
				Business business;
				while (results.next()) {
					business = new Business();
					business.setId(results.getString("id"));
					business.setUuid(results.getString("uuid"));
					business.setName(results.getString("name"));
					business.setAddress(results.getString("address"));
					business.setAddress2(results.getString("address2"));
					business.setState(results.getString("state"));
					business.setZip(results.getString("zip"));
					business.setCity(results.getString("city"));
					business.setCountry(results.getString("country"));
					business.setPhone(results.getString("phone"));
					business.setWebsite(results.getString("website"));
					business.setCreated_at(results.getString("created_at"));
					business.setKey(business.getId());
					repository.save(business);
				}
				
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("Error reading file");
			}
		};
	}
}