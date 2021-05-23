package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shopping_cart.ShoppingCart;

public class ProductPage {

    private WebDriver driver;
    private final By addToCartButton = By.xpath("//button[@data-test-target='add-to-cart-button']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public ShoppingCart goToShoppingCart() {
        WebElement shopCart = driver.findElement(By.xpath("//a[@title='Корзина']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", shopCart);
        return new ShoppingCart(driver);
    }

    public void addToFavoriteList() {
        WebElement addToFavBtn = driver.findElement(By.xpath("//button[@data-test-target='add-to-list-button']"));
        addToFavBtn.click();
    }

    public boolean isAddedToFavList() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addedToFav = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@isadded='true']")));
        addedToFav.isDisplayed();
        return true;
    }

}
