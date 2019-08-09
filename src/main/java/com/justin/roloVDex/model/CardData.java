package com.justin.roloVDex.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class CardData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_data_id")
    private Long id;

    private String name;
    private String jobTitle;
    private String company;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipcode;
    private String imagePath;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateUpdated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"sharedCards", "yourCards"})
    private User owner;

    @ManyToMany(mappedBy = "sharedCards")
    @JsonIgnoreProperties({"sharedCards", "yourCards"})
    private List<User> users;

    public CardData() { }

    public CardData(String name, String jobTitle, String company, String addressLine1, String addressLine2, String city, String state, String zipcode, String imagePath, LocalDate dateCreated, LocalDate dateUpdated, User owner, List<User> users) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.company = company;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.imagePath = imagePath;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.owner = owner;
        this.users = users;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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
        this.owner = update.owner;
        this.users = update.users;

    }
}
