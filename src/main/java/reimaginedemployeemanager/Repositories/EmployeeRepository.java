package reimaginedemployeemanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reimaginedemployeemanager.Objects.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
