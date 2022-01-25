package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.UserOperations.EMAIL_POSTFIX;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPageObject {
    public static final String registerUrl = "https://stellarburgers.nomoreparties.site/register";

    //Поля для заполнения данных для регистрации
    @FindAll({@FindBy(how = How.XPATH, using = ".//input")})
    public ElementsCollection registerDataFields;

    //Кнопка "Регистрация"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    public SelenideElement registerButton;

    //Заголовок "Вход"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    public SelenideElement headEnter;

    //Кнопка "Войти" на странице регистрации
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public SelenideElement loginButton;


    //Сообщение о некорректном пароле
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']")
    public SelenideElement incorrectPasswordErrorMessage;

    //Нажатие на кнопку "Регистрация"
    public LoginPageObject clickOnRegisterButton() {
        registerButton.click();
        return page(LoginPageObject.class);
    }

    //Нажатие на кнопку "Войти" на странице регистрации
    public LoginPageObject clickOnLoginButton() {
        loginButton.click();
        return page(LoginPageObject.class);
    }

    //Ошибка при некорректном пароле
    public boolean isIncorrectPasswordMessage() {
        return incorrectPasswordErrorMessage.isDisplayed();
    }

    //Успешная регистрация
    public LoginPageObject successRegistrationNewUser() {
        (registerDataFields.get(0)).sendKeys(RandomStringUtils.randomAlphabetic(12));
        (registerDataFields.get(1)).sendKeys(RandomStringUtils.randomAlphabetic(12) + EMAIL_POSTFIX);
        (registerDataFields.get(2)).sendKeys(RandomStringUtils.randomAlphabetic(6));
        registerButton.click();
        headEnter.shouldBe(Condition.visible);
        return page(LoginPageObject.class);
    }

    //Неуспешная регистрация
    public RegisterPageObject failRegistrationNewUser() {
        (registerDataFields.get(0)).sendKeys(RandomStringUtils.randomAlphabetic(12));
        (registerDataFields.get(1)).sendKeys(RandomStringUtils.randomAlphabetic(12) + EMAIL_POSTFIX);
        (registerDataFields.get(2)).sendKeys(RandomStringUtils.randomAlphabetic(5));
        registerButton.click();
        incorrectPasswordErrorMessage.shouldBe(Condition.visible);
        return this;
    }
}
