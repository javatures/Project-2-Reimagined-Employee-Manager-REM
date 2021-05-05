package reimaginedemployeemanager.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DashboardConfig")
public class DashboardConfig {

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "rgb("+this.red+","+this.green+","+this.blue+")";
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long employeeID;
    
    @Column(name = "red")
    private int red;

    @Column(name = "green")
    private int green;

    @Column(name = "blue")
    private int blue;


}