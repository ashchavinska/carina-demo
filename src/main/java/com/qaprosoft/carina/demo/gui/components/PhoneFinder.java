package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneFinder extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='brandmenu-v2 light l-box clearfix']")
    private ExtendedWebElement phoneFinder;

    public PhoneFinder(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPhoneFinderPresent() {
        return phoneFinder.isPresent();
    }
}
