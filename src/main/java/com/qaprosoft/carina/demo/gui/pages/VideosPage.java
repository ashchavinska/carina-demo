package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class VideosPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(VideosPage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public VideosPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVideosPageOpen() {
        LOGGER.info("Check is videos page open by verify is page title equals to \"Videos\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("Videos");
    }
}
