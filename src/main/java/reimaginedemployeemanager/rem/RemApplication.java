package reimaginedemployeemanager.rem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"reimaginedemployeemanager"})
public class RemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemApplication.class, args);
	}

}
