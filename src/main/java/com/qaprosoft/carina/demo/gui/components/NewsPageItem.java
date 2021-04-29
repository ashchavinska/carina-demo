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
package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class NewsPageItem extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(NewsPageItem.class);

    @FindBy(xpath="./a/h3")
    public ExtendedWebElement titleLink;
    
    public NewsPageItem(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }
    
    public String getTitle() {
        LOGGER.info("Get text: " + "[ " +  titleLink.getElement().getText() + " ]" + " - from news page item.");
        return titleLink.getElement().getText();
    }

    public ArticlePage clickNews() {
        titleLink.click();
        return new ArticlePage(driver);
    }
}
