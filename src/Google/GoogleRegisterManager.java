package Google;

import Entities.concretes.User;

public class GoogleRegisterManager {
    public boolean registerWithGoogle(User user) {
        System.out.println("User : " + user.getFirstName() + " " + user.getLastName() + " With : " + user.getEmail() + " email has been registered");
        return true;
    }
}
