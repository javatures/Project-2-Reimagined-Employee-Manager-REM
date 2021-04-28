package reimaginedemployeemanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reimaginedemployeemanager.Objects.Thought;

@Repository
public interface ThoughtRepository extends JpaRepository<Thought, Long> {
    
}
