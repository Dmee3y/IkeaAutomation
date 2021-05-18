package shopping_cart;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.ShoppingCart;

public class ShopCartTests extends BaseTest {

    final String itemName = "RAMSTA РАМСТА";



    @Test
    public void testItemAdded() {
        ProductPage productPage = homePage.getProductPage(itemName);
        productPage.addProductToCart();
        ShoppingCart shoppingCart = productPage.goToShoppingCart();

        assertEquals(shoppingCart.getShopCartItemName(), itemName, "Wrong item name");

        //homePage.clearShoppingCart();
    }

    @Test(dependsOnMethods = {"testItemAdded"})
    public void testCartTotalToPay() {
        homePage.clearShoppingCart();
        ProductPage productPage = homePage.getProductPage(itemName);
        productPage.addProductToCart();
        ShoppingCart shoppingCart = productPage.goToShoppingCart();

        assertEquals(shoppingCart.getCartTotalPrice(),"9 999 ₽", "Wrong cart's total");

        homePage.clearShoppingCart();
    }

    @Test(dependsOnMethods = {"testCartTotalToPay"})
    public void testItemInCartQuantity() {
        ProductPage productPage = homePage.getProductPage(itemName);
        productPage.addProductToCart();
        ShoppingCart shoppingCart = productPage.goToShoppingCart();

        assertEquals(shoppingCart.getShopCartItemQuantity(), "1", "Wrong item's in cart quantity");

        homePage.clearShoppingCart();
    }

    @Test(dependsOnMethods = {"testItemInCartQuantity"})
    public void testChangingCartQuantity() {
        ProductPage productPage = homePage.getProductPage(itemName);
        productPage.addProductToCart();
        ShoppingCart shoppingCart = productPage.goToShoppingCart();
        shoppingCart.updateShopCartItemQuantity("3");

        assertEquals(shoppingCart.getShopCartItemQuantity(), "3", "Quantity in cart did not update");

        homePage.clearShoppingCart();
    }
}
