package Yandex;

import com.StellarBurgersMainPageObjects;
import org.junit.Before;
import org.junit.Test;

import static com.StellarBurgersMainPageObjects.mainUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class GoToConstructorIngredientsTest {
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
    }

    @Test
    public void goToConstructorSaucesTest(){
        boolean areSaucesVisible = open(mainUrl, StellarBurgersMainPageObjects.class)
                .clickOnSaucesButton()
                .areSaucesVisible();
        assertTrue("Раздел с соусами не отображается", areSaucesVisible);
    }

    @Test
    public void goToConstructorFillingsTest(){
        boolean areFillingsVisible = open(mainUrl, StellarBurgersMainPageObjects.class)
                .clickOnFillingsButton()
                .areFillingsVisible();
        assertTrue("Раздел с начинками не отображается", areFillingsVisible);
    }

    @Test
    public void goToConstructorBunsTest(){
        boolean areBunsVisible = open(mainUrl, StellarBurgersMainPageObjects.class)
                .clickOnFillingsButton()
                .clickOnBunsButton()
                .areBunsVisible();
        assertTrue("Раздел с булками не отображается", areBunsVisible);
    }
}
