/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.WeValuePrivacyAd;


public class HomePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(id = "header")
    private ExtendedWebElement header;

    @FindBy(xpath = "//div[@class='brandmenu-v2 light l-box clearfix']/ul/li/a[contains(text(),\"%s\")]")
    private ExtendedWebElement brandFromBox;

    @FindBy(id = "header")
    private Header headerMenu;

    @FindBy(xpath = "//div[@class='brandmenu-v2 light l-box clearfix']")
    private ExtendedWebElement phoneFinderBox;

    @FindBy(xpath = "//div[@class='brandmenu-v2 light l-box clearfix']/ul/li")
    private List<ExtendedWebElement> listOfBrandsOfPhoneFinderBox;

    @FindBy(xpath = "//a[@class='pad-single pad-finder']")
    private ExtendedWebElement phoneFinderBtnInBox;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public BrandModelsPage selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }
    
    public WeValuePrivacyAd getWeValuePrivacyAd() {
    	return new WeValuePrivacyAd(driver);
    }

    public boolean isHeaderPresent() {
        return header.isPresent();
    }

    public Header getHeader() {
        return headerMenu;
    }

    public boolean isPhoneFinderBoxPresent() {
        return phoneFinderBox.isPresent();
    }

    public PhoneFinderPage openPhoneFinderPage() {
        LOGGER.info("Click phone finder button in box.");
        phoneFinderBtnInBox.click();
        return new PhoneFinderPage(driver);
    }

    public BrandModelsPage openBrandPageByName(String brand) {
        brandFromBox.format(brand).click();
        return new BrandModelsPage(driver);
    }
}
