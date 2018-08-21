package ua.com.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComparisonPage {

    private int countDifferentElementsManually() {
        ElementsCollection rows = $$("div.comparison-t-row");
        ElementsCollection comparisonItems;

        int counterDifferent = 0;

        for (SelenideElement row : rows) {
            comparisonItems = row.$$("div.comparison-t-cell");

            if (!comparisonItems.get(0).getText().equals(comparisonItems.get(1).getText())) {
                counterDifferent++;
            }
        }
        return counterDifferent;
    }

    public int computeDifferentElementsCount() {
        return countDifferentElementsManually();
    }

    public void clickOnlyDifferencesBtn() {
        $(By.xpath("//*[@id=\"compare-menu\"]/ul/li[2]/a")).click();
    }
}
