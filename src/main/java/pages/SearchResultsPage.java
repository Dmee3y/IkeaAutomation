package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultsPage {

    private WebDriver driver;
    private By searchField = By.xpath("//*[@name='q']");
    private By productsQuantityLink = By.xpath("(//*[@class='navigation-item__link-count'])[1]");
    private By productLink = By.xpath("//*[@id='search-results']//*[@data-ref-id]");
    private By firstSearchResult = By.xpath("//*[@data-ref-id][@data-price][1]");
    private By faveBtnOnSearchPage = By.xpath("//*[@data-ref-id][@data-price][1]//button[@aria-pressed]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage goToFirstResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(firstSearchResult));
        firstResult.click();
        return new ProductPage(driver);
    }
}
