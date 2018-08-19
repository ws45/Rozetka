package ua.com.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class PreComparisonPage {

    public void clickCompareGoodsBtn() {
        ElementsCollection compareGoodsItems = $$("span.btn-link-i");
        String compareGoodsItem = "Сравнить эти товары";
        for (SelenideElement compareGoodsListItem : compareGoodsItems) {
            if (compareGoodsListItem.getText().contains(compareGoodsItem)) {
                compareGoodsListItem.click();
                break;
            }
        }
    }
}
