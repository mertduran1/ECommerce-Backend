package Core;

import Entities.concretes.User;
import Google.GoogleRegisterManager;

public class GoogleRegisterManagerAdapter implements AuthenticationService{
    private GoogleRegisterManager googleRegisterManager;

    public GoogleRegisterManagerAdapter(GoogleRegisterManager googleRegisterManager) {
        this.googleRegisterManager = googleRegisterManager;
    }

    @Override
    public void register(User user) {
        googleRegisterManager.registerWithGoogle(user);
    }

}
