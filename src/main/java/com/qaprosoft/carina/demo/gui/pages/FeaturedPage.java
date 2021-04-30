package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FeaturedPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(FeaturedPage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public FeaturedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFeaturedPageOpen() {
        LOGGER.info("Check is featured page open by verify is page title equals to \"Articles tagged \"Featured\"\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("Articles tagged \"Featured\"");
    }
}
