package org.example.data;

import org.example.model.AppUser;
import org.example.model.Meeting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MeetingCollection implements MeetingDAO {

    private static final MeetingCollection INSTANCE;

    static {
        INSTANCE = new MeetingCollection();
    }

    private MeetingCollection() {
        meetings = new ArrayList<>();
    }

    static MeetingCollection getInstance(){
        return INSTANCE;
    }

    private List<Meeting> meetings;

    @Override
    public Optional<Meeting> findById(String meetingId){
        return meetings.stream()
                .filter(meeting -> meeting.getMeetingId().equals(meetingId))
                .findFirst();
    }

    @Override
    public List<Meeting> findAll(){
        return new ArrayList<>(meetings);
    }

    @Override
    public List<Meeting> findByTimeBetween(LocalDateTime begin, LocalDateTime end){
        return meetings.stream()
                .filter(meeting -> (meeting.getStart().isAfter(begin) || meeting.getStart().equals(begin)) && (meeting.getEnd().isBefore(end) || meeting.getEnd().equals(end)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Meeting> findByAppUser(AppUser appUser){
        return meetings.stream()
                .filter(meeting -> meeting.getParticipants() != null)
                .filter(meeting -> meeting.getParticipants().contains(appUser))
                .collect(Collectors.toList());
    }

    @Override
    public Meeting save(Meeting meeting){
        if(!meetings.contains(meeting)){
            meetings.add(meeting);
        }else {
            return update(meeting);
        }
        return meeting;
    }

    @Override
    public Meeting update(Meeting meeting) {
        return meeting;
    }

    @Override
    public boolean removeMeeting(String meetingId){
        Meeting meeting = findById(meetingId).orElseThrow(() -> new RuntimeException("Couldn't find meeting with id " + meetingId));
        return meetings.remove(meeting);
    }

}
