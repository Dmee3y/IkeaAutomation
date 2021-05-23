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
    private By emailInputField = By.id("username");
    private By submitButton = By.xpath("//button[@name='submit']");


    public void inputEmailForReset(String emailAddress) {
        driver.findElement(emailInputField).sendKeys(emailAddress);
        driver.findElement(submitButton).click();
    }

    public String getForgotPwdMessageText() {
        WebElement textMessage = new WebDriverWait(driver, 12)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));
        return textMessage.getText();
    }
}
