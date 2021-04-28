package reimaginedemployeemanager.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thought")
public class Thought {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "thought_id")
    private long thoughtID;

    @Column(name = "vibe_id")
    private long vibeID;

    @Column(name = "thought_tldr")
    private String thoughtTLDR;

    @Column(name = "thought_location")
    private String thoughtLocation;

    @Column(name = "thought_frame")
    private String thoughtFrame;

    public long getThoughtID() {
        return thoughtID;
    }

    public void setThoughtID(long thoughtID) {
        this.thoughtID = thoughtID;
    }

    public long getVibeID() {
        return vibeID;
    }

    public void setVibeID(long vibeID) {
        this.vibeID = vibeID;
    }

    public String getThoughtTLDR() {
        return thoughtTLDR;
    }

    public void setThoughtTLDR(String thoughtTLDR) {
        this.thoughtTLDR = thoughtTLDR;
    }

    public String getThoughtLocation() {
        return thoughtLocation;
    }

    public void setThoughtLocation(String thoughtLocation) {
        this.thoughtLocation = thoughtLocation;
    }

    public String getThoughtFrame() {
        return thoughtFrame;
    }

    public void setThoughtFrame(String thoughtFrame) {
        this.thoughtFrame = thoughtFrame;
    }

}
