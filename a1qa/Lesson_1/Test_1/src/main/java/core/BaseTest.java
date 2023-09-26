package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private static WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bagda\\Documents\\ChromeDriver\\chromedriver.exe");
    }

    @After
    public void quit(){
        driver.quit();
    }

    public static void openPage(String url){
        driver.get(url);
    }
}