package Chrome;

import com.RegisterPageObjects;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class FailedRegistrationTest {
    @Test
    public void checkFailRegistration() {
        boolean isIncorrectPasswordMessage = open(RegisterPageObjects.registerUrl, RegisterPageObjects.class)
                .failRegistrationNewUser()
                .isIncorrectPasswordMessage();
        assertTrue("Не появилось сообщение о некорректном пароле", isIncorrectPasswordMessage);
    }
}
