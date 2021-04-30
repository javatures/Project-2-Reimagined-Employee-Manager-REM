package reimaginedemployeemanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import reimaginedemployeemanager.Objects.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
