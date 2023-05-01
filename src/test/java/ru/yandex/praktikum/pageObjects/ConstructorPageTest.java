package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConstructorPageTest extends TestBase {

    @Test
    @DisplayName("Переход к разделу Булки на странице Конструктора")
    //сначала перейти на раздел с соусами/начинками, а потом на раздел Булки
    //т.к. при открытии главной страницы дефолтно открыт раздел Булки
    public void checkGoToBunSection() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSauceButton();
        objMainPage.clickOnBunButton();
        assertTrue(objMainPage.checkCraterBunIsVisible());
    }

    @Test
    @DisplayName("Переход к разделу Соусы на странице Конструктора")
    public void checkGoToSauceSection() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSauceButton();
        assertTrue(objMainPage.checkThornSauceIsVisible());
    }

    @Test
    @DisplayName("Переход к разделу Начинки на странице Конструктора")
    public void checkGoToFillingSection() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnFillingButton();
        assertTrue(objMainPage.checkLumineMeatIsVisible());
    }
}
