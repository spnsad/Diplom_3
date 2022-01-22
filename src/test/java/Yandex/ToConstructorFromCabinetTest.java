package Yandex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.StellarBurgersMainPageObjects.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ToConstructorFromCabinetTest {
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
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
