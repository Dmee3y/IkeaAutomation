package login;

import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTests extends BaseTest {

    private final String emailErrorMsg = "ИКЕА не знакома с вами... пока. " +
            "Пожалуйста, зарегистрируйтесь.";
    private final String passwordErrorMsg = "К сожалению, вы не можете войти в свой аккаунт без пароля";

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
