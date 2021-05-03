package reimaginedemployeemanager.Repositories;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import reimaginedemployeemanager.Objects.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);
    
}
