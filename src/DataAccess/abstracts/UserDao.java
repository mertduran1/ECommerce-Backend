package DataAccess.abstracts;

import Entities.concretes.User;
import java.util.List;
public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(User user);
    User getEmail(String email);
    List<User> getAll();
}
