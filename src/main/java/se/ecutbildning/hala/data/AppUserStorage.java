package se.ecutbildning.hala.data;

import se.ecutbildning.hala.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserStorage {
    Optional<AppUser> findById(int appUserId);
    List<AppUser> findAll();
    List<AppUser> findByFirstName(String firstName);
    List<AppUser> findByLastName(String lastName);
    Optional<AppUser> findByEmail(String email);
    AppUser createNewAppUser(String firstName, String lastName, String email);
    boolean deleteAppUser(int appUserId);

}
