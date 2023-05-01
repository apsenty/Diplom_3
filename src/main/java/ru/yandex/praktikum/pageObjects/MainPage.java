package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    //кнопка Булки
    private By bunButton = By.xpath(".//span[text()='Булки']");
    //иконка булки "Краторная булка"
    private By craterBun = By.xpath(".//img[@alt='Краторная булка N-200i']");
    //кнопка Соусы
    private By sauceButton = By.xpath(".//span[text()='Соусы']");;
    //иконка соуса "Соус с шипами"
    private By thornSauce = By.xpath(".//img[@alt='Соус с шипами Антарианского плоскоходца']");
    //кнопка Начинки
    private By fillingButton = By.xpath(".//span[text()='Начинки']");
    //иконка начинки "Филе Люминесцентного тетраодонтимформа"
    private By lumineMeat = By.xpath(".//img[@alt='Филе Люминесцентного тетраодонтимформа']");
    //кнопка "Личный кабинет"
    private By lkButton = By.xpath(".//a[@href='/account']");
    //кнопка "Войти в аккаунт"
    private By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //нажатие на раздел Булки
    public void clickOnBunButton() {
        driver.findElement(bunButton).click();
    }
    //нажатие на раздел Соусы
    public void clickOnSauceButton() {
        driver.findElement(sauceButton).click();
    }
    //нажатие на раздел Начинки
    public void clickOnFillingButton() {
        driver.findElement(fillingButton).click();
    }
    //проверить, что виден "соус с шипами"
    public boolean checkThornSauceIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(thornSauce));
        return driver.findElement(thornSauce).isDisplayed();
    }
    //проверить, что видно "люминесцентное филе"
    public boolean checkLumineMeatIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(lumineMeat));
        return driver.findElement(lumineMeat).isDisplayed();
    }
    //проверить, что видно "краторную булку"
    public boolean checkCraterBunIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(craterBun));
        return driver.findElement(craterBun).isDisplayed();
    }
    //нажатие на кнопку "Войти в аккаунт"
    public void clickOnSignInButton() {
        driver.findElement(signInButton).click();
    }
    //нажатие на кнопку "Личный кабинет"
    public void clickOnLkButton() {
        driver.findElement(lkButton).click();
    }
}