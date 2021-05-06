package reimaginedemployeemanager.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vibe")
public class Vibe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vibe_id")
    private long vibeID;

    @Column(name = "vibe_tldr")
    private String vibeTLDR;

    @Column(name = "vibe_purpose")
    private String vibePurpose;

    @Column(name = "employee_id")
    private long employeeID;

    @Column(name = "vibee")
    private String vibee;

    public String getVibee() {
        return vibee;
    }

    public void setVibee(String vibee) {
        this.vibee = vibee;
    }

    public long getVibeID() {
        return vibeID;
    }

    public void setVibeID(long vibeID) {
        this.vibeID = vibeID;
    }

    public String getVibeTLDR() {
        return vibeTLDR;
    }

    public void setVibeTLDR(String vibeTLDR) {
        this.vibeTLDR = vibeTLDR;
    }

    public String getVibePurpose() {
        return vibePurpose;
    }

    public void setVibePurpose(String vibePurpose) {
        this.vibePurpose = vibePurpose;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

}
