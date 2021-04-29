package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//div[@class='main main-review l-box col float-right']//h3")
    private ExtendedWebElement loginResult;

    @FindBy(xpath = "//div[@class='main main-review l-box col float-right']//p")
    private ExtendedWebElement loginFailReason;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginStatus() {
        LOGGER.info("Get login status - " + "[ " + loginResult.getText() + " ]");
        return loginResult.getText();
    }

    public String loginFailReason(){
        LOGGER.info("Get login fail reason - " + "[ " + loginFailReason.getText() + " ]");
        return loginFailReason.getText();
    }
}
