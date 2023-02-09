import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

    public class StepsAllureTest {

        WebSteps test = new WebSteps();
        private static final String repository = "ridarella13/allureTest";
        private static final int issue = 1;


        @Feature("Issue в репозиторий")
        @Story("Создание Issue")
        @Owner("ridarella13")
        @DisplayName("Allure: аннотация @Step")
        @Test
        public void testIssueSearch() {

            SelenideLogger.addListener("allure", new AllureSelenide());

            test.openMainPage();
            test.searchRepository(repository);
            test.selectRepository(repository);
            test.takeScreenshot();
            test.openTabIssue();
            test.source();
            test.checkIssueNumber(issue);
}
    }