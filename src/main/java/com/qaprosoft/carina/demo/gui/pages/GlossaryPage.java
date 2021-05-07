package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ParagraphContent;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GlossaryPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(GlossaryPage.class);

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
        LOGGER.info("Check is glossary page open by verify is title equals to \"Mobile terms glossary\".");
        return title.isPresent() && title.getText().equals("Mobile terms glossary");
    }

    public List<String> getParagraphTitles() {
        LOGGER.info("Get list of paragraph titles in glossary page.");
        List<String> listOfElements = new ArrayList<String>();
        paragraphTitles.stream().forEachOrdered((oneElement) -> listOfElements.add(oneElement.getText()));
        return listOfElements;
    }

    public List<ParagraphContent> getParagraphContents() {
        LOGGER.info("Get list of paragraph content in glossary page.");
        return paragraphContents;
    }
}
