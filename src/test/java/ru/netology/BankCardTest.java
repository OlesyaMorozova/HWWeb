package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BankCardTest {
    @Test
    void orderACardTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=name] input").setValue("Олеся");
        form.$("[data-test-id=phone] input").setValue("+79275555555");
        form.$("[data-test-id=agreement]").click();
        form.$(("button")).click();
        $(".paragraph").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
