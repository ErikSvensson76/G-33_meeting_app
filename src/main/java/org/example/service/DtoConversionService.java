package org.example.service;

import org.example.model.AppUser;
import org.example.model.Meeting;
import org.example.model.dto.AppUserDTO;
import org.example.model.dto.MeetingDTO;
import org.example.model.dto.ShortAppUserDTO;
import org.example.model.dto.ShortMeetingDTO;

public interface DtoConversionService {

    static DtoConversionService getInstance(){
        return DtoConversionServiceImpl.getInstance();
    }

    AppUserDTO appUserToAppUserDTO(AppUser appUser);
    ShortAppUserDTO appUserToShortAppUserDTO(AppUser appUser);

    MeetingDTO meetingToMeetingDTO(Meeting meeting);
    ShortMeetingDTO meetingToShortMeetingDTO(Meeting meeting);

}
