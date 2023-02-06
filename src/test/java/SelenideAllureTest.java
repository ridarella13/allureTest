import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

    public class SelenideAllureTest {


        @Test
        public void testIssueSearch() {

            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com/");
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("ridarella/allure-example");
            $(".header-search-input").submit();

            $(linkText("ridarella/allure-example")).click();
            $("#issues-tab").click();
            $(withText("#80")).should(Condition.exist);
        }
    }


