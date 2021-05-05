package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserOpinionsPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(UserOpinionsPage.class);

    @FindBy(xpath = "//h1[@class='specs-phone-name-title']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "(//select[@name='nSortNew']//option[text()='Best rating'])[1]")
    private ExtendedWebElement bestRating;

    @FindBy(xpath = "(//select[@name='nSortNew']//option[text()='Newest first'])[1]")
    private ExtendedWebElement newestFirst;

    @FindBy(xpath = "//li[@class='upost']/time")
    private List<ExtendedWebElement> listOfCommentsDate;

    @FindBy(xpath = "//span[@class='thumbs-score']")
    private List<ExtendedWebElement> listOfCommentsScores;

    @FindBy(xpath = "//a[@class='voting-link vote-up']")
    private List<ExtendedWebElement> listOfRateCommentBtn;

    @FindBy(xpath = "//a[@class='voting-link vote-down']")
    private List<ExtendedWebElement> listOfUnRateCommentBtn;

    public UserOpinionsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserOpinionsPageOpen() {
        LOGGER.info("Check is reviews page open by verify is page title contains - \"opinions\".");
        return pageTitle.isPresent() && pageTitle.getText().contains("opinions");
    }

    public void selectSortBestRating() {
        bestRating.click();
    }

    public List<String> getListOfCommentsScores() {
        List<String> listOfScores = new ArrayList<String>();
        for (ExtendedWebElement score : listOfCommentsScores) {
            listOfScores.add(score.getText());
        }
        return listOfScores;
    }

    public void rateCommentByIndex(int index) {
        listOfRateCommentBtn.get(index).click();
    }

    public void unRateCommentByIndex(int index) {
        listOfUnRateCommentBtn.get(index).click();
    }

    public void selectSortNewestFirst() {
        newestFirst.click();
    }

    public List<Date> getListOfCommentsDate() {
        List<Date> listOfDate = new ArrayList<Date>();
        for (ExtendedWebElement commentDate : listOfCommentsDate) {
            String stringDate = commentDate.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            try {
                Date date = dateFormat.parse(stringDate);
                listOfDate.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return listOfDate;
    }
}
