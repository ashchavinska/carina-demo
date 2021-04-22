package com.qaprosoft.carina.demo.gui.services;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.User;

public class UserService {
    public User getUser() {
        User user = new User();
        user.setEmail(R.TESTDATA.get("email"));
        user.setPassword(R.TESTDATA.get("password"));
        return user;
    }

    public User getUserWithInvalidEmail() {
        User user = new User();
        user.setEmail(R.TESTDATA.get("invalid_email"));
        user.setPassword(R.TESTDATA.get("password"));
        return user;
    }

    public User getUserWithInvalidPassword() {
        User user = new User();
        user.setEmail(R.TESTDATA.get("email"));
        user.setPassword(R.TESTDATA.get("invalid_password"));
        return user;
    }
}
