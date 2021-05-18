package pages;

import org.openqa.selenium.*;

public class ProductPage {
    private WebDriver driver;
    private By addToCartButton = By.xpath("//button[@data-test-target='add-to-cart-button']");
    //private By shopCart = By.xpath("//a[@title='Корзина']");
    //WebElement shopCart = driver.findElement(By.xpath("//a[@title='Корзина']"));

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
        //driver.findElement(shopCart).click();
        return new ShoppingCart(driver);
    }

}
