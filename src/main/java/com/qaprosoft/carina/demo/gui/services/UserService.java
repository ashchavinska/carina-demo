package com.qaprosoft.carina.demo.gui.services;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.User;
import org.apache.log4j.Logger;

public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    public User getUser() {
        LOGGER.info("Get user.");
        User user = new User();
        user.setEmail(R.TESTDATA.get("email"));
        user.setPassword(R.TESTDATA.get("password"));
        return user;
    }
}
