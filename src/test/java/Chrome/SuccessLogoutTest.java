package Chrome;

import com.LoginPageObjects;
import com.LogoutPageObjects;
import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class SuccessLogoutTest {
    private UserOperations userOperations;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @Test
    public void checkSuccessLogout(){
        LogoutPageObjects.successLogout(userOperations);
        boolean isLoginButtonVisibleAfterLogout = LoginPageObjects.isEnterHeaderVisible();
        assertTrue("Кнопка входа после разлогинивания отсутствует", isLoginButtonVisibleAfterLogout);
    }
}
