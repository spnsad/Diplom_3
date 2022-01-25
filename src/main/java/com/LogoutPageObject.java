package com;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogoutPageObject {
    public static final String accountProfileUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    //Кнопка "Выход" в профиле
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private static SelenideElement logoutButton;

    //Нажатие на кнопку "Выход"
    public static LoginPageObject clickLogoutButton() {
        logoutButton.click();
        LoginPageObject.isEnterHeaderVisible();
        return page(LoginPageObject.class);
    }

    //Успешный выход из личного кабинета
    public static LoginPageObject successLogout(UserOperations userOperations){
        open(StellarBurgersMainPageObject.mainUrl, StellarBurgersMainPageObject.class)
                .clickEnterAccountButton();
        LoginPageObject.successLoginUser(userOperations);
        StellarBurgersMainPageObject.clickOnYourCabinet();
        LogoutPageObject.clickLogoutButton();
        return page(LoginPageObject.class);
    }
}
