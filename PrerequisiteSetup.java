import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.io.File;


public class PrerequisiteSetup {


    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    File pathToBinary = new File("C:\\Users\\dayan.graham\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
    //FirefoxProfile firefoxProfile = new FirefoxProfile();
    WebDriver driver = new FirefoxDriver(ffBinary/*,firefoxProfile*/);

    @Before
    public void setUp() throws Exception {

        baseUrl = "https://pp-portal.crises-control.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLocationCreate() throws Exception {
        driver.get("https://pp-portal.crises-control.com/location");
        // Warning: assertTextPresent may require manual changes
        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
        driver.findElement(By.xpath("//a[contains(@class,\"btn btn-success dropdown-toggle\")]")).click();
        driver.findElement(By.xpath("//a[contains(@href,\"https://pp-portal.crises-control.com/location/create\")]")).click();
        driver.findElement(By.xpath("//input[contains(@id,\"LocationName\")]")).click();
        driver.findElement(By.xpath("//input[contains(@id,\"LocationName\")]")).sendKeys("Automated Test Location");
        driver.findElement(By.xpath("//input[contains(@id,\"LocationAddress\")]")).sendKeys("20 Warley St, London E2 0PZ, UK");
        driver.findElement(By.xpath("//input[contains(@id,\"LocationLat\")]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,\"LocationLat\")]")).sendKeys("51.5265745");
        driver.findElement(By.xpath("//input[contains(@id,\"LocationLng\")]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,\"LocationLng\")]")).sendKeys("-0.0466531");
        driver.findElement(By.xpath("//textarea[contains(@id,\"Description\")]")).sendKeys("test description");
        driver.findElement(By.xpath("//button[contains(@id,\"btn_submit\")]")).click();
        driver.findElement(By.xpath("//button[contains(@class,\"confirm\")]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
