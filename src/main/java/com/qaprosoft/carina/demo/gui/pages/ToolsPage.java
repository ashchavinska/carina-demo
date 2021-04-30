package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ToolsPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(ToolsPage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public ToolsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isToolsPageOpen() {
        LOGGER.info("Check is tools page open by verify is page title equals to \"GSMArena Tools & Features\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("GSMArena Tools & Features");
    }
}
