package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement clickLink(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public LoginPage clickLoginPageLink() {
        clickLink("//*[@title='Мой профиль']").click();
        return new LoginPage(driver);
    }

    public ForgotPasswordPage clickForgotPwdLink() {
        //LoginPage loginPage = new LoginPage(driver);
        clickLoginPageLink();
        clickLink("//a[@name='forgotPassword']").click();
        return new ForgotPasswordPage(driver);
    }

    public ShoppingCart clickShoppingCartIcon() {
        clickLink("//a[@title='Корзина']").click();
        return new ShoppingCart(driver);
    }

    public SearchResultsPage searchProduct(String itemName) {
        By searchField = By.xpath("//*[@name='q']");

        driver.findElement(searchField).sendKeys(itemName);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public ProductPage getProductPage(String itemName) {
        //itemName = "RAMSTA РАМСТА";
        By searchField = By.xpath("//*[@name='q']");
        //By productLink = By.xpath("//div[contains(text(),'"+itemName+"')]");
        By productLink = By.xpath("//div[@data-product-name='RAMSTA РАМСТА']");

        driver.findElement(searchField).sendKeys(itemName);
        driver.findElement(searchField).sendKeys(Keys.ENTER);

        WebElement result = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(productLink));
        result.click();
        //driver.findElement(productLink).click();

//        WebElement product = driver.findElement(By.xpath("//div[contains(text(),'"+itemName+"')]"));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", product);
        return new ProductPage(driver);
    }

    public ShoppingCart clearShoppingCart() {
        try {
            //WebElement deleteItemsInCart = driver.findElement(By.xpath("//div[@class='product-controls__remove']"));
            clickShoppingCartIcon();
            WebElement deleteItemsInCart = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-controls__remove']")));
            deleteItemsInCart.click();
        }
        finally {
            return new ShoppingCart(driver);
        }
    }
}
