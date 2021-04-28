package reimaginedemployeemanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reimaginedemployeemanager.Objects.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
