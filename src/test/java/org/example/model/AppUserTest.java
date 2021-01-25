package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    public static final String USERNAME = "test";
    public static final String PASSWORD = "test123";
    public static final String FIRST_NAME = "Test";
    public static final String LAST_NAME = "Testsson";

    private AppUser testObject;

    public Meeting generateMeeting(){
        return new Meeting(
                LocalDateTime.parse("2021-01-26T10:00"),
                LocalDateTime.parse("2021-01-26T11:00"),
                "Test topic",
                "Test agenda",
                testObject
        );
    }

    @BeforeEach
    void setUp() {
        testObject = new AppUser(
                USERNAME, PASSWORD, FIRST_NAME, LAST_NAME
        );

    }

    @Test
    @DisplayName("testObject successfully instantiated")
    void constructorCreation() {
        assertNotNull(testObject.getUserId());
    }

    @Test
    @DisplayName("Given meeting addMeeting adds appUser bidirectional")
    void addMeeting() {

        Meeting meeting = generateMeeting();

        testObject.addMeeting(meeting);

        assertTrue(testObject.getMeetings().contains(meeting));
        assertTrue(meeting.getParticipants().contains(testObject));
    }

    @Test
    @DisplayName("Given meeting removeMeeting removes appUser bidirectional")
    void removeMeeting() {
        Meeting meeting = generateMeeting();

        testObject.addMeeting(meeting);
        testObject.removeMeeting(meeting);

        assertFalse(testObject.getMeetings().contains(meeting));
        assertFalse(meeting.getParticipants().contains(testObject));

    }

    @Test
    @DisplayName("Given null add meeting throws IllegalArgumentException")
    void addMeetingWithNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> testObject.addMeeting(null)
        );
    }
}
