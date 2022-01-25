import com.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SuccessUserLoginTest {
    private UserOperations userOperations;
    public String browser;

    public SuccessUserLoginTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Запуск в браузере {0}")
    public static Object[][] setBrowserData() {
        return new Object[][]{
                {"chrome"},
                {"yandex"},
        };
    }

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @After
    public void tearDown() {
        userOperations.delete();
        getWebDriver().close();
    }

    @Test
    public void checkSuccessLoginInEnterAccountButtonOnManePage() {
        open(StellarBurgersMainPageObject.mainUrl, StellarBurgersMainPageObject.class)
                .clickEnterAccountButton();
        boolean isOrderButtonVisible = LoginPageObject
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка Оформить заказ недоступна. Авторизация прошла неуспешно", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginInYourCabinetEnterButton() {
        open(StellarBurgersMainPageObject.mainUrl, StellarBurgersMainPageObject.class);
        StellarBurgersMainPageObject.clickOnYourCabinetButton();
        boolean isOrderButtonVisible = LoginPageObject
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка Оформить заказ недоступна. Авторизация прошла неуспешно", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginOnRegisterForm() {
        open(RegisterPageObject.registerUrl, RegisterPageObject.class)
                .clickOnLoginButton();
        boolean isOrderButtonVisible = LoginPageObject
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка Оформить заказ недоступна. Авторизация прошла неуспешно", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginOnForgotPasswordForm() {
        open(ForgotPasswordPageObject.forgotPasswordUrl, ForgotPasswordPageObject.class)
                .clickOnLoginButton();
        boolean isOrderButtonVisible = LoginPageObject
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка Оформить заказ недоступна. Авторизация прошла неуспешно", isOrderButtonVisible);
    }
}
