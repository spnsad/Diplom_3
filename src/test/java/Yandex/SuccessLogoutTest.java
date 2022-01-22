package Yandex;

import com.LoginPageObjects;
import com.LogoutPageObjects;
import com.StellarBurgersMainPageObjects;
import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class SuccessLogoutTest {
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
    public void checkSuccessLogout() {
        LogoutPageObjects.successLogout(userOperations);
        boolean isLoginButtonVisibleAfterLogout = LoginPageObjects.isEnterHeaderVisible();
        assertTrue("Кнопка входа после разлогинивания отсутствует", isLoginButtonVisibleAfterLogout);
    }
}
