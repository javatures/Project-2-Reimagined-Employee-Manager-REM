package reimaginedemployeemanager.Repositories;

import org.springframework.stereotype.Repository;
import reimaginedemployeemanager.Objects.Reimbursement;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Long>{
    
}
