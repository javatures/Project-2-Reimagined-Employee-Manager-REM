package reimaginedemployeemanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reimaginedemployeemanager.Objects.DashboardConfig;

public interface DashboardConfigRepository extends JpaRepository<DashboardConfig, Long>{
    
}
