package se.ecutbildning.hala.data;

import se.ecutbildning.hala.model.AppUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppUserStorageListImpl implements AppUserStorage {

    private List<AppUser> appUsers;

    public AppUserStorageListImpl() {
        this.appUsers = new ArrayList<>();
    }

    @Override
    public Optional<AppUser> findById(int appUserId) {
        return appUsers.stream()
                .filter(user -> user.getAppUserId() == appUserId)
                .findFirst();
    }

    @Override
    public List<AppUser> findAll() {
        return appUsers;
    }

    @Override
    public List<AppUser> findByFirstName(String firstName) {
        return appUsers.stream()
                .filter(user -> user.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppUser> findByLastName(String lastName) {
        return appUsers.stream()
                .filter(user -> user.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return appUsers.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public AppUser createNewAppUser(String firstName, String lastName, String email) {
        if(findByEmail(email).isPresent()){
            throw new IllegalArgumentException("Email " + email + " already exists");
        }
        AppUser user = new AppUser(firstName,lastName,email);
        appUsers.add(user);
        return user;
    }

    @Override
    public boolean deleteAppUser(int appUserId) {
        AppUser unluckyOne =findById(appUserId).orElseThrow(IllegalArgumentException::new);
        return appUsers.remove(unluckyOne);
    }
}
