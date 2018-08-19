package ua.com.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class NotebooksPage {

    public void openNotebooksWithSSD() {
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
