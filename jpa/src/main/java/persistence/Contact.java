package persistence;

import javax.persistence.*;
import java.util.List;

/**
 * @author Dominik Ciborowski
 */
@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String surname;

    private String phoneNo;

    private String email;

    @ManyToMany(mappedBy = "contacts")
//    @JoinTable(name = "contact_meeting", joinColumns = {@JoinColumn(name = "contact_id")},
//            inverseJoinColumns = {@JoinColumn(name = "meeting_id")})
    private List<Meeting> meetings;

    public Contact() {
    }

    public Contact(String name, String surname, String phoneNo, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
