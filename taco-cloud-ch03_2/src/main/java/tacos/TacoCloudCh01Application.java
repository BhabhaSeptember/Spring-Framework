package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Signifies that this is a Spring Boot application
//It is a composite annotation that combines the following annotations:
//@SpringBootConfiguration-designates class as configuration class 
//@EnableAutoConfiguration-enables auto configuration
//@ComponentScan-enables component scanning 
@SpringBootApplication
public class TacoCloudCh01Application {

//main method is run when JAR file is executed	
	public static void main(String[] args) {
//static run() method called on SpringApplication class,
//performs bootstrapping of application creating Spring context 	
//args passed to method are config class and command-line arguments		
		SpringApplication.run(TacoCloudCh01Application.class, args);
	}

}
