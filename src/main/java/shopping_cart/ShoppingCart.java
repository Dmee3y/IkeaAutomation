package shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ShoppingCart {

    private WebDriver driver;
    final By shopCartItemName = By.xpath("//*[@class='product__name']");
    final By shopCartItemQuantity = By.xpath("//select[@data-testid='select']");
    final By shopCartTotalToPay = By.xpath("//*[@class='product__total']");
    private By searchField = By.xpath("//*[@name='q']");


    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }


    public String getShopCartItemName() {
        return driver.findElement(shopCartItemName).getText();
    }

    public String getShopCartItemQuantity() {
        Select dropdown = new Select(driver.findElement(shopCartItemQuantity));
        WebElement quantity = dropdown.getFirstSelectedOption();
        String itemQuantity = quantity.getText();
        return itemQuantity;
    }

    public void updateShopCartItemQuantity(String int_) {
        Select dropdown = new Select(driver.findElement(shopCartItemQuantity));
        dropdown.selectByVisibleText(int_);
    }

    public String getCartTotalPrice () {
        return driver.findElement(shopCartTotalToPay).getText();
    }
}
