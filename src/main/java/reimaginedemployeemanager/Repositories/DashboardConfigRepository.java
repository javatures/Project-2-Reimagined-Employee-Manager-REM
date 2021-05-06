package reimaginedemployeemanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reimaginedemployeemanager.Objects.DashboardConfig;

@Repository
public interface DashboardConfigRepository extends JpaRepository<DashboardConfig, Long>{
    
}
