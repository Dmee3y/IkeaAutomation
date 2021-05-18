package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

    private WebDriver driver;
    final By shopCartItemName = By.xpath("//*[@class='product__name']");
    final By shopCartItemQuantity = By.xpath("//select[@data-testid='select']");
    final By shopCartTotalToPay = By.xpath("//*[@class='product__total']");
    private By searchField = By.xpath("//*[@name='q']");
    //WebElement shopCart = driver.findElement(By.xpath("//a[@title='Корзина']"));
    //WebElement deleteItemsInCart = driver.findElement(By.xpath("//div[@class='product-controls__remove']"));

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

//    public void addItemToShoppingCart(String itemName) {
//        HomePage homePage = new HomePage(driver);
//        driver.findElement(searchField).sendKeys("RAMSTA");
//        driver.findElement(searchField).sendKeys(Keys.ENTER);
//    }

    public String getShopCartItemName() {
        return driver.findElement(shopCartItemName).getText();
    }

    public String getShopCartItemQuantity() {
        //WebElement itemInCartQuantity = driver.findElement(shopCartItemQuantity);
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

//    public void clearShoppingCart() {
//        HomePage homePage = new HomePage(driver);
//        homePage.clickShoppingCartIcon();
//        WebElement deleteItemsInCart = new WebDriverWait(driver, 5)
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-controls__remove']")));
//        deleteItemsInCart.click();
//    }
}
