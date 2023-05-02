package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.TestBase;
import static org.junit.Assert.*;

public class ConstructorPageTest extends TestBase {

    @Test
    @DisplayName("Переход к разделу Булки на странице Конструктора")
    //сначала перейти на раздел с соусами/начинками, а потом на раздел Булки
    //т.к. при открытии главной страницы дефолтно открыт раздел Булки
    public void checkGoToBunSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        mainPage.clickOnBunButton();
        assertTrue(mainPage.isCraterBunVisible());
    }

    @Test
    @DisplayName("Переход к разделу Соусы на странице Конструктора")
    public void checkGoToSauceSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        assertTrue(mainPage.isThornSauceVisible());
    }

    @Test
    @DisplayName("Переход к разделу Начинки на странице Конструктора")
    public void checkGoToFillingSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnFillingButton();
        assertTrue(mainPage.isLumineMeatVisible());
    }
}
