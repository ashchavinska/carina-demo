package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;


public class Header extends AbstractUIObject {

    @FindBy(xpath = "//button[contains(@aria-label,'Toggle Navigation')]")
    private ExtendedWebElement burgerMenu;

    @FindBy(id = "logo")
    private ExtendedWebElement homeTitle;

    @FindBy(id = "topsearch")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//a[@class='tip-icon']")
    private ExtendedWebElement tipIcon;

    @FindBy(xpath = "//a[@class='fb-icon']")
    private ExtendedWebElement facebookIcon;

    @FindBy(xpath = "//a[@class='tw-icon']")
    private ExtendedWebElement twitterIcon;

    @FindBy(xpath = "//a[@class='ig-icon']")
    private ExtendedWebElement instagramIcon;

    @FindBy(xpath = "//a[@class='yt-icon']")
    private ExtendedWebElement youTubeIcon;

    @FindBy(xpath = "//a[@class='rss-icon']")
    private ExtendedWebElement rssIcon;

    @FindBy(xpath = "//a[@class='login-icon']")
    private ExtendedWebElement loginIcon;

    @FindBy(xpath = "//a[@class='signup-icon no-margin-right']")
    private ExtendedWebElement signUpIcon;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement logOutIcon;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isBurgerMenuPresent() {
        return burgerMenu.isPresent();
    }

    public boolean isLogoPresent() {
        return homeTitle.isPresent();
    }

    public boolean isSearchFieldPresent() {
        return searchField.isPresent();
    }

    public boolean isTipIconPresent() {
        return tipIcon.isPresent();
    }

    public boolean isFacebookIconPresent() {
        return facebookIcon.isPresent();
    }

    public boolean isTwitterIconPresent() {
        return twitterIcon.isPresent();
    }

    public boolean isInstagramIconPresent() {
        return instagramIcon.isPresent();
    }

    public boolean isYouTubeIconPresent() {
        return youTubeIcon.isPresent();
    }

    public boolean isRssIconPresent() {
        return rssIcon.isPresent();
    }
    public boolean isLoginIconPresent() {
        return loginIcon.isPresent();
    }

    public boolean isSignUpIconPresent() {
        return signUpIcon.isPresent();
    }

    public LoginField openLoginField() {
        loginIcon.click();
        return new LoginField(driver);
    }

    public boolean isLogOutIconPresent() {
        return logOutIcon.isPresent();
    }
}
