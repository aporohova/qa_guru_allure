package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {

    @Step ("Открываем главную страницу github")
    public void openMainPage(){
        open("https://github.com");

    }

    @Step ("Ищем репозиторий {REPOSITORY}")
    public void searchForRepository(String REPOSITORY){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

    }

    @Step ("Кликаем по ссылке репозитория {REPOSITORY}")
    public void clickOnRepositoryLink (String REPOSITORY){
        $(linkText(REPOSITORY)).click();

    }

    @Step ("Открываем вкладку Issues")
    public void openIssuesTab (){
        $("#issues-tab").click();

    }

    @Step ("Проверяем наличие Issues с номером {ISSUE}")
    public void checkIssueWithNumber (int ISSUE){
        $(withText("#" + ISSUE)).should(Condition.exist);

    }
}
