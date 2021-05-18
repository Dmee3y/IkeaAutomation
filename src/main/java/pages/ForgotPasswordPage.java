package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private By forgotPasswordLink = By.xpath("//*[@name='forgotPassword']");
    private By emailInputField = By.id("username");
    //private String emailAddress = "email@email.ru";
    private By submitButton = By.xpath("//button[@name='submit']");

    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    public void inputEmailForReset(String emailAddress) {
        driver.findElement(emailInputField).sendKeys(emailAddress);
        driver.findElement(submitButton).click();
    }

    public String getForgotPwdMessageText() {
        //return driver.findElement(By.xpath("//div[@role='alertdialog']")).getText();
        WebElement textMessage = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='alertdialog']")));
        return textMessage.getText();
    }
}
