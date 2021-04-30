package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PhoneFinderPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(PhoneFinderPage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath="(//div[@class='btn-group bootstrap-select show-tick phonefinder-select'])[1]")
    private ExtendedWebElement brandField;

    @FindBy(xpath="(//input[@class='form-control'])[1]")
    private ExtendedWebElement brandSearchField;

    @FindBy(xpath="//li[@class='active']")
    private ExtendedWebElement brandSelect;

    @FindBy(xpath="(//span[@class='pf-results'])[2]")
    private ExtendedWebElement showBtnRes;

    @FindBy(xpath="(//input[@class='pf-button'])[2]")
    private ExtendedWebElement showBtn;

    @FindBy(xpath="(//span[@class='filter-option pull-left'])[1]")
    private ExtendedWebElement selectedBrand;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPhoneFinderPageOpen() {
        LOGGER.info("Check is phone finder page open by verify is page title equals to \"Phone finder\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("Phone finder");
    }

    public void searchAndSelect(String text) {
        brandField.click();
        brandSearchField.type(text);
        brandSelect.click();
    }

    public String getShowBtnText() {
        return showBtnRes.getText();
    }

    public PhoneFinderResultPage clickShowBtn() {
        LOGGER.info("Scroll to \"Show\" button.");
        WebElement element = showBtn.getElement();
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        showBtn.click();
        return new PhoneFinderResultPage(driver);
    }

    public String getSelectedBrand() {
        return selectedBrand.getText();
    }
}
