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

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.NewsPageItem;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage extends AbstractPage {
    
    @FindBy(className="searchFor")
    private ExtendedWebElement searchTextField;
    
    @FindBy(xpath="//input[@value='Search']")
    private ExtendedWebElement searchButton;
    
    @FindBy(xpath="//div[@class='news-item']")
    private List<NewsPageItem> news;

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    final Wait<WebDriver> wait = new WebDriverWait(driver, 5);

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3");
    }
    
    public List<NewsPageItem> searchNews(String text) {
        searchTextField.type(text);
        searchButton.click();
        return news;
    }

    public NewsPageItem pickNews(Integer index){
        return news.get(index);
    }

    public String getPageTitle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle.getBy()));
        return pageTitle.getText();
    }
}
