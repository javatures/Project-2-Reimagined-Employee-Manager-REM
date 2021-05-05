package reimaginedemployeemanager.Repositories;

import org.springframework.stereotype.Repository;
import reimaginedemployeemanager.Objects.Reimbursement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Long>{
    List<Reimbursement> findByEmployeeID(long employeeID);
}
