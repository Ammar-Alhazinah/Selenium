import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestBing {
    //String path = "parameterData.csv";
    static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = OpenBrowsers.openBrowser("chrome");
    }

    @Test(dataProvider = "Data")
    public void testBing(String searchText, String searchResult) throws InterruptedException {

        driver.get("https://www.bing.com/");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.name("q"));
        search.clear();
        search.sendKeys(searchText);
        search.sendKeys(Keys.RETURN);
        String expectedText = (driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/div[1]/h2/a"))).getText();

        System.out.println("--------------------------------------");
        System.out.println(expectedText);
        System.out.println("--------------------------------------");
        assertEquals(expectedText, searchResult);

    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }

    @DataProvider(name = "Data")
    public static Object[][] getData() throws Exception {

        List<String[]> lines = ReadCsvFile.readAllLines("parameterData.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for (String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }
}
