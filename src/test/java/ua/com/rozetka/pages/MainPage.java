package ua.com.rozetka.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public void clickLeftBlock() {
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
        //ElementsCollection categoryMenuItems = ;
        //String categoryMenuItem = ;
        for (SelenideElement menuCategory : $$("a.f-menu-sub-title-link")) {
            if (menuCategory.getText().contains("Ноутбуки")) {
                menuCategory.click();
                break;
            }
        }
    }
}
