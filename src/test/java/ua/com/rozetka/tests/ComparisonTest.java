package ua.com.rozetka.tests;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.rozetka.pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static junit.framework.TestCase.assertEquals;

public class ComparisonTest {

    private static Logger logger = Logger.getLogger(ComparisonTest.class);
    private static Properties config = new Properties();
    private MainPage mainPage = new MainPage();

    @BeforeClass

    public static void setUp() throws IOException {

        //given
        InputStream file = new FileInputStream("src/test/java/ua/com/rozetka/config/config.properties");
        config.load(file);

        String webDriverKey = config.getProperty("web.driver.key");
        String webDriverLocation = config.getProperty("web.driver.location");
        String browserType = config.getProperty("browser.type");
        String siteAddress = config.getProperty("site.address");

        System.setProperty(webDriverKey, webDriverLocation);
        System.setProperty("selenide.browser", browserType);

        logger.info("Заходим на главную страницу Розетки");
        open(siteAddress);
    }

    @Test
    public void differentElementsCount() {

        //when
        mainPage.clickLeftBlock();
        mainPage.openNotebooksCategory();

        NotebooksPage notebooksPage = new NotebooksPage();
        notebooksPage.openNotebooksWithSSD();

        NotebooksWithSSDPage notebooksWithSSDPage = new NotebooksWithSSDPage();
        notebooksWithSSDPage.putItemToComparison(0);
        notebooksWithSSDPage.putItemToComparison(1);

        notebooksWithSSDPage.clickComparisonBtn();

        new PreComparisonPage().clickCompareGoodsBtn();

        ComparisonPage comparisonPage = new ComparisonPage();
        int expectedDifferentElementsCount = comparisonPage.computeDifferentElementsCount();

        comparisonPage.clickOnlyDifferencesBtn();

        int actualDifferentElementsCount = comparisonPage.computeDifferentElementsCount();

        //then
        assertEquals("Количество различий между товарами, при использовании фильтра," +
                " не соответствует фактическому.", expectedDifferentElementsCount, actualDifferentElementsCount);
    }
}