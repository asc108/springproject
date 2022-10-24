package m;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EntityScan("model")
public class PozoristeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PozoristeSpringApplication.class, args);
	}

}
