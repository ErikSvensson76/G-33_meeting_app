package org.example.data;

import org.example.model.AppUser;
import org.example.model.Meeting;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MeetingDAO {
    static MeetingDAO getInstance(){
        return MeetingCollection.getInstance();
    }

    Optional<Meeting> findById(String meetingId);

    List<Meeting> findAll();

    List<Meeting> findByTimeBetween(LocalDateTime begin, LocalDateTime end);

    List<Meeting> findByAppUser(AppUser appUser);

    Meeting save(Meeting meeting);

    Meeting update(Meeting meeting);

    boolean removeMeeting(String meetingId);
}
