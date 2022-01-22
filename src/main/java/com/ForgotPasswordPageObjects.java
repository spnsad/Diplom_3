package com;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPageObjects {
    public static final String forgotPasswordUrl = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public SelenideElement loginButton;

    //Нажатие на кнопку "Войти"
    public LoginPageObjects clickOnLoginButton() {
        loginButton.click();
        return page(LoginPageObjects.class);
    }
}
