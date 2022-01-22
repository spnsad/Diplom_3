package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class LogoutPageObjects {
    public static final String accountProfileUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    //Кнопка "Выход" в профиле
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    public static SelenideElement logoutButton;

    //Нажатие на кнопку "Выход"
    public static void clickLogoutButton() {
        logoutButton.click();
    }

    //Успешный выход из личного кабинета
    public static LoginPageObjects successLogout(UserOperations userOperations){
        open(StellarBurgersMainPageObjects.mainUrl, StellarBurgersMainPageObjects.class)
                .clickEnterAccountButton();
        LoginPageObjects.successLoginUser(userOperations);
        StellarBurgersMainPageObjects.clickOnYourCabinet();
        page(LogoutPageObjects.class);
        clickLogoutButton();
        LoginPageObjects.enterHeader.shouldBe(Condition.visible);
        return page(LoginPageObjects.class);
    }
}
