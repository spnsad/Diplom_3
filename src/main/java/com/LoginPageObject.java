package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageObject {
    public static final String loginUrl = "https://stellarburgers.nomoreparties.site/login";

    //Заголовок "Вход"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    public static SelenideElement enterHeader;

    //Поля для авторизации
    @FindAll({@FindBy(how = How.XPATH, using = ".//input")})
    public static ElementsCollection inputLoginFields;

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    public static SelenideElement loginButton;

    //Кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public static SelenideElement createOrderButton;

    //Успешная авторизация
    public static StellarBurgersMainPageObject successLoginUser(UserOperations userOperations) {
        List<String> userData = new ArrayList<>(userOperations.register().values());
        String email = userData.get(2);
        String password = userData.get(0);
        inputLoginFields.get(0).sendKeys(email);
        inputLoginFields.get(1).sendKeys(password);
        loginButton.click();
        createOrderButton.shouldBe(Condition.visible);
        return page(StellarBurgersMainPageObject.class);
    }

    //Отображение заголовка "Вход"
    public static boolean isEnterHeaderVisible() {
        return enterHeader.isDisplayed();
    }

    //Нажатие на кнопку вход на странице авторизации
    public void clickOnLoginButton(){
        loginButton.click();
    }
}
