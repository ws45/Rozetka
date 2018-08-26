package ua.com.rozetka.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private static Logger logger = Logger.getLogger(MainPage.class);

    public void clickLeftBlock() {
        logger.info("В главном меню выбрана категория Ноутбуки и компьютеры");
        ElementsCollection menuCategories = $$("a.f-menu-l-i-link");
        String mainMenuCategory = "Ноутбуки и компьютеры";
        for (SelenideElement menuCategory : menuCategories) {
            if (menuCategory.getText().contains(mainMenuCategory)) {
                menuCategory.hover();
                break;
            }
        }

        $(byXpath("//div[@name='second_menu']")).shouldBe(Condition.visible);
    }

    public void openNotebooksCategory() {
        logger.info("В появившемся списке выбрана категория Ноутбуки");
        for (SelenideElement menuCategory : $$("a.f-menu-sub-title-link")) {
            if (menuCategory.getText().contains("Ноутбуки")) {
                menuCategory.click();
                break;
            }
        }
    }
}
