package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {

    public static final LocalDateTime START = LocalDateTime.parse("2021-01-26T10:00");
    public static final LocalDateTime END = LocalDateTime.parse("2021-01-26T11:00");
    public static final String TOPIC = "Test";
    public static final String AGENDA = "Test agenda";
    public static final AppUser ORGANIZER = new AppUser("test", "test123", "Test", "Testsson");
    private Meeting testObject;

    public AppUser createAppUser(){
        AppUser appUser = new AppUser(
                "esvensson", "sdgsKg653", "Erik","Johnsson"
        );
        return appUser;
    }

    @BeforeEach
    void setUp() {
        testObject = new Meeting(
                START,
                END,
                TOPIC,
                AGENDA,
                ORGANIZER
        );
    }

    @Test
    void testObjectCreated(){
        assertNotNull(testObject.getMeetingId());
        System.out.println(testObject.getMeetingId());
    }

    @Test
    @DisplayName("AppUser successfully added to the testObject")
    void addAppUser() {
        AppUser appUser = createAppUser();

        testObject.addParticipant(appUser);

        assertTrue(testObject.getParticipants().contains(appUser));
        assertTrue(appUser.getMeetings().contains(testObject));
    }

    @Test
    @DisplayName("AppUser successfully removed from testObject")
    void removeAppUser() {
        AppUser appUser = createAppUser();
        testObject.addParticipant(appUser);

        testObject.removeParticipant(appUser);

        assertFalse(testObject.getParticipants().contains(appUser));
        assertFalse(appUser.getMeetings().contains(testObject));
    }
}
