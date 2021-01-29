package org.example.service;

import org.example.model.AppUser;
import org.example.model.dto.AppUserDTO;
import org.example.model.dto.ShortAppUserDTO;

import java.util.List;

public interface AppUserService {
    static AppUserService getInstance(){
        return AppUserServiceImpl.getInstance();
    }
    AppUser create(final String username, final String password, final String firstName, final String lastName);
    AppUserDTO save(AppUserDTO appUserDTO);
    List<ShortAppUserDTO> findAll();
    AppUserDTO findById(String userId);
    boolean deleteAppUser(String userId);

}
