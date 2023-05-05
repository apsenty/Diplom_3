package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    //кнопка Булки
    private final By bunButton = By.xpath(".//span[text()='Булки']");
    //кнопка Соусы
    private final By sauceButton = By.xpath(".//span[text()='Соусы']");
    //кнопка Начинки
    private final By fillingButton = By.xpath(".//span[text()='Начинки']");
    //кнопка "Личный кабинет"
    private final By lkButton = By.xpath(".//p[text()='Личный Кабинет']");
    //кнопка "Войти в аккаунт"
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка "Оформить заказ" - появляется только у авторизованного пользователя
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    //локатор активной вкладки в конструкторе
    private final By activeConstructorTab = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //нажатие на раздел Булки
    public void clickOnBunButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(bunButton));
        driver.findElement(bunButton).click();
    }
    //нажатие на раздел Соусы
    public void clickOnSauceButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(sauceButton));
        driver.findElement(sauceButton).click();
    }
    //нажатие на раздел Начинки
    public void clickOnFillingButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
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
    //возвращает название активной вкладки в конструкторе
    public String getTextFromActiveTab() {
        return driver.findElement(activeConstructorTab).getText();
    }
}