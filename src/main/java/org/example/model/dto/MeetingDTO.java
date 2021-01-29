package org.example.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class MeetingDTO extends ShortMeetingDTO {
    private ShortAppUserDTO organizer;
    private List<ShortAppUserDTO> participants;

    public MeetingDTO() {
    }

    public ShortAppUserDTO getOrganizer() {
        return organizer;
    }

    public void setOrganizer(ShortAppUserDTO organizer) {
        this.organizer = organizer;
    }

    public List<ShortAppUserDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ShortAppUserDTO> participants) {
        this.participants = participants;
    }

}
