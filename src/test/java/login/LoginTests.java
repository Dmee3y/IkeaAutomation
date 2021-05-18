package login;

import base.BaseTest;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTests extends BaseTest {

//    final By emailErrorMsg = By.xpath("//span[contains(text(),'ИКЕА не знакома с вами... пока. " +
//            "Пожалуйста, зарегистрируйтесь.')]");
    final String emailErrorMsg = "ИКЕА не знакома с вами... пока. " +
            "Пожалуйста, зарегистрируйтесь.";
//    final By passwordErrorMsg = By.xpath("//span[contains(text(),'К сожалению, вы не можете войти " +
//            "в свой аккаунт без пароля')]");

    final String passwordErrorMsg = "К сожалению, вы не можете войти в свой аккаунт без пароля";

    @Test
    public void testEmptyEmailField() {
        LoginPage loginPage = homePage.clickLoginPageLink();
        loginPage.clickContinueButton();

        assertEquals(loginPage.getEmailErrorMessage(), emailErrorMsg, "Wrong email error message");
    }

    @Test
    public void testEmptyPasswordField() {
        LoginPage loginPage = homePage.clickLoginPageLink();
        loginPage.clickContinueButton();

        assertEquals(loginPage.getPwdErrorMessage(), passwordErrorMsg, "Wrong password error message");
    }
}
