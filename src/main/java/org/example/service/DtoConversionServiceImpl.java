package org.example.service;

import org.example.model.AppUser;
import org.example.model.Meeting;
import org.example.model.dto.AppUserDTO;
import org.example.model.dto.MeetingDTO;
import org.example.model.dto.ShortAppUserDTO;
import org.example.model.dto.ShortMeetingDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DtoConversionServiceImpl implements DtoConversionService {

    private static final DtoConversionServiceImpl INSTANCE;

    static {
        INSTANCE = new DtoConversionServiceImpl();
    }

    private DtoConversionServiceImpl() {
    }

    public static DtoConversionService getInstance(){
        return INSTANCE;
    }

    @Override
    public AppUserDTO appUserToAppUserDTO(AppUser appUser) {
        AppUserDTO dto = new AppUserDTO();
        dto.setUserId(appUser.getUserId());
        dto.setUsername(appUser.getUsername());
        dto.setFirstName(appUser.getFirstName());
        dto.setLastName(appUser.getLastName());
        List<ShortMeetingDTO> meetingDTOList = new ArrayList<>();
        for(Meeting meeting : appUser.getMeetings()){
            meetingDTOList.add(meetingToShortMeetingDTO(meeting));
        }
        dto.setMeetings(meetingDTOList);
        return dto;
    }

    @Override
    public ShortAppUserDTO appUserToShortAppUserDTO(AppUser appUser) {
        ShortAppUserDTO dto = new ShortAppUserDTO();
        dto.setUserId(appUser.getUserId());
        dto.setUsername(appUser.getUsername());
        dto.setFirstName(appUser.getFirstName());
        dto.setLastName(appUser.getLastName());
        return dto;
    }

    @Override
    public MeetingDTO meetingToMeetingDTO(Meeting meeting) {
        MeetingDTO dto = new MeetingDTO();
        dto.setMeetingId(meeting.getMeetingId());
        dto.setStart(meeting.getStart());
        dto.setEnd(meeting.getEnd());
        dto.setTopic(meeting.getTopic());
        dto.setAgenda(meeting.getAgenda());
        dto.setOrganizer(appUserToShortAppUserDTO(meeting.getOrganizer()));
        dto.setParticipants(
                meeting.getParticipants().stream()
                        .map(this::appUserToShortAppUserDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    @Override
    public ShortMeetingDTO meetingToShortMeetingDTO(Meeting meeting) {
        ShortMeetingDTO dto = new ShortMeetingDTO();
        dto.setMeetingId(meeting.getMeetingId());
        dto.setStart(meeting.getStart());
        dto.setEnd(meeting.getEnd());
        dto.setTopic(meeting.getTopic());
        dto.setAgenda(meeting.getAgenda());
        return dto;
    }
}
