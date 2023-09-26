package TestCases;

import core.BaseTest;
import lombok.Value;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test1 extends BaseTest {
    @Value("${test.url}")
    private String url;
    private WebDriver driver;

    @Test
    public void homePageTest(){
        openPage(url);
        boolean isPageOpen = driver.findElement(By.tagName("body")).isDisplayed();
        Assert.assertTrue("Page not open", isPageOpen);
    }

    @Test
    public void clickHereButton(){
        openPage(url);
        WebElement hereButton = driver.findElement(By.xpath("//a[@class='start__link']"));
        hereButton.click();
        Assert.assertTrue()
    }

    @Test
    public void clickHelpButton(){
        openPage(url);
        WebElement hereButton = driver.findElement(By.xpath("//a[@class='start__link']"));
        hereButton.click();
        WebElement helpButton = driver.findElement(By.xpath("//a[@class='help-form__help-button']"));
        helpButton.click();



    }
}
