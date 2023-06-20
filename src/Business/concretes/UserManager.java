package Business.concretes;

import Business.abstracts.UserService;
import Core.AuthenticationService;
import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {
    private UserDao userDao;
    private AuthenticationService authenticationService;

    public UserManager(UserDao userDao, AuthenticationService authenticationService) {
        this.userDao = userDao;
        this.authenticationService = authenticationService;
    }
    @Override
    public void register(User user) {
        if (user.getPassword().length() < 6) {
            System.out.println("Password has to be at least 6 characters");
            return;
        }
        final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(user.getEmail());

        if(!matcher.matches()) {
            System.out.println("Unsupported Mail Format");
            return;
        }
        for(User users: userDao.getAll()) {
            if (users.getEmail().equals(user.getEmail())) {
                System.out.println("This email is already in the system");
                return;
            }
        }
        if(user.getFirstName().length() < 2 && user.getLastName().length() < 2) {
            System.out.println("Name Or Surname Can't be less than 2 characters");
            return;
        }

        this.userDao.add(user);
    }

    @Override
    public void registerWithGoogle(User user) {
        this.authenticationService.register(user);
    }
    @Override
    public void delete(User user) {
        System.out.println("User has been deleted " + user.getFirstName() + " " + user.getLastName() );
    }
}
