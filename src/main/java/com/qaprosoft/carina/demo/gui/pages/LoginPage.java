package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='main main-review l-box col float-right']//h3")
    private ExtendedWebElement loginResult;

    @FindBy(xpath = "//div[@class='main main-review l-box col float-right']//p")
    private ExtendedWebElement loginFailReason;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginStatus() {
        return loginResult.getText();
    }

    public String loginFailReason(){
        return loginFailReason.getText();
    }
}
