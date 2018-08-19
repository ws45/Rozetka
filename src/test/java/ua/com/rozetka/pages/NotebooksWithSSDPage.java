package ua.com.rozetka.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class NotebooksWithSSDPage {

    private void addItemsToComparison(int itemNumber) {
        ElementsCollection itemBoards = $$("div.g-i-tile-i-box-desc");
        SelenideElement itemBoard = itemBoards.get(itemNumber);
        itemBoard.hover();

        itemBoard.$("span.g-compare").shouldBe(Condition.visible).click();
        sleep(800);
    }

    public void putItemToComparison(int itemNumber) {
        addItemsToComparison(itemNumber);
    }

    public void clickComparisonBtn() {
        ElementsCollection comperisonItems = $$("a.hub-i-link.hub-i-comparison-link-count.sprite-side.whitelink");
        String comperisonBtn = "Сравнение";
        for (SelenideElement comparisonListItem : comperisonItems) {
            if (comparisonListItem.getText().contains(comperisonBtn)) {
                comparisonListItem.click();
                break;
            }
        }
    }
}
