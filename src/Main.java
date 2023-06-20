import Business.abstracts.UserService;
import Business.concretes.UserManager;
import Core.GoogleRegisterManagerAdapter;
import DataAccess.concretes.InMemoryUser;
import Google.GoogleRegisterManager;
import Entities.concretes.User;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        UserService userManager = new UserManager(new InMemoryUser(), new GoogleRegisterManagerAdapter(new GoogleRegisterManager()));
        User user1 = new User(1, "Mert", "Duran", "mertduran@mail.com", "123123123");
        User user2 = new User(2, "Ahmet", "Uğur", "ahmetugur@mail.com", "123123123");
        User user3 = new User(3, "Mert", "Dur", "mertduran@mail.com", "1231323");
        userManager.register(user1);
        userManager.register(user3);
        userManager.registerWithGoogle(user2);
        userManager.delete(user1);
    }
}