package com.qaprosoft.carina.demo.cucumber.steps;


import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.demo.gui.components.NewsPageItem;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GSMArenaNewsSteps extends CucumberRunner {
    
    HomePage homePage = null;
    NewsPage newsPage = null;

    @Given("^I am on main page")
    public boolean iAmOnMainPage() {
        homePage = new HomePage(getDriver());
        homePage.open();
        return homePage.isPageOpened();
    }
    
    @When("^I open 'News' page$")
    public void iOpenNewsPage()  {
        newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Then("^page 'News' should be open$")
    public void pageSettingsShouldBeOpen() {
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }
    
    @And("^page 'News' should contains all items$")
    public void pageSettingsShouldContainsAllItems() {
        final String searchQ = "iphone";
        List<NewsPageItem> news = newsPage.searchNews(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        for(NewsPageItem n : news) {
            System.out.println(n.getTitle());
            Assert.assertTrue(StringUtils.containsIgnoreCase(n.getTitle(), searchQ), "Invalid search results!");
        }
    }

}
