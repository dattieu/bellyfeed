package prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
 
	// REVIEW Spring Boot will use default basic authentication ('user', random password: see console log)
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
