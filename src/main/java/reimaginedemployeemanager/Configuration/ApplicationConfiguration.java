package reimaginedemployeemanager.Configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "reimaginedemployeemanager.Repositories")
@EntityScan(basePackages = "reimaginedemployeemanager.Objects")
public class ApplicationConfiguration {
    
}
