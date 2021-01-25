package org.example.model;

import java.util.Objects;
import java.util.TreeSet;
import java.util.UUID;

public class AppUser {

    private String userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private TreeSet<Meeting> meetings;

    public AppUser(String userId, String username, String password, String firstName, String lastName, TreeSet<Meeting> meetings) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.meetings = meetings;
    }

    public AppUser(String username, String password, String firstName, String lastName) {
        this(UUID.randomUUID().toString(), username, password, firstName, lastName, new TreeSet<>());
    }

    public String getUserId() {
        return userId;
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

    public TreeSet<Meeting> getMeetings() {
        if(meetings == null) meetings = new TreeSet<>();
        return meetings;
    }

    public void addMeeting(Meeting meeting){
        if(meetings.add(meeting)){
            if(! meeting.getParticipants().contains(this))
            meeting.getParticipants().add(this);
        }
    }

    public void removeMeeting(Meeting meeting){
        if(meetings.remove(meeting)){
            meeting.getParticipants().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(getUserId(), appUser.getUserId()) && Objects.equals(getUsername(), appUser.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
