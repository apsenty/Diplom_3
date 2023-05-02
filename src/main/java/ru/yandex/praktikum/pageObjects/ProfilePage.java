package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    //кнопка Выход
    private By signOutButton = By.xpath(".//button[text()='Выход']");
    //кнопка Конструктор
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //логотип Stellar Burgers
    private By stellarBurgersLogo = By.className("AppHeader_header__logo__2D0X2");

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //нажатие кнопки Выход
    public void clickOnSignOutButton() {
        driver.findElement(signOutButton).click();
    }
    //переход на страницу Конструктора (по кнопке Конструктор)
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    //переход на страницу Конструктора (по логотипу)
    public void clickOnStellarBurgersLogo() {
        driver.findElement(stellarBurgersLogo).click();
    }
}
