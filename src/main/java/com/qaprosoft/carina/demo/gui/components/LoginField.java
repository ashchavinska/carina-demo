package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginField extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(LoginField.class);

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginField;

    @FindBy(id = "email")
    private ExtendedWebElement emailField;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordField;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement loginButton;

    public LoginField(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginFieldPresent(){
        LOGGER.info("Check is login field present.");
        return loginField.isPresent();
    }

    public void enterEmail(String email) {
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }
}
