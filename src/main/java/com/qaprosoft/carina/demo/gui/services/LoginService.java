package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.LoginField;
import com.qaprosoft.carina.demo.gui.components.User;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.Assert;

public class LoginService implements IDriverPool {

    public HomePage login(String email, String password) {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field doesn't present");

        loginField.enterEmail(email);
        loginField.enterPassword(password);
        loginField.clickLoginButton();
        Assert.assertTrue(homePage.getHeader().isLogOutIconPresent(), "Home page doesn't open");
        return new HomePage(getDriver());
    }
}
