package org.example.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AppUserDTO extends ShortAppUserDTO {

    private List<ShortMeetingDTO> meetings;

    public AppUserDTO() {
    }

    public List<ShortMeetingDTO> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<ShortMeetingDTO> meetings) {
        this.meetings = meetings;
    }


}
