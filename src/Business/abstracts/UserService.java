package Business.abstracts;

import Entities.concretes.User;

public interface UserService {
    void register(User user);
    void registerWithGoogle(User user);
    void delete(User user);
}
