package Yandex;

import com.LoginPageObjects;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.StellarBurgersMainPageObjects.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ClickOnYourCabinetTest {
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
    }

    @Test
    public void clickOnYourCabinetTest(){
        openMainPage();
        clickOnYourCabinet();
        Assert.assertEquals("Открылась страница с некорректным URL", LoginPageObjects.loginUrl, url());
    }
}

