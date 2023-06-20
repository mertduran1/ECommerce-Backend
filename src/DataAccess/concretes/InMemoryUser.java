package DataAccess.concretes;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUser implements UserDao {
    List<User> users = new ArrayList<>();
    @Override
    public void add(User user) {
        System.out.println("User added to memory : " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
        users.add(user);
    }

    @Override
    public void update(User user) {
        System.out.println("User updated to memory : " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
    }

    @Override
    public void delete(User user) {
        System.out.println("User deleted from memory : " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
        users.remove(user);
    }

    @Override
    public User getEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
