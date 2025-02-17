package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.UIElementsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;
import com.qaprosoft.carina.demo.utils.MobileContextUtils.View;
import org.testng.asserts.SoftAssert;


public class MobileSampleTest extends AbstractTest implements IMobileUtils {
    WelcomePageBase welcomePage;
    String userName;
    String password;

    @BeforeMethod(alwaysRun = true)
    public void initWelcomePage(){
        userName = "Rachel Green";
        password = "1234567890";
        welcomePage = initPage(getDriver(), WelcomePageBase.class);
    }

    @Test(groups = "running", description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginUser() {
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active when it should be disabled");
        loginPage.typeName(userName);
        loginPage.typePassword(password);
        loginPage.selectMaleSex();
        loginPage.checkPrivacyPolicyCheckbox();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
    }

    //fail
	@Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testWebView() {
        //WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        loginPage.login();
        WebViewPageBase webViewPageBase = initPage(getDriver(), WebViewPageBase.class);
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(View.WEB);
        ContactUsPageBase contactUsPage = webViewPageBase.goToContactUsPage();
        contactUsPage.typeName("John Doe");
        contactUsPage.typeEmail("some@email.com");
        contactUsPage.typeQuestion("This is a message");
        //TODO: [VD] move page driver related action outside from test class!
        hideKeyboard();
        contactUsPage.submit();
        Assert.assertTrue(contactUsPage.isSuccessMessagePresent() || contactUsPage.isRecaptchaPresent(),
            "message was not sent or captcha was not displayed");
    }

    @Test(groups = "running", description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testUIElements() {
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.login();
        UIElementsPageBase uiElements = carinaDescriptionPage.navigateToUIElementsPage();
        final String text = "some text";
        final String date = "22/10/2018";
        final String email = "some@email.com";
        uiElements.typeText(text);
        Assert.assertEquals(uiElements.getText(), text, "Text was not typed");
        uiElements.typeDate(date);
        Assert.assertEquals(uiElements.getDate(), date, "Date was not typed");
        uiElements.typeEmail(email);
        Assert.assertEquals(uiElements.getEmail(), email, "Email was not typed");
        uiElements.swipeToFemaleRadioButton();
        uiElements.checkCopy();
        Assert.assertTrue(uiElements.isCopyChecked(), "Copy checkbox was not checked");
        uiElements.clickOnFemaleRadioButton();
        Assert.assertTrue(uiElements.isFemaleRadioButtonSelected(), "Female radio button was not selected!");
        uiElements.clickOnOtherRadioButton();
        Assert.assertTrue(uiElements.isOthersRadioButtonSelected(), "Others radio button was not selected!");
    }

    @Test(groups = "running", description = "01")
    @MethodOwner(owner = "ashchavinska")
    public void verifyLoginPage() {
        SoftAssert softAssert = new SoftAssert();

        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");

        softAssert.assertTrue(loginPage.isNameFieldPresent(), "User name field isn't present");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field isn't present");
        softAssert.assertTrue(loginPage.isMaleSexFieldPresent(), "MaleSex field isn't present");
        softAssert.assertTrue(loginPage.isFemaleSexFieldPresent(), "FemaleSex field isn't present");
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckboxPresent(), "Privacy policy checkbox field isn't present");

        softAssert.assertFalse(loginPage.isMaleSexChecked(), "MaleSex already checked");
        softAssert.assertFalse(loginPage.isFemaleSexChecked(), "FemaleSex already checked");
        softAssert.assertFalse(loginPage.isPrivacyPolicyChecked(), "Privacy policy already checked");

        loginPage.typeName(userName);
        softAssert.assertEquals(loginPage.printedName(), userName, "Printed name doesn't match with entered");
        loginPage.typePassword(password);
        softAssert.assertEquals(loginPage.printedPassword(), password, "Printed password doesn't match with entered");
        loginPage.selectFemaleSex();
        softAssert.assertTrue(loginPage.isFemaleSexChecked(), "FemaleSex isn't checked");

        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active when it should be disabled");

        loginPage.checkPrivacyPolicyCheckbox();
        Assert.assertTrue(loginPage.isPrivacyPolicyChecked(), "Privacy policy isn't checked");

        CarinaDescriptionPageBase webViewPage = loginPage.clickLoginBtn();
        Assert.assertTrue(webViewPage.isPageOpened(), "Carina description page isn't opened");

        softAssert.assertAll();
    }

    @Test(groups = "running", description = "02")
    @MethodOwner(owner = "ashchavinska")
    public void verifyMapFeature() {
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");

        loginPage.typeName(userName);
        loginPage.typePassword(password);
        loginPage.selectFemaleSex();
        loginPage.checkPrivacyPolicyCheckbox();

        CarinaDescriptionPageBase webViewPage = loginPage.clickLoginBtn();
        Assert.assertTrue(webViewPage.isPageOpened(), "WebView page isn't opened");

        MapsPageBase mapPage = webViewPage.navigateToMapPage();
        Assert.assertTrue(mapPage.isPageOpened(), "Map page isn't opened");

        Assert.assertTrue(mapPage.isZoomInBtnPresent(), "Zoom in button isn't present");
        Assert.assertTrue(mapPage.isZoomOutBtnPresent(), "Zoom out button isn't present");

        Assert.assertTrue(mapPage.zoomInCoord().getY()<mapPage.zoomOutCoord().getY(), "Zoom In button isn't above Zoom Out button");
    }
}
