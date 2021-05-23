package pages;

import menu.HamburgerMenu;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shopping_cart.ShoppingCart;

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
        By searchField = By.xpath("//*[@name='q']");
        By productLink = By.xpath("//div[@data-product-name='RAMSTA РАМСТА']");

        driver.findElement(searchField).sendKeys(itemName);
        driver.findElement(searchField).sendKeys(Keys.ENTER);

        WebElement result = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(productLink));
        result.click();
        return new ProductPage(driver);
    }

    public ShoppingCart clearShoppingCart() {
        try {
            clickShoppingCartIcon();
            WebElement deleteItemsInCart = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-controls__remove']")));
            deleteItemsInCart.click();
        }
        finally {
            return new ShoppingCart(driver);
        }
    }

    public HamburgerMenu clickHamburgerMenuLink() {
        WebElement hamburgerMenuBtn = driver.findElement(By.xpath("//li[@class='hnf-header__hamburger']/button"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", hamburgerMenuBtn);
        return new HamburgerMenu(driver);
    }
}
