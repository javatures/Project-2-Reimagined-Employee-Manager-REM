package reimaginedemployeemanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reimaginedemployeemanager.Objects.Vibe;

@Repository
public interface VibeRepository extends JpaRepository<Vibe, Long> {
    
}
