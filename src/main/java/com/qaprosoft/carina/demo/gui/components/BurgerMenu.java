package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends AbstractUIObject {

    @FindBy(xpath = "//ul[@class='main-menu-list open']")
    private ExtendedWebElement burgerMenu;

    @FindBy(xpath = ".//li/a[text()='Home']")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = ".//li/a[text()='News']")
    private ExtendedWebElement newsBtn;

    @FindBy(xpath = ".//li/a[text()='Reviews']")
    private ExtendedWebElement reviewsBtn;

    @FindBy(xpath = ".//li/a[text()='Videos']")
    private ExtendedWebElement videosBtn;

    @FindBy(xpath = ".//li/a[text()='Featured']")
    private ExtendedWebElement featuredBtn;

    @FindBy(xpath = ".//li/a[text()='Phone Finder']")
    private ExtendedWebElement phoneFinderBtn;

    @FindBy(xpath = ".//li/a[text()='Deals']")
    private ExtendedWebElement dealsBtn;

    @FindBy(xpath = ".//li/a[text()='Tools']")
    private ExtendedWebElement toolsBtn;

    @FindBy(xpath = ".//li/a[text()='Coverage']")
    private ExtendedWebElement coverageBtn;

    @FindBy(xpath = ".//li/a[text()='Contact']")
    private ExtendedWebElement contactBtn;

    public BurgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isBurgerMenuOpen() {
        return burgerMenu.isPresent();
    }

    public HomePage openHomePage() {
        homeBtn.click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        newsBtn.click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        reviewsBtn.click();
        return new ReviewsPage(driver);
    }

    public VideosPage openVideosPage() {
        videosBtn.click();
        return new VideosPage(driver);
    }

    public FeaturedPage openFeaturedPage() {
        featuredBtn.click();
        return new FeaturedPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        phoneFinderBtn.click();
        return new PhoneFinderPage(driver);
    }

    public DealsPage openDealsPage() {
        dealsBtn.click();
        return new DealsPage(driver);
    }

    public ToolsPage openToolsPage() {
        toolsBtn.click();
        return new ToolsPage(driver);
    }

    public CoveragePage openCoveragePage() {
        coverageBtn.click();
        return new CoveragePage(driver);
    }

    public ContactPage openContactPage() {
        contactBtn.click();
        return new ContactPage(driver);
    }


}
