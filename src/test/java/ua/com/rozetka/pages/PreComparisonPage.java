package ua.com.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$$;

public class PreComparisonPage {

    private static Logger logger = Logger.getLogger(PreComparisonPage.class);

    public void clickCompareGoodsBtn() {
        logger.info("Кнопка Сравнить эти товары кликнута");
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
