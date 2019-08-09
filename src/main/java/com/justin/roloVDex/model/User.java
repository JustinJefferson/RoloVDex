package com.justin.roloVDex.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    @OneToMany(mappedBy = "owner")
    @JsonIgnoreProperties({"owner", "users"})
    private List<CardData> yourCards;

    @ManyToMany
    @JoinTable(
            name = "shared_cards",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_data_id")
    )
    @JsonIgnoreProperties({"owner", "users"})
    private List<CardData> sharedCards;

    public User() { }

    public User(String firstName, String lastName, String username, String password, List<CardData> sharedCards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.sharedCards = sharedCards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public List<CardData> getYourCards() {
        return yourCards;
    }

    public void setYourCards(List<CardData> yourCards) {
        this.yourCards = yourCards;
    }

    public List<CardData> getSharedCards() {
        return sharedCards;
    }

    public void setSharedCards(List<CardData> sharedCards) {
        this.sharedCards = sharedCards;
    }

    public void addCard(CardData cardData) {
        sharedCards.add(cardData);
    }

    public void update(User update) {
        this.firstName = update.firstName;
        this.lastName = update.lastName;
        this.username = update.username;
        this.password = update.password;
        this.sharedCards = update.sharedCards;
    }
}
