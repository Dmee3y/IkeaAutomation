package menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HamburgerMenu {
    private WebDriver driver;

    public HamburgerMenu(WebDriver driver) {
        this.driver = driver;
    }

    public int getHamburgerMainLinksQuantity() {
        List<WebElement>menuMainLinks = driver.findElements(By.xpath("//ul[@class='hnf-menu__nav__main']//a[@role='button']"));
        return menuMainLinks.size();
    }

    public int getHamburgerAuxLinksQuantity() {
        List<WebElement>menuAuxLinks = driver.findElements(By.xpath("//ul[@class='hnf-menu__nav__aux']//a[@class='hnf-link']"));
        return menuAuxLinks.size();
    }
}
