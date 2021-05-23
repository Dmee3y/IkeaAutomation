package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private final By continueButton = By.xpath("//button[@type='submit']");
    private final By emailErrorMsg = By.xpath("(//div[@class='inline-text'])[1]");
    private final By pwdErrorMsg = By.xpath("(//div[@class='inline-text'])[2]");
    private final By forgotPasswordLink = By.xpath("//*[@name='forgotPassword']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String getEmailErrorMessage() {
        return driver.findElement(emailErrorMsg).getText();
    }

    public String getPwdErrorMessage() {
        return driver.findElement(pwdErrorMsg).getText();
    }

    public ForgotPasswordPage clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPasswordPage(driver);
    }
}
