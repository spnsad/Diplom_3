package Chrome;

import com.LoginPageObjects;
import com.RegisterPageObjects;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertTrue;

public class SuccessRegistrationTest {
    @Test
    public void checkSuccessRegistration() {
        open(RegisterPageObjects.registerUrl, RegisterPageObjects.class)
                .successRegistrationNewUser();
        boolean isLoginButtonVisible = LoginPageObjects
                .isEnterHeaderVisible();
        assertTrue("Кнопка входа отсутствует", isLoginButtonVisible);
    }
}
