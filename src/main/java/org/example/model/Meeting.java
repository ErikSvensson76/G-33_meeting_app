package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Meeting implements Comparable<Meeting>{
    private String meetingId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String topic;
    private String agenda;
    private AppUser organizer;
    private List<AppUser> participants;

    public Meeting(String meetingId, LocalDateTime start, LocalDateTime end, String topic, String agenda, AppUser organizer, List<AppUser> participants) {
        this.meetingId = meetingId;
        this.start = start;
        this.end = end;
        this.topic = topic;
        this.agenda = agenda;
        this.organizer = organizer;
        this.participants = participants;
    }

    public Meeting(LocalDateTime start, LocalDateTime end, String topic, String agenda, AppUser organizer) {
        this(UUID.randomUUID().toString(), start, end, topic, agenda, organizer, new ArrayList<>());
    }

    public String getMeetingId() {
        return meetingId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public AppUser getOrganizer() {
        return organizer;
    }

    public void setOrganizer(AppUser organizer) {
        this.organizer = organizer;
    }

    public List<AppUser> getParticipants() {
        return participants;
    }

    public void setParticipants(List<AppUser> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(getMeetingId(), meeting.getMeetingId()) && Objects.equals(getStart(), meeting.getStart()) && Objects.equals(getEnd(), meeting.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMeetingId(), getStart(), getEnd());
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingId='" + meetingId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", topic='" + topic + '\'' +
                ", agenda='" + agenda + '\'' +
                '}';
    }

    @Override
    public int compareTo(Meeting o) {
        return getStart().compareTo(o.getStart());
    }
}
