package org.example.data;

import org.example.model.AppUser;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AppUserDAO {

    static AppUserDAO getInstance(){
        return AppUserCollection.getInstance();
    }
    Optional<AppUser> findById(String userId);
    List<AppUser> findAll();
    AppUser save(AppUser newUser);
    List<AppUser> findMany(Predicate<AppUser> filter);
    Optional<AppUser> findOne(Predicate<AppUser> filter);
    AppUser update(AppUser appUser);
    boolean remove(String userId);
    void clear();

}
