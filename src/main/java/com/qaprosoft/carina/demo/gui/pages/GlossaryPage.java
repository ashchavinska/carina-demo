package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ParagraphContent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GlossaryPage extends AbstractPage {

    @FindBy(xpath="//h1[@class='article-info-name']")
    public ExtendedWebElement title;

    @FindBy(xpath="//div[@class='st-text']/h3")
    public List<ExtendedWebElement> paragraphTitles;

    @FindBy(xpath="//div[@class='st-text']/p")
    public List<ParagraphContent> paragraphContents;

    public GlossaryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGlossaryPageOpen() {
        return title.isPresent() && title.getText().equals("Mobile terms glossary");
    }

    public List<ExtendedWebElement> getParagraphTitles() {
        return paragraphTitles;
    }

    public List<ParagraphContent> getParagraphContents() {
        return paragraphContents;
    }

}
