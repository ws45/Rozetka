package ua.com.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$$;

public class NotebooksPage {

    private static Logger logger = Logger.getLogger(NotebooksPage.class);

    public void openNotebooksWithSSD() {
        logger.info("На новой странице выбрана категория Ноутбуки с SSD");
        ElementsCollection notebooksItems = $$("a.pab-h4-link");
        String notebooksItem = "Ноутбуки с SSD";
        for (SelenideElement listItem : notebooksItems) {
            if (listItem.getText().contains(notebooksItem)) {
                listItem.click();
                break;
            }
        }
    }
}
