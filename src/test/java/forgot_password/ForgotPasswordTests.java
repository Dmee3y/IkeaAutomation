package forgot_password;

import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;

public class ForgotPasswordTests extends BaseTest {

    final String expectedMessage = "Вам было отправлено письмо со ссылкой для смены пароля.\nСкрыть";

    @Test
    public void testForgotPwdMessage() {
        LoginPage loginPage = homePage.clickLoginPageLink();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordLink();
        forgotPasswordPage.inputEmailForReset("email@email.ru");

        assertEquals(forgotPasswordPage.getForgotPwdMessageText(), expectedMessage, "Wrong password reset message");
    }
}
