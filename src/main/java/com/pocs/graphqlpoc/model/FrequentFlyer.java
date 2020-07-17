package com.pocs.graphqlpoc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "frequentFlyers")
public class FrequentFlyer {

    @Id
    private String id;

    @Indexed(unique = true)
    private String membershipId;

    private String firstName;
    private String lastName;
    private int points;

    public FrequentFlyer() {
        // No-arg constructor
    }

    public FrequentFlyer(String membershipId, String firstName, String lastName, int points) {
        this.membershipId = membershipId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "{\"FrequentFlyer\":{"
            + "\"id\":\"" + id + "\""
            + ", \"membershipId\":\"" + membershipId + "\""
            + ", \"firstName\":\"" + firstName + "\""
            + ", \"lastName\":\"" + lastName + "\""
            + ", \"points\":\"" + points + "\""
            + "}}";
    }
}
