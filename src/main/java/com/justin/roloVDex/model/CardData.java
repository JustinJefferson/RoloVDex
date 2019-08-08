package com.justin.roloVDex.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CardData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    private String name;
    private String jobTitle;
    private String company;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipcode;

    private String imagePath;

    //@ManyToMany(mappedBy = "sharedCards")
    //private Set<User> usersWithCard;

    public CardData() { }

    public CardData(Long userId, String name, String jobTitle, String company, String addressLine1, String addressLine2, String city, String state, String zipcode, String imagePath) {
        this.userId = userId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.company = company;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

//    public Set<User> getUsersWithCard() {
//        return usersWithCard;
//    }
//
//    public void setUsersWithCard(Set<User> usersWithCard) {
//        this.usersWithCard = usersWithCard;
//    }

    public void update(CardData update) {


        this.name = update.name;
        this.jobTitle = update.jobTitle;
        this.company = update.company;
        this.addressLine1 = update.addressLine1;
        this.addressLine2 = update.addressLine2;
        this.city = update.city;
        this.state = update.state;
        this.zipcode = update.zipcode;
        this.imagePath = update.imagePath;

    }
}
