package Tasks;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import pageObjects.GoogleSearchPage;
import util.JsonReader;

import javax.xml.transform.Result;


public class GoogleSearchTasks {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private String
            bookName = "Book Name",
            firstResultSearch = "First Result Search",
            search = "Search",
            result = "Result",
            zoom = "Zoom",
            suggestion = "Suggestion";

    /**
     * Constructor
     *
     * @param driver The webDriver instance that comes from the Hook class
     */
    public GoogleSearchTasks(WebDriver driver) {
        this.driver = driver;
        googleSearchPage = new GoogleSearchPage(driver);
    }


    /**
     * Navigates towards the url that's sent as a parameter
     *
     * @param url The url to which the browser must navigate
     */
    public void openANewBrowserOn(String url) {
        driver.get(url);

    }

    public void searchInGoogleFor(String bookName) {
        googleSearchPage.type(bookName, search);
        googleSearchPage.clickOnButton(zoom);
        getCurrentUrl();
    }

    public void checkForFirstResult(String bookName) {
        googleSearchPage.checkFirstResult(bookName, search);
    }

    public void clickFirstResult() {
        googleSearchPage.clickFirst(result);
        getCurrentUrl();
    }

    public void checkCurrentPage(String pageTitle) {
        googleSearchPage.checkName(pageTitle);
    }

    public void sendInfo(String bookName) {
        googleSearchPage.sendInformationToTheField(bookName, search);
    }

    public void clickFirstSuggestion() {
        googleSearchPage.clickFirstSuggestion(suggestion);
        googleSearchPage.clickOnButton(zoom);
        getCurrentUrl();
    }

    public void getCurrentUrl() {
        driver.get(driver.getCurrentUrl());

    }

}