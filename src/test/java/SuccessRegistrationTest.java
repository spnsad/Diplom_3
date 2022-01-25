import com.LoginPageObject;
import com.RegisterPageObject;
import com.StellarBurgersMainPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SuccessRegistrationTest {
    public String browser;

    public SuccessRegistrationTest(String browser) {
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
    public void setUp(){
        StellarBurgersMainPageObject.openInDifferentBrowsers(browser);
    }

    @After
    public void tearDown(){
        getWebDriver().close();
    }

    @Test
    public void checkSuccessRegistration() {
        open(RegisterPageObject.registerUrl, RegisterPageObject.class)
                .successRegistrationNewUser();
        boolean isLoginButtonVisible = LoginPageObject
                .isEnterHeaderVisible();
        assertTrue("Кнопка входа отсутствует", isLoginButtonVisible);
    }
}
