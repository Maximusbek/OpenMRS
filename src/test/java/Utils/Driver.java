package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver(String driverName) {
        if (driver == null) {
            switch (driverName) {
                case "chrome":
                    try {
                        //connecting to EC2 machine "AWS" to node
                        String nodeUrl = "http://18.221.25.136:5555/wd/hub";
                        //chrome driver path in remote desktop
                        File file = new File("C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
                        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                        capabilities.setBrowserName("chrome");
                        capabilities.setPlatform(Platform.ANY);
                        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
                    } catch (MalformedURLException e) {
                        System.out.println("Node Urls is not correct");
                        System.out.println(e.getStackTrace());
                    }
                    break;
                case "chrome1":
                    try {
                        //connecting to EC2 machine "AWS" to node
                        String nodeUrl = "http://18.221.25.136:8888/wd/hub";
                        //chrome driver path in remote desktop
                        File file = new File("C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
                        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                        capabilities.setBrowserName("chrome");
                        capabilities.setPlatform(Platform.ANY);
                        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
                    } catch (MalformedURLException e) {
                        System.out.println("Node Urls is not correct");
                        System.out.println(e.getStackTrace());
                    }
                    break;
                case "firefox":
                    try {
                        //connecting to EC2 machine "AWS" to node
                        String nodeUrl = "http://18.221.25.136:7777/wd/hub";
                        //chrome driver path in remote desktop
                        File file = new File("C:\\Users\\Administrator\\Downloads\\geckodriver.exe");
                        System.setProperty("webdriver.geckodriver.driver", file.getAbsolutePath());
                        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                        capabilities.setBrowserName("firefox");
                        capabilities.setPlatform(Platform.ANY);
                        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
                    } catch (MalformedURLException e) {
                        System.out.println("Node Urls is not correct");
                        System.out.println(e.getStackTrace());
                  }
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
}
