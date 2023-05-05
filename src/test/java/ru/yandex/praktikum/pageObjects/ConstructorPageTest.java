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
        String expectedTabName = "Булки";
        assertEquals(expectedTabName, mainPage.getTextFromActiveTab());
    }

    @Test
    @DisplayName("Переход к разделу Соусы на странице Конструктора")
    @Step("Переход к разделу Соусы")
    public void checkGoToSauceSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSauceButton();
        String expectedTabName = "Соусы";
        assertEquals(expectedTabName, mainPage.getTextFromActiveTab());
    }

    @Test
    @DisplayName("Переход к разделу Начинки на странице Конструктора")
    @Step("Переход к разделу Начинки")
    public void checkGoToFillingSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnFillingButton();
        String expectedTabName = "Начинки";
        assertEquals(expectedTabName, mainPage.getTextFromActiveTab());
    }
}
