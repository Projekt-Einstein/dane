package persistence;

import javax.persistence.Embeddable;

/**
 * @author Dominik Ciborowski
 */
@Embeddable
public class Address {

    private String streetName;

    private Integer streetNo;

    private Integer aptNo;

    private String postalCode;

    private String city;

    private String country;

    public Address(String streetName, Integer streetNo, Integer aptNo, String postalCode, String city, String country) {
        this.streetName = streetName;
        this.streetNo = streetNo;
        this.aptNo = aptNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }

    public Integer getAptNo() {
        return aptNo;
    }

    public void setAptNo(Integer aptNo) {
        this.aptNo = aptNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
