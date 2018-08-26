package ua.com.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComparisonPage {

    private static Logger logger = Logger.getLogger(ComparisonPage.class);

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
        logger.info("Количество отличающихся строк подсчитано");
        return countDifferentElementsManually();
    }

    public void clickOnlyDifferencesBtn() {
        logger.info("Кнопка Только отличия кликнута");
        $(By.xpath("//*[@id=\"compare-menu\"]/ul/li[2]/a")).click();
    }
}
