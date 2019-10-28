package cn.merryyou.jpa.domain;

import javax.persistence.*;

/**
 * Created on 2018/3/2.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
public class Address1 {
    @Id
    @Column( name = "ID" )
    private long id;

    private String street;

    private String city;

    private String state;

    private String zip;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String address) {
        this.street = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String toString() {
        return "Address id: " + getId() + ", street: " + getStreet() + ", city: " + getCity()
                + ", state: " + getState() + ", zip: " + getZip();
    }

}