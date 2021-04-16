package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    private static final String THIS_METHOD_IS_NOT_IMPLEMENTED_FOR_IOS = "This method is not yet implemented for iOS";

    @FindBy(xpath = " ")
    private ExtendedWebElement pageTittle;

    @FindBy(xpath = " ")
    private ExtendedWebElement zoomInBtn;

    @FindBy(xpath = " ")
    private ExtendedWebElement zoomOutBtn;


    public MapsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public boolean isZoomInBtnPresent() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public boolean isZoomOutBtnPresent() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public Point zoomInCoord() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public Point zoomOutCoord() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_FOR_IOS);
    }
}
