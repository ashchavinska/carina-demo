package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends AbstractPage {

    @FindBy(xpath="//h1[@class='article-info-name']")
    public ExtendedWebElement title;

    @FindBy(xpath="//li[@class='article-info-meta-link meta-link-specs']/a")
    public ExtendedWebElement postYourCommentBtn;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getTextFromPostYouCommBtn() {
        return postYourCommentBtn.getText();
    }
}
