import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.StellarBurgersMainPageObject.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

@RunWith(Parameterized.class)
public class ToConstructorFromCabinetTest {
    public String browser;

    public ToConstructorFromCabinetTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Запуск в браузере {0}")
    public static Object[][] setBrowserData() {
        return new Object[][]{
                {"chrome"},
                //{"yandex"},
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
    public void toConstructorFromCabinetByConstructorButtonTest(){
        openMainPage();
        clickOnYourCabinet();
        clickOnStellarBurgersLogo();
        Assert.assertEquals("Открылась страница с некорректным URL", mainUrl, url());
    }

    @Test
    public void toConstructorFromCabinetByStellarBurgersLogoTest(){
        openMainPage();
        clickOnYourCabinet();
        clickOnStellarBurgersLogo();
        Assert.assertEquals("Открылась страница с некорректным URL", mainUrl, url());
    }
}
