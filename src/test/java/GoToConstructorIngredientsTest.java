import com.StellarBurgersMainPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.StellarBurgersMainPageObject.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class GoToConstructorIngredientsTest {

    public String browser;

    public GoToConstructorIngredientsTest(String browser) {
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
    public void goToConstructorSaucesTest(){
        boolean areSaucesVisible = open(mainUrl, StellarBurgersMainPageObject.class)
                .clickOnSaucesButton()
                .areSaucesVisible();
        assertTrue("Раздел с соусами не отображается", areSaucesVisible);
    }

    @Test
    public void goToConstructorFillingsTest(){
        boolean areFillingsVisible = open(mainUrl, StellarBurgersMainPageObject.class)
                .clickOnFillingsButton()
                .areFillingsVisible();
        assertTrue("Раздел с начинками не отображается", areFillingsVisible);
    }

    @Test
    public void goToConstructorBunsTest(){
        boolean areBunsVisible = open(mainUrl, StellarBurgersMainPageObject.class)
                .clickOnFillingsButton()
                .clickOnBunsButton()
                .areBunsVisible();
        assertTrue("Раздел с булками не отображается", areBunsVisible);
    }
}
