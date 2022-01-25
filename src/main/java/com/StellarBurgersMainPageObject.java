package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class StellarBurgersMainPageObject {
    public static final String mainUrl = "https://stellarburgers.nomoreparties.site/";

    //Локаторы
    //Логотип Stellar Burgers на главной странице
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    public static SelenideElement stellarBurgersHeaderLogo;

    //Личный кабинет на главной странице
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    public static SelenideElement cabinetMainButton;

    //Кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    public SelenideElement signInAccountMainPageButton;

    //Кнопка "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private static SelenideElement logoutButton;

    //Кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    public static SelenideElement constructorButton;

    //Булки в конструкторе
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private static SelenideElement bunsButton;

    //Начинки в конструкторе
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    public static SelenideElement fillingsButton;

    //Соусы в конструкторе
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    public static SelenideElement saucesButton;

    //Блок с ингредиентами на главной странице
    @FindAll({@FindBy(how = How.XPATH, using = ".//ul[@class='BurgerIngredients_ingredients__list__2A-mT']")})
    public static ElementsCollection ingredientsList;

    //Кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement createOrderButton;


    //Открыть главную страницу
    public static void openMainPage() {
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        StellarBurgersMainPageObject openMain = open("https://stellarburgers.nomoreparties.site/", StellarBurgersMainPageObject.class);
    }

    //Открыть главную страницу в разных браузерах
    public static void openMainPageInDifferentBrowsers(String browser) {
        if (browser.equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        } else if (browser.equals("chrome")){
            System.setProperty("selenide.browser", "chrome");
        }
    }

    //Открыть страницу в разных браузерах
    public static void openInDifferentBrowsers(String browser) {
        if (browser.equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        } else if (browser.equals("chrome")){
            System.setProperty("selenide.browser", "chrome");
        }
    }

    //Нажатие на кнопку Личный Кабинет
    public static void clickOnYourCabinet(){
        cabinetMainButton.click();
    }

    //Нажатие на логотип Stellar Burgers
    public static void clickOnStellarBurgersLogo(){
        stellarBurgersHeaderLogo.click();
    }

    //Нажатие на кнопку Конструктор
    public static void clickOnConstructorButton(){
        constructorButton.click();
    }

    //Переход в Булки
    public StellarBurgersMainPageObject clickOnBunsButton() {
        bunsButton.click();
        ingredientsList.get(0).shouldBe(Condition.visible);
        return this;
    }

    //Переход в Соусы
    public StellarBurgersMainPageObject clickOnSaucesButton() {
        saucesButton.click();
        ingredientsList.get(1).shouldBe(Condition.visible);
        return this;
    }

    //Переход в Начинки
    public StellarBurgersMainPageObject clickOnFillingsButton() {
        fillingsButton.click();
        ingredientsList.get(2).shouldBe(Condition.visible);
        return this;
    }

    //Проверка видимости булок
    public boolean areBunsVisible() {
        return ingredientsList.get(0).isDisplayed();
    }

    //Проверка видимости соусов
    public boolean areSaucesVisible() {
        return ingredientsList.get(1).isDisplayed();
    }

    //Проверка видимости начинок
    public boolean areFillingsVisible() {
        return ingredientsList.get(2).isDisplayed();
    }

    //Нажатие на кнопку "Войти в аккаунт" на главной странице
    public LoginPageObject clickEnterAccountButton() {
        signInAccountMainPageButton.click();
        return page(LoginPageObject.class);
    }

    //Нажатие на кнопку "Войти" в личном кабинете
    public static LoginPageObject clickOnYourCabinetButton() {
        clickOnYourCabinet();
        return page(LoginPageObject.class);
    }

    //Нажатие на кнопку "Выход"
    public static LoginPageObject clickLogoutButton() {
        logoutButton.click();
        LoginPageObject.isEnterHeaderVisible();
        return page(LoginPageObject.class);
    }

    //Проверка видимости кнопки Оформить заказ
    public boolean isOrderButtonVisible() {
        return createOrderButton.isDisplayed();
    }
}
