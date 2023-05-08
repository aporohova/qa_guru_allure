package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueTest extends TestBase{
    private static final String REPOSITORY = "aporohova/qa_guru_git_homework";
    private static final int ISSUE = 3;
    @Feature("Check Issue in Repository")
    @Story("Displaying Number of Issue in the Issue Tab")
    @Owner("aporoho")
    @Test
    @DisplayName("Listener Test")
    public void testWithListener () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }

    @Test
    @DisplayName("Lambda Test")

    public void testWithLambda () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу github", () -> {
                open("https://github.com");
    });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Кликаем по ссылке репозитория" + REPOSITORY, () ->{
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем вкладку Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issues с номером" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    @DisplayName("Test with Annotation")
    public void testWithAnnotation (){
        Steps steps = new Steps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIssueWithNumber(ISSUE);

    }

}
