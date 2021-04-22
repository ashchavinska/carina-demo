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
}
