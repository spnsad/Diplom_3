package Chrome;

import com.LoginPageObjects;
import org.junit.Assert;
import org.junit.Test;

import static com.StellarBurgersMainPageObjects.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ClickOnYourCabinetTest {

    @Test
    public void clickOnYourCabinetTest(){
        openMainPage();
        clickOnYourCabinet();
        Assert.assertEquals("Открылась страница с некорректным URL", LoginPageObjects.loginUrl, url());
    }
}

