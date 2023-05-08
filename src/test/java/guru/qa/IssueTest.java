package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueTest extends TestBase{
    @Test
    public void testIssueSearch() {
        //SelenideLogger.addListener("allure", new AllureSelenide ());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("aporohova/qa_guru_git_homework");
        $(".header-search-input").submit();

        $(linkText("aporohova/qa_guru_git_homework")).click();
        $("#issues-tab").click();
        $(withText("#3")).should(Condition.exist);
    }

}
