package org.example.data;

import org.example.model.AppUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppUserCollection implements AppUserDAO {

    private static final AppUserCollection INSTANCE;

    //To create our ONLY AppUserCollection object
    static {
        INSTANCE = new AppUserCollection();
    }

    //To initialize whatever we need
    private AppUserCollection(){
        appUsers = new ArrayList<>();
    }

    private List<AppUser> appUsers;

    //To hand out our ONLY instance
    static AppUserDAO getInstance(){
        return INSTANCE;
    }

    @Override
    public Optional<AppUser> findById(String userId) {
        return appUsers.stream()
                .filter(appUser -> appUser.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public AppUser save(AppUser newUser) {
        if(!appUsers.contains(newUser)){
            appUsers.add(newUser);
        }else {
            return update(newUser);
        }
        return newUser;
    }

    @Override
    public List<AppUser> findMany(Predicate<AppUser> filter) {
        return appUsers.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppUser> findOne(Predicate<AppUser> filter) {
        return appUsers.stream()
                .filter(filter)
                .findFirst();
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUser;
    }

    @Override
    public boolean remove(String userId) {
        AppUser appUser = findById(userId)
                .orElseThrow(() -> new RuntimeException("Couldn't find user with id " + userId));

        return appUsers.remove(appUser);
    }

    @Override
    public void clear(){
        appUsers.clear();
    }
}
