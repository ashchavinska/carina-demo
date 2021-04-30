package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(ContactPage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public boolean isContactPageOpen() {
        LOGGER.info("Check is contact page open by verify is page title equals to \"Contact us\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("Contact us");
    }
}
