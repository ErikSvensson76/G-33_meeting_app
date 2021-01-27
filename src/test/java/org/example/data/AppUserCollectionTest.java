package org.example.data;

import org.example.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppUserCollectionTest {

    private AppUserDAO testObject = AppUserDAO.getInstance();
    private AppUser appUser;
    private String userId;

    @BeforeEach
    void setUp() {
        testObject.clear();
        appUser = new AppUser(
                "nisse", "1234", "Nils","Nilsson"
        );
        userId = appUser.getUserId();
        testObject.save(appUser);
    }

    @Test
    @DisplayName("Given userId findById should return Optional with appUser with")
    void findById() {
        Optional<AppUser> result = testObject.findById(userId);

        assertTrue(result.isPresent());
        assertEquals(userId, result.get().getUserId());
    }

    @Test
    @DisplayName("findAll return List size 1")
    void findAll() {
        assertEquals(1, testObject.findAll().size());
    }

    @Test
    @DisplayName("given new AppUser save successfully persist AppUser")
    void save() {
        AppUser newAppUser = new AppUser(
                "andreas_mangs", "1234", "Andreas", "Mangs"
        );

        testObject.save(newAppUser);

        assertTrue(testObject.findById(newAppUser.getUserId()).isPresent());
    }


}
