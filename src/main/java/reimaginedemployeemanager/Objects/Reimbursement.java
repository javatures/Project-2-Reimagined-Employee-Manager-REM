package reimaginedemployeemanager.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reimbursement_id")
    private long reimbursementID;

    @Column(name = "reason")
    private String reason;

    @Column(name = "amount")
    private double amount;

    @Column(name = "approved")
    private String approved;

    @Column(name = "submitted_date")
    private String submittedDate;

    @Column(name = "approval_date")
    private String approvalDate;

    @Column(name = "employee_id")
    private long employeeID;
  

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(long reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    
    
}
