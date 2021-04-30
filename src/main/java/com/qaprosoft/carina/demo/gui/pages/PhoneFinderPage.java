package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneFinderPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(PhoneFinderPage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPhoneFinderPageOpen() {
        LOGGER.info("Check is phone finder page open by verify is page title equals to \"Phone finder\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("Phone finder");
    }
}
