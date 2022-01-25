import com.LoginPageObject;
import com.LogoutPageObject;
import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SuccessLogoutTest {
    private UserOperations userOperations;
    public String browser;

    public SuccessLogoutTest(String browser) {
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
    public void checkSuccessLogout() {
        LogoutPageObject.successLogout(userOperations);
        boolean isLoginButtonVisibleAfterLogout = LoginPageObject.isEnterHeaderVisible();
        assertTrue("Кнопка входа после разлогинивания отсутствует", isLoginButtonVisibleAfterLogout);
    }
}
