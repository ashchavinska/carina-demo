package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ModelItem;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PhoneFinderResultPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(PhoneFinderResultPage.class);

    @FindBy(xpath="//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath="(//div[@class='st-text']/p)[1]")
    private ExtendedWebElement resultText;

    @FindBy(xpath="//div[@class='st-text']/p/a")
    private ExtendedWebElement clickHereBtn;

    @FindBy(xpath="//div[@class='section-body']/div/ul/li")
    private List<ModelItem> listOfModelItems;

    @FindBy(xpath="//p[@class='note']")
    private ExtendedWebElement textInBottom;

    public PhoneFinderResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPhoneFinderResultPageOpen() {
        LOGGER.info("Check is phone finder result page open by verify is page title equals to \"Phone finder results\".");
        return pageTitle.isPresent() && pageTitle.getText().equals("Phone finder results");
    }

    public String getResultText(){
        return resultText.getText();
    }

    public String getTextClickHereBtn() {
        return clickHereBtn.getText();
    }

    public boolean  isClickHereBtnPresent() {
        return clickHereBtn.isPresent();
    }

    public PhoneFinderPage clickClickHereBtn() {
        clickHereBtn.click();
        return new PhoneFinderPage(driver);
    }

    public List<ModelItem> getListModelItem() {
        return listOfModelItems;
    }

    public boolean isTextInBottomPresent() {
        return textInBottom.isPresent() && textInBottom.getText().equals("Note: Please report wrong Phone Finder results here.");
    }
}
