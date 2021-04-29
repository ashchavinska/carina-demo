package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ParagraphContent extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(ParagraphContent.class);

    @FindBy(xpath="./a")
    public List<ExtendedWebElement> title;

    public ParagraphContent(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public List<String> getElements() {
        LOGGER.info("Get list of item in letter paragraph.");
        List<String> listOfElements = new ArrayList<String>();
        for (ExtendedWebElement oneElement : title){
            listOfElements.add(oneElement.getText());
        }
        return listOfElements;
    }
}
