package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.*;
import com.qaprosoft.carina.demo.gui.constants.WebConstants;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.gui.services.LoginService;
import com.qaprosoft.carina.demo.gui.services.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WebArenaTest extends AbstractTest {

    private String invalid_email = "qwerty@gmail.com";
    private String invalid_password = "qwerty";

    @Test(description = "04")
    @MethodOwner(owner = "ashchavinska")
    public void verifyHeaderComponents() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");
        Assert.assertTrue(homePage.isHeaderPresent(), "Header isn't present");

        Header header = homePage.getHeader();
        softAssert.assertTrue(header.isBurgerMenuPresent(), "Burger menu isn't present");
        softAssert.assertTrue(header.isLogoPresent(), "Logo isn't present");
        softAssert.assertTrue(header.isSearchFieldPresent(), "Search field isn't present");
        softAssert.assertTrue(header.isTipIconPresent(), "Tip icon isn't present");
        softAssert.assertTrue(header.isFacebookIconPresent(), "Facebook icon isn't present");
        softAssert.assertTrue(header.isTwitterIconPresent(), "Twitter icon isn't present");
        softAssert.assertTrue(header.isInstagramIconPresent(), "Instagram icon isn't present");
        softAssert.assertTrue(header.isYouTubeIconPresent(), "YouTube icon isn't present");
        softAssert.assertTrue(header.isRssIconPresent(), "Rss icon isn't present");
        softAssert.assertTrue(header.isLoginIconPresent(), "Login icon isn't present");
        softAssert.assertTrue(header.isSignUpIconPresent(), "SignUp icon isn't present");

        softAssert.assertAll();
    }

    @Test(description = "05/1")
    @MethodOwner(owner = "ashchavinska")
    public void verifySuccessLogin() {
        UserService userService = new UserService();
        User user = userService.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field isn't present");

        loginField.enterEmail(user.getEmail());
        loginField.enterPassword(user.getPassword());
        loginField.clickLoginButton();
        Assert.assertTrue(homePage.getHeader().isLogOutIconPresent(), "Home page isn't open");
    }

    @Test(description = "05/2")
    @MethodOwner(owner = "ashchavinska")
    public void verifyLoginWithWrongEmail() {
        UserService userService = new UserService();
        User user = userService.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field isn't present");

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
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");

        LoginField loginField = homePage.getHeader().openLoginField();
        Assert.assertTrue(loginField.isLoginFieldPresent(), "Login field isn't present");

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
        Assert.assertTrue(newsPage.isNewsPageOpen(), "News page isn't open");

        NewsPageItem newsItems = newsPage.pickNews(0);
        String titleFromNewsPage = newsItems.getTitle();

        ArticlePage articlePage = newsItems.clickNews();
        Assert.assertTrue(articlePage.isArticlePageOpen(), "Article page isn't open");
        String titleArticlePage = articlePage.getTitle();

        Assert.assertEquals(titleArticlePage, titleFromNewsPage, "Titles doesn't match");
    }

    @Test(description = "07")
    @MethodOwner(owner = "ashchavinska")
    public void verifySearchingProcess() {
        UserService userService = new UserService();
        User user = userService.getUser();
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.login(user.getEmail(), user.getPassword());

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isNewsPageOpen(), "News page isn't open");

        final String search = "iPhone";
        List<NewsPageItem> searchRes = newsPage.searchNews(search);
        Assert.assertFalse(searchRes.isEmpty(), "Search result is fail");
        for (NewsPageItem item : searchRes) {
            Assert.assertTrue(item.getTitle().toLowerCase().contains(search.toLowerCase()), "Search result is not as required");
        }
    }

    @Test(description = "08")
    @MethodOwner(owner = "ashchavinska")
    public void verifyGlossaryParagraphHeaderAndTextByFirstLetter() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");

        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isGlossaryPageOpen(), "Glossary page isn't open");

        List<ExtendedWebElement> titles = glossaryPage.getParagraphTitles();
        List<ParagraphContent> contents = glossaryPage.getParagraphContents();
        Assert.assertTrue(titles.size()==contents.size(), "Size isn't match");

        for (int i = 0; i < titles.size(); i++) {
            ExtendedWebElement title = titles.get(i);
            List<ExtendedWebElement> content = contents.get(i).getTitle();
            for (ExtendedWebElement item : content) {
                String itemFirstChar = Character.toString(item.toString().charAt(0));
                if (title.toString().equals("0 - 9")){
                    try {
                        int a = Integer.parseInt(itemFirstChar);
                        Assert.assertTrue(a>=0, "First char isn't match");
                    } catch (NumberFormatException e) {
                        Assert.assertTrue(false, "Can't format to integer");
                    }
                }
                else {
                    Assert.assertEquals(itemFirstChar.toLowerCase(), title.toString().toLowerCase(), "First char isn't match");
                }
            }
        }
    }

}
