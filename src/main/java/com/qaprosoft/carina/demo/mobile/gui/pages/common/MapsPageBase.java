package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class MapsPageBase extends AbstractPage {

    public MapsPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean isZoomInBtnPresent() {
        return false;
    }

    public boolean isZoomOutBtnPresent() {
        return false;
    }

    public String zoomInCoord() {
        return " ";
    }

    public String zoomOutCoord() {
        return " ";
    }
}
