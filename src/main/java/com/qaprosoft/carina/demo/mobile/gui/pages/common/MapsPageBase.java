package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public abstract class MapsPageBase extends AbstractPage {

    public MapsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isZoomInBtnPresent();

    public abstract boolean isZoomOutBtnPresent();

    public abstract Point zoomInCoord();

    public abstract Point zoomOutCoord();
}
