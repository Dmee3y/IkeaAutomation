package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By continueButton = By.xpath("//button[@type='submit']");
    private By emailErrorMsg = By.xpath("(//div[@class='inline-text'])[1]");
    private By pwdErrorMsg = By.xpath("(//div[@class='inline-text'])[2]");
    private By forgotPasswordLink = By.xpath("//*[@name='forgotPassword']");
    private By emailInputField = By.id("username");
    private By submitButton = By.xpath("//button[@name='submit']");

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

    public void inputEmailForReset(String emailAddress) {
        driver.findElement(emailInputField).sendKeys(emailAddress);
        driver.findElement(submitButton).click();
    }

    public String getForgotPwdMessageText() {
        return driver.findElement(By.xpath("//div[@role='alertdialog']")).getText();
    }

//    public class ForgotPasswordPage {
//        private WebDriver driver;
//        private By forgotPasswordLink = By.xpath("//a[@name='forgotPassword']");
//
//        public void clickForgotPasswordLink() {
//            driver.findElement(forgotPasswordLink).click();
//        }
//    }
//
//    public class ConfirmPasswordPage {
//        private WebDriver driver;
//
//        private By changePwdDialog = By.xpath("//div[@role='alertdialog']");
//
//        public String getConfirmChangePwdText() {
//            return driver.findElement(changePwdDialog).getText();
//        }
//    }
}
