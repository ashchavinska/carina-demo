package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(BurgerMenu.class);

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
        LOGGER.info("Click home button.");
        homeBtn.click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        LOGGER.info("Click news button.");
        newsBtn.click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        LOGGER.info("Click reviews button.");
        reviewsBtn.click();
        return new ReviewsPage(driver);
    }

    public VideosPage openVideosPage() {
        LOGGER.info("Click videos button.");
        videosBtn.click();
        return new VideosPage(driver);
    }

    public FeaturedPage openFeaturedPage() {
        LOGGER.info("Click featured button.");
        featuredBtn.click();
        return new FeaturedPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        LOGGER.info("Click phone finder button.");
        phoneFinderBtn.click();
        return new PhoneFinderPage(driver);
    }

    public DealsPage openDealsPage() {
        LOGGER.info("Click deals button.");
        dealsBtn.click();
        return new DealsPage(driver);
    }

    public ToolsPage openToolsPage() {
        LOGGER.info("Click tools button.");
        toolsBtn.click();
        return new ToolsPage(driver);
    }

    public CoveragePage openCoveragePage() {
        LOGGER.info("Click coverage button.");
        coverageBtn.click();
        return new CoveragePage(driver);
    }

    public ContactPage openContactPage() {
        LOGGER.info("Click contact button.");
        contactBtn.click();
        return new ContactPage(driver);
    }
}
