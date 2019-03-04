package config;
import helpers.PropertiesManager;
import objects.Profile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import objects.MainPage;


public class Configuration {
    public WebDriver driver;

    public WebDriver setUpDriver() throws Exception {
        String browser = PropertiesManager.PropertyReader("src/test/resources/properties/config.properties", "browser").toLowerCase();
        String system = PropertiesManager.PropertyReader("src/test/resources/properties/config.properties", "system").toLowerCase();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        if(system.equals("windows")){
            if(browser.equals("chrome")){
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")){
                System.setProperty("webdriver.chrome.driver","path");
                driver = new ChromeDriver();
            }
        } else if (system.equals("linux")){
            if(browser.equals("chrome")){
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")){
                System.setProperty("webdriver.chrome.driver","path");
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{
        setUpDriver();
    }

    public MainPage openMainPage(){
        driver.get(Selectors.url);
        driver.manage().window().maximize();
        return new MainPage(driver);
    }




}
