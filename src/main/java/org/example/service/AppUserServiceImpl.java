package org.example.service;

import org.example.data.AppUserDAO;
import org.example.data.MeetingDAO;
import org.example.model.AppUser;
import org.example.model.Meeting;
import org.example.model.dto.AppUserDTO;
import org.example.model.dto.ShortAppUserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AppUserServiceImpl implements AppUserService {

    private static final AppUserServiceImpl INSTANCE;

    static {
        INSTANCE = new AppUserServiceImpl();
    }

    public static AppUserService getInstance(){
        return INSTANCE;
    }

    private final AppUserDAO appUserDAO;
    private final MeetingDAO meetingDAO;
    private final DtoConversionService conversionService;

    private AppUserServiceImpl() {
        this.appUserDAO = AppUserDAO.getInstance();
        this.meetingDAO = MeetingDAO.getInstance();
        this.conversionService = DtoConversionService.getInstance();
    }

    @Override
    public AppUser create(String username, String password, String firstName, String lastName) {
        if(username == null || password ==null || firstName == null || lastName == null){
            throw new RuntimeException("Can't finish task one or several arguments were null");
        }

        AppUser appUser = new AppUser(username, password, firstName, lastName);

        return appUserDAO.save(appUser);
    }

    @Override
    public AppUserDTO save(AppUserDTO appUserDTO) {
        AppUser appUser = appUserDAO.findById(appUserDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Couldn't find user with id " + appUserDTO.getUserId()));

        appUser.setUsername(appUserDTO.getUsername());
        appUser.setFirstName(appUserDTO.getFirstName());
        appUser.setLastName(appUserDTO.getLastName());

        AppUser updated = appUserDAO.update(appUser);
        return conversionService.appUserToAppUserDTO(appUser);
    }

    @Override
    public List<ShortAppUserDTO> findAll() {
       return appUserDAO.findAll().stream()
               .map(conversionService::appUserToShortAppUserDTO)
               .collect(Collectors.toList());
    }

    @Override
    public AppUserDTO findById(String userId) {
        return conversionService.appUserToAppUserDTO(
            appUserDAO.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Couldn't find user with id " + userId))
        );
    }

    @Override
    public boolean deleteAppUser(String userId) {
        AppUser toRemove = appUserDAO.findById(userId).orElseThrow(RuntimeException::new);
        toRemove.clearMeetings();
        List<Meeting> meetings = meetingDAO.findAll()
                .stream()
                .filter(meeting -> meeting.getOrganizer() != null)
                .filter(meeting -> meeting.getOrganizer().getUserId().equals(userId))
                .collect(Collectors.toList());

        meetings.forEach(meeting -> meeting.setOrganizer(null));
        return appUserDAO.remove(userId);

    }



}
