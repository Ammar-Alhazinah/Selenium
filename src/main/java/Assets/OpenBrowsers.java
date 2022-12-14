package Assets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowsers {
    public static WebDriver openBrowser(String browser) {

        WebDriver driver;
        if (browser.equals("firefox")) {
            //Setting webdriver.gecko.driver property
            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

            //Instantiating driver object and launching browser
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            //Instantiating driver object
            driver = new ChromeDriver(options);


        } else if (browser.equals("edge")) {
            System.setProperty(
                    "webdriver.edge.driver",
                    "./drivers/msedgedriver.exe");
            // Instantiate a ChromeDriver class.
            driver = new EdgeDriver();
        } else {
            driver = null;
        }

        return driver;
    }

    public static void main(String[] args) throws InterruptedException {
        String[] browsers = {"chrome", "edge", "firefox"};
        for (int i = 0; i < browsers.length; i++) {
            WebDriver driver = OpenBrowsers.openBrowser(browsers[i]);
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            driver.get("https://www.facebook.com/");
            Thread.sleep(3000);
            driver.navigate().back();

            Thread.sleep(3000);
            driver.navigate().forward();
            Thread.sleep(5000);
            driver.quit();
        }
    }
}