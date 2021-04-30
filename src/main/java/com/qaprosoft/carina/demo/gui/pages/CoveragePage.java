package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CoveragePage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(CoveragePage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public CoveragePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCoveragePageOpen() {
        LOGGER.info("Check is coverage page open by verify is page title equals to \"Network coverage\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("Network coverage");
    }
}
