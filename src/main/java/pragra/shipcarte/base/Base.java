package pragra.shipcarte.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("/Users/harshithakeshav/IdeaProjects/ShipCarte-TestNG/src/main/resources/data.properties");

        properties.load(fis);

        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/harshithakeshav/Downloads/chromedriver");
             this.driver = new ChromeDriver();
        }

        else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.chrome.driver","/Users/harshithakeshav/Downloads/firefoxdriver");
            this.driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return this.driver;
    }
}
