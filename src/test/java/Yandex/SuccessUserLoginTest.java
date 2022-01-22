package Yandex;

import com.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class SuccessUserLoginTest {
    private UserOperations userOperations;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @Test
    public void checkSuccessLoginInEnterAccountButtonOnManePage() {
        open(StellarBurgersMainPageObjects.mainUrl, StellarBurgersMainPageObjects.class)
                .clickEnterAccountButton();
        boolean isOrderButtonVisible = LoginPageObjects
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка Оформить заказ недоступна. Авторизация прошла неуспешно", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginInYourCabinetEnterButton() {
        open(StellarBurgersMainPageObjects.mainUrl, StellarBurgersMainPageObjects.class);
        StellarBurgersMainPageObjects.clickOnYourCabinetButton();
        boolean isOrderButtonVisible = LoginPageObjects
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка Оформить заказ недоступна. Авторизация прошла неуспешно", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginOnRegisterForm() {
        open(RegisterPageObjects.registerUrl, RegisterPageObjects.class)
                .clickOnLoginButton();
        boolean isOrderButtonVisible = LoginPageObjects
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка Оформить заказ недоступна. Авторизация прошла неуспешно", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginOnForgotPasswordForm() {
        open(ForgotPasswordPageObjects.forgotPasswordUrl, ForgotPasswordPageObjects.class)
                .clickOnLoginButton();
        boolean isOrderButtonVisible = LoginPageObjects
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка Оформить заказ недоступна. Авторизация прошла неуспешно", isOrderButtonVisible);
    }
}
