package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.gui.components.*;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.asserts.SoftAssert;

public class WebArenaTest extends AbstractTest {

    private String valid_email = "s9rowa@mail.ru";
    private String valid_password = "changeme";
    private String invalid_email = "qwerty@gmail.com";
    private String invalid_password = "qwerty";

    @Test(description = "04")
    @MethodOwner(owner = "ashchavinska")
    public void verifyHeaderComponents() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");
        Assert.assertTrue(homePage.isHeaderPresent(), "Header doesn't present");

        Header header = homePage.getHeader();
        softAssert.assertTrue(header.isBurgerMenuPresent(), "Burger menu doesn't present");
        softAssert.assertTrue(header.isLogoPresent(), "Logo doesn't present");
        softAssert.assertTrue(header.isSearchFieldPresent(), "Search field doesn't present");
        softAssert.assertTrue(header.isTipIconPresent(), "Tip icon doesn't present");
        softAssert.assertTrue(header.isFacebookIconPresent(), "Facebook icon doesn't present");
        softAssert.assertTrue(header.isTwitterIconPresent(), "Twitter icon doesn't present");
        softAssert.assertTrue(header.isInstagramIconPresent(), "Instagram icon doesn't present");
        softAssert.assertTrue(header.isYouTubeIconPresent(), "YouTube icon doesn't present");
        softAssert.assertTrue(header.isRssIconPresent(), "Rss icon doesn't present");
        softAssert.assertTrue(header.isLoginIconPresent(), "Login icon doesn't present");
        softAssert.assertTrue(header.isSignUpIconPresent(), "SignUp icon doesn't present");

        softAssert.assertAll();
    }

    @Test(description = "05/1")
    @MethodOwner(owner = "ashchavinska")
    public void verifySuccessLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field doesn't present");

        loginField.enterEmail(valid_email);
        loginField.enterPassword(valid_password);
        LoginPage loginPage = loginField.clickLoginButton();
        Assert.assertEquals(loginPage.getLoginStatus(), "Login successful.", "Login unsuccessful");
    }

    @Test(description = "05/2")
    @MethodOwner(owner = "ashchavinska")
    public void verifyLoginWithWrongEmail() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field doesn't present");

        loginField.enterEmail(invalid_email);
        loginField.enterPassword(valid_password);
        LoginPage loginPage = loginField.clickLoginButton();
        Assert.assertEquals(loginPage.getLoginStatus(), "Login failed.", "Login not failed");
        Assert.assertEquals(loginPage.loginFailReason(), "Reason: User record not found.", "Reason is different");
    }

    @Test(description = "05/3")
    @MethodOwner(owner = "ashchavinska")
    public void verifyLoginWithWrongPassword() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field doesn't present");

        loginField.enterEmail(valid_email);
        loginField.enterPassword(invalid_password);
        LoginPage loginPage = loginField.clickLoginButton();
        Assert.assertEquals(loginPage.getLoginStatus(), "Login failed.", "Login not failed");
        Assert.assertEquals(loginPage.loginFailReason(), "Reason: Wrong password.", "Reason is different");
    }
}
