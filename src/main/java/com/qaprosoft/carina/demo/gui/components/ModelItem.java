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

import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;

public class ModelItem extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(ModelItem.class);

    @FindBy(xpath = ".//strong/span")
    private ExtendedWebElement modelLabel;

    @FindBy(xpath = ".//a")
    private ExtendedWebElement modelLink;

    public ModelItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readModel() {
        LOGGER.info("Get text: " +  "[ " + modelLabel.getText() + " ]" + " - from model label.");
        return modelLabel.getText();
    }

    public ModelInfoPage openModelPage() {
        modelLink.click();
        return new ModelInfoPage(driver);
    }
}
