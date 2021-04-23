package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.gui.components.*;
import com.qaprosoft.carina.demo.gui.constants.WebConstants;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.services.LoginService;
import com.qaprosoft.carina.demo.gui.services.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.asserts.SoftAssert;

public class WebArenaTest extends AbstractTest {

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
        UserService userService = new UserService();
        User user = userService.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field doesn't present");

        loginField.enterEmail(user.getEmail());
        loginField.enterPassword(user.getPassword());
        loginField.clickLoginButton();
        Assert.assertTrue(homePage.getHeader().isLogOutIconPresent(), "Home page doesn't open");
    }

    @Test(description = "05/2")
    @MethodOwner(owner = "ashchavinska")
    public void verifyLoginWithWrongEmail() {
        UserService userService = new UserService();
        User user = userService.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field doesn't present");

        loginField.enterEmail(invalid_email);
        loginField.enterPassword(user.getPassword());
        LoginPage loginPage = loginField.clickLoginButton();
        Assert.assertEquals(loginPage.getLoginStatus(), WebConstants.GSMARENA_LOGIN_FAIL, "Login not failed");
        Assert.assertEquals(loginPage.loginFailReason(), WebConstants.GSMARENA_LOGIN_FAIL_EMAIL, "Reason is different");
    }

    @Test(description = "05/3")
    @MethodOwner(owner = "ashchavinska")
    public void verifyLoginWithWrongPassword() {
        UserService userService = new UserService();
        User user = userService.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field doesn't present");

        loginField.enterEmail(user.getEmail());
        loginField.enterPassword(invalid_password);
        LoginPage loginPage = loginField.clickLoginButton();
        Assert.assertEquals(loginPage.getLoginStatus(), WebConstants.GSMARENA_LOGIN_FAIL, "Login not failed");
        Assert.assertEquals(loginPage.loginFailReason(), WebConstants.GSMARENA_LOGIN_FAIL_PASSWORD, "Reason is different");
    }

    @Test(description = "06")
    @MethodOwner(owner = "ashchavinska")
    public void verifyArticleName() {
        UserService userService = new UserService();
        User user = userService.getUser();
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.login(user.getEmail(), user.getPassword());

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertEquals(newsPage.getPageTitle(), "News", "News page doesn't open");

        NewsPageItem newsItems = newsPage.pickNews(0);
        String titleFromNewsPage = newsItems.readTitle();

        ArticlePage articlePage = newsItems.clickNews();
        Assert.assertEquals(articlePage.postYouCommBtn(), "POST YOUR COMMENT", "Article page doesn't open");
        String titleArticlePage = articlePage.getTitle();

        Assert.assertEquals(titleArticlePage, titleFromNewsPage, "Titles doesn't match");
    }
}
