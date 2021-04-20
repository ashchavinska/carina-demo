package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @FindBy(id = "radio_male")
    private ExtendedWebElement maleRadioBtn;

    @FindBy(id = "radio_female")
    private ExtendedWebElement femaleRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    final Wait<WebDriver> wait = new WebDriverWait(driver, 5);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public void selectMaleSex() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("radio_male")));
        maleRadioBtn.click();
    }

    @Override
    public void selectFemaleSex() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("radio_female")));
        femaleRadioBtn.click();
    }

    @Override
    public void checkPrivacyPolicyCheckbox() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        privacyPolicyCheckbox.click();
    }

    @Override
    public CarinaDescriptionPageBase clickLoginBtn() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_button")));
        loginBtn.click();
        return initPage(getDriver(), CarinaDescriptionPageBase.class);
    }

    @Override
    public boolean isLoginBtnActive() {
        return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
    }

    @Override
    public CarinaDescriptionPageBase login() {
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        typeName(username);
        typePassword(password);
        selectMaleSex();
        checkPrivacyPolicyCheckbox();
        return clickLoginBtn();
    }

    @Override
    public boolean isPageOpened() {
        return loginBtn.isElementPresent();
    }

    @Override
    public boolean isNameFieldPresent() {
        return nameInputField.isElementPresent();
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordInputField.isElementPresent();
    }

    @Override
    public boolean isMaleSexFieldPresent() {
        return maleRadioBtn.isElementPresent();
    }

    @Override
    public boolean isFemaleSexFieldPresent() {
        return femaleRadioBtn.isElementPresent();
    }

    @Override
    public boolean isPrivacyPolicyCheckboxPresent() {
        return privacyPolicyCheckbox.isElementPresent();
    }

    @Override
    public boolean isMaleSexChecked() {
        return maleRadioBtn.isChecked();
    }

    @Override
    public boolean isFemaleSexChecked() {
        return femaleRadioBtn.isChecked();
    }

    @Override
    public boolean isPrivacyPolicyChecked() {
        return privacyPolicyCheckbox.isChecked();
    }

    @Override
    public String printedName(){
        return nameInputField.getText();
    }

    @Override
    public String printedPassword(){
        return passwordInputField.getText();
    }
}
