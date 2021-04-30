package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReviewsPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(ReviewsPage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public ReviewsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isReviewsPageOpen() {
        LOGGER.info("Check is reviews page open by verify is page title equals to \"Reviews\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("Reviews");
    }
}
