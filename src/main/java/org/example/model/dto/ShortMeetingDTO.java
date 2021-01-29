package org.example.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ShortMeetingDTO implements Serializable {
    private String meetingId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String topic;
    private String agenda;

    public ShortMeetingDTO() {
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortMeetingDTO that = (ShortMeetingDTO) o;
        return Objects.equals(meetingId, that.meetingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingId);
    }

    @Override
    public String toString() {
        return "ShortMeetingDTO{" +
                "meetingId='" + meetingId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", topic='" + topic + '\'' +
                ", agenda='" + agenda + '\'' +
                '}';
    }
}
