import com.LoginPageObject;
import com.StellarBurgersMainPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.StellarBurgersMainPageObject.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

@RunWith(Parameterized.class)
public class ClickOnYourCabinetTest {

    public String browser;

    public ClickOnYourCabinetTest(String browser) {
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
        openInDifferentBrowsers(browser);
    }

    @After
    public void tearDown(){
        getWebDriver().close();
    }

    @Test
    public void clickOnYourCabinetTest(){
        StellarBurgersMainPageObject openMain = open("https://stellarburgers.nomoreparties.site/", StellarBurgersMainPageObject.class);
        clickOnYourCabinet();
        Assert.assertEquals("Открылась страница с некорректным URL", LoginPageObject.loginUrl, url());
    }
}

