package Yandex;

import com.LoginPageObjects;
import com.RegisterPageObjects;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class SuccessRegistrationTest {
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
    }

    @Test
    public void checkSuccessRegistration() {
        open(RegisterPageObjects.registerUrl, RegisterPageObjects.class)
                .successRegistrationNewUser();
        boolean isLoginButtonVisible = LoginPageObjects
                .isEnterHeaderVisible();
        assertTrue("Login button is not displayed", isLoginButtonVisible);
    }
}
