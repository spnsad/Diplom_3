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
public class FailedRegistrationTest {
    public String browser;

    public FailedRegistrationTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Запуск в браузере {0}")
    public static Object[][] setBrowserData() {
        return new Object[][]{
                {"yandex"},
                {"chrome"},
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
    public void checkFailRegistration() {
        boolean isIncorrectPasswordMessage = open(RegisterPageObject.registerUrl, RegisterPageObject.class)
                .failRegistrationNewUser()
                .isIncorrectPasswordMessage();
        assertTrue("Не появилось сообщение о некорректном пароле", isIncorrectPasswordMessage);
    }
}
