package se.ecutbildning.hala.service;

import se.ecutbildning.hala.data.AppUserStorage;
import se.ecutbildning.hala.model.AppUser;

import java.util.Scanner;

public class ConsoleCreateUserImpl implements CreateNewUserService {

    private static final Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }
    private AppUserStorage appUserStorage;

    public ConsoleCreateUserImpl(AppUserStorage appUserStorage){
        this.appUserStorage = appUserStorage;
    }
    @Override
    public AppUser createNewAppUser() {
        System.out.println("Enter a first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.println("Enter a last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.println("Enter email: ");
        String email = scanner.nextLine().trim();
        return appUserStorage.createNewAppUser(firstName,lastName,email);
    }
}
