package com;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPageObject {
    public static final String forgotPasswordUrl = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public SelenideElement loginButton;

    //Нажатие на кнопку "Войти"
    public LoginPageObject clickOnLoginButton() {
        loginButton.click();
        return page(LoginPageObject.class);
    }
}
