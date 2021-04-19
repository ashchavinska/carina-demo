package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().text(\"Map\")")
    private ExtendedWebElement pageTittle;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().descriptionContains(\"Zoom in\")")
    private ExtendedWebElement zoomInBtn;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().descriptionContains(\"Zoom out\")")
    private ExtendedWebElement zoomOutBtn;

    final Wait<WebDriver> wait = new WebDriverWait(driver, 5);

    public MapsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.TextView")));
        return pageTittle.isPresent();
    }

    @Override
    public boolean isZoomInBtnPresent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageView")));
        return zoomInBtn.isPresent();
    }

    @Override
    public boolean isZoomOutBtnPresent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageView")));
        return zoomOutBtn.isPresent();
    }

    @Override
    public Point zoomInCoord() {
        return zoomInBtn.getLocation();
    }

    @Override
    public Point zoomOutCoord() {
        return zoomOutBtn.getLocation();
    }
}
