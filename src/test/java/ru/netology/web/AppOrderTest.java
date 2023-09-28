package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppOrderTest {
    @Test
    void shouldReturnSuccessRegularNameAndSurname() {
        open("http://0.0.0.0:9999/");
        SelenideElement form = $(".App_appContainer__3jRx1");
        form.$("[data-test-id=name] input").setValue("Михайлов Михаил");
        form.$("[data-test-id=phone] input").setValue("+12345678910");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldReturnSuccessNameAndDoubleSurname() {
        open("http://0.0.0.0:9999/");
        SelenideElement form = $(".App_appContainer__3jRx1");
        form.$("[data-test-id=name] input").setValue("Петров-Михайлов Михаил");
        form.$("[data-test-id=phone] input").setValue("+12345678910");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldReturnSuccessOnlyName() {
        open("http://0.0.0.0:9999/");
        SelenideElement form = $(".App_appContainer__3jRx1");
        form.$("[data-test-id=name] input").setValue("Михаил");
        form.$("[data-test-id=phone] input").setValue("+12345678910");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldReturnSuccessOneLetter() {
        open("http://0.0.0.0:9999/");
        SelenideElement form = $(".App_appContainer__3jRx1");
        form.$("[data-test-id=name] input").setValue("Я");
        form.$("[data-test-id=phone] input").setValue("+12345678910");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}