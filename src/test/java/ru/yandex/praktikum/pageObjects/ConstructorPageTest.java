package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.TestBase;
import static org.junit.Assert.*;

public class ConstructorPageTest extends TestBase {

    @Test
    @DisplayName("Переход к разделу Булки на странице Конструктора")
    @Step("Переход к разделу Булки")
    public void checkGoToBunSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        mainPage.clickOnBunButton();
        assertTrue(mainPage.isCraterBunVisible());
    }

    @Test
    @DisplayName("Переход к разделу Соусы на странице Конструктора")
    @Step("Переход к разделу Соусы")
    public void checkGoToSauceSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        assertTrue(mainPage.isThornSauceVisible());
    }

    @Test
    @DisplayName("Переход к разделу Начинки на странице Конструктора")
    @Step("Переход к разделу Начинки")
    public void checkGoToFillingSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnFillingButton();
        assertTrue(mainPage.isLumineMeatVisible());
    }
}
