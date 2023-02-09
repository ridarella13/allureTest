
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

    public class LambdaAllureTest {
        private static final String repository = "ridarella13/allureTest";
        private static final int issue = 1;

        @Feature("Issue в репозиторий")
        @Story("Проверка Issue")
        @Owner("ridarella13")
        @DisplayName("Пример запуска Allure c Lambda")
        @Test
        public void testIssueSearch() {

            SelenideLogger.addListener("allure", new AllureSelenide());

            step("Открываем главную страницу github.com", () -> {
                open("https://github.com/");
            });
            step("Ищем репозиторий" + repository, () -> {
                $(".header-search-input").click();
                $(".header-search-input").sendKeys(repository);
                $(".header-search-input").submit();
            });
            step("Кликаем по ссылке репозитория" + repository, () -> {
                $(linkText(repository)).click();
            });
            step("Открываем таб Issue", () -> {
                $("#issues-tab").click();
            });
            step("Проверяем наличие Issue с номером" + issue, () -> {
                $(withText("#" + issue)).should(Condition.exist);
            });
        }
    }



