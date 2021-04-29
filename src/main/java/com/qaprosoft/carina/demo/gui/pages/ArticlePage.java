package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(ArticlePage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    public ExtendedWebElement title;

    @FindBy(xpath="//li[@class='article-info-meta-link meta-link-specs']/a")
    public ExtendedWebElement postYourCommentBtn;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        LOGGER.info("Get title of article page - " + "[ " + title.getText() + " ]");
        return title.getText();
    }

    public boolean isArticlePageOpen() {
        LOGGER.info("Check is article page open by verify is \"Post comment\" button present.");
        return postYourCommentBtn.isPresent() && postYourCommentBtn.getText().equals("POST YOUR COMMENT");
    }
}
