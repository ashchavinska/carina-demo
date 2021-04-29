package com.qaprosoft.carina.demo.gui.components;

import org.apache.log4j.Logger;

public class User {

    private static final Logger LOGGER = Logger.getLogger(User.class);

    private String email;
    private String password;

    public User() {
        LOGGER.info("Created user.");
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        LOGGER.info("Created user with email and password.");
    }

    public void setEmail(String email) {
        this.email = email;
        LOGGER.info("Set user email.");
    }

    public String getEmail() {
        LOGGER.info("Get user email.");
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
        LOGGER.info("Set user password.");
    }

    public String getPassword() {
        LOGGER.info("Get user password.");
        return password;
    }
}
