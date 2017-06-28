package persistence;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dominik Ciborowski
 */
@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "meeting_date")
    private LocalDateTime localDateTime;

    private String extraInfo;

    @ManyToOne
    private Place meetingPlace;

    @ManyToMany
    private List<Contact> contacts;

    public Meeting() {
    }

    public Meeting(LocalDateTime localDateTime, String extraInfo) {
        this.localDateTime = localDateTime;
        this.extraInfo = extraInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Place getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(Place meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", extraInfo='" + extraInfo + '\'' +
                ", meetingPlace=" + meetingPlace +
                ", contacts=" + contacts +
                '}';
    }
}
