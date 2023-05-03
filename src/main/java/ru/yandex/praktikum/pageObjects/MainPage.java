package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    //кнопка Булки
    private final By bunButton = By.xpath(".//span[text()='Булки']");
    //иконка булки "Краторная булка"
    private final By craterBun = By.xpath(".//img[@alt='Краторная булка N-200i']");
    //кнопка Соусы
    private final By sauceButton = By.xpath(".//span[text()='Соусы']");;
    //иконка соуса "Соус с шипами"
    private final By thornSauce = By.xpath(".//img[@alt='Соус с шипами Антарианского плоскоходца']");
    //кнопка Начинки
    private final By fillingButton = By.xpath(".//span[text()='Начинки']");
    //иконка начинки "Филе Люминесцентного тетраодонтимформа"
    private final By lumineMeat = By.xpath(".//img[@alt='Филе Люминесцентного тетраодонтимформа']");
    //кнопка "Личный кабинет"
    private final By lkButton = By.xpath(".//p[text()='Личный Кабинет']");
    //кнопка "Войти в аккаунт"
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка "Оформить заказ" - появляется только у авторизованного пользователя
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //нажатие на раздел Булки
    public void clickOnBunButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(bunButton));
        driver.findElement(bunButton).click();
    }
    //нажатие на раздел Соусы
    public void clickOnSauceButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceButton));
        driver.findElement(sauceButton).click();
    }
    //нажатие на раздел Начинки
    public void clickOnFillingButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingButton));
        driver.findElement(fillingButton).click();
    }
    //проверить, что виден "соус с шипами"
    public boolean isThornSauceVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(thornSauce));
        return driver.findElement(thornSauce).isDisplayed();
    }
    //проверить, что видно "люминесцентное филе"
    public boolean isLumineMeatVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(lumineMeat));
        return driver.findElement(lumineMeat).isDisplayed();
    }
    //проверить, что видно "краторную булку"
    public boolean isCraterBunVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(craterBun));
        return driver.findElement(craterBun).isDisplayed();
    }
    //нажатие на кнопку "Войти в аккаунт"
    public void clickOnSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();
    }
    //нажатие на кнопку "Личный кабинет"
    public void clickOnLkButtonPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(lkButton));
        driver.findElement(lkButton).click();
    }
    //отображение кнопки "Оформить заказ" (для авторизованных пользователей)
    public boolean isCreateOrderButtonVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }
}