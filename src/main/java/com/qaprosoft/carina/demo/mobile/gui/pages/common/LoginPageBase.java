package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage {

	public LoginPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void typeName(String name);

	public abstract void typePassword(String password);

	public abstract void selectMaleSex();

	public abstract void selectFemaleSex();

	public abstract void checkPrivacyPolicyCheckbox();

	public abstract CarinaDescriptionPageBase clickLoginBtn();

	public abstract boolean isLoginBtnActive();

	public abstract CarinaDescriptionPageBase login();

	public abstract boolean isMaleSexChecked();

	public abstract boolean isFemaleSexChecked();

	public abstract boolean isPrivacyPolicyChecked();

	public abstract String printedName();

	public abstract String printedPassword();

	public abstract boolean isNameFieldPresent();

	public abstract boolean isPasswordFieldPresent();

	public abstract boolean isMaleSexFieldPresent();

	public abstract boolean isFemaleSexFieldPresent();

	public abstract boolean isPrivacyPolicyCheckboxPresent();
}
