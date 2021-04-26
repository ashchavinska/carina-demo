package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ParagraphContent extends AbstractUIObject {

    @FindBy(xpath="./a")
    public List<ExtendedWebElement> title;

    public ParagraphContent(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public List<ExtendedWebElement> getTitle() {
        return title;
    }
}
