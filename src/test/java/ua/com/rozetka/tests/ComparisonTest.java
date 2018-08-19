package ua.com.rozetka.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.rozetka.pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static junit.framework.TestCase.assertEquals;

public class ComparisonTest {

    //Properties config
    private static InputStream file;
    private static Properties config = new Properties();

    @BeforeClass

    public static void setUp() throws IOException {

        file = new FileInputStream("src/test/java/ua/com/rozetka/config/config.properties");
        config.load(file);
        String siteAddress = config.getProperty("site.address");

        System.setProperty("webdriver.chrome.driver", "/Users/oleksandr/selenium1/drivers/chromedriver");
        System.setProperty("selenide.browser", "Chrome");
    }

    @Test
    public void differentElementsCount() {
        MainPage mainPage = open("https://rozetka.com.ua/", MainPage.class);

        mainPage.getLeftBlock();
        mainPage.openNotebooksCategory();

        NotebooksPage notebooksPage = new NotebooksPage();
        notebooksPage.openNotebooksWithSSD();

        NotebooksWithSSDPage notebooksWithSSDPage = new NotebooksWithSSDPage();
        notebooksWithSSDPage.putItemToComparison(0);
        notebooksWithSSDPage.putItemToComparison(1);

        notebooksWithSSDPage.clickComparisonBtn();

        PreComparisonPage preComparisonPage = new PreComparisonPage();
        preComparisonPage.clickCompareGoodsBtn();

        ComparisonPage comparisonPage = new ComparisonPage();
        int expectedDifferentElementsCount = comparisonPage.getDifferentElementsCount();

        comparisonPage.clickOnlyDifferencesBtn();

        int actualDifferentElementsCount = comparisonPage.getDifferentElementsCount();
        assertEquals(expectedDifferentElementsCount, actualDifferentElementsCount);
    }
}