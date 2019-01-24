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

public class PasswordResetTest {


    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    File pathToBinary = new File("C:\\Users\\dayan.graham\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
    FirefoxProfile firefoxProfile = new FirefoxProfile();
    WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);

    @Before
    public void setUp() throws Exception {

        baseUrl = "https://pp-portal.crises-control.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testPasswordResetTestJava() throws Exception {
        driver.get(baseUrl + "/users/login");

        //This block loads info from CSV
        int i ;
        i =  Integer.parseInt(JOptionPane.showInputDialog("Enter the ID Number you wish to test with: "));
        CSVLoad holder = new CSVLoad();
        List userinfo = holder.fetch(i);
        String forename = userinfo.get(1).toString() ;
        String surname = userinfo.get(2).toString() ;
        String email = userinfo.get(3).toString() ;
        String password = userinfo.get(4).toString() ;


        driver.findElement(By.id("btn_forgot_pass")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Captcha")).clear();
        String captcha ;
        captcha =  JOptionPane.showInputDialog("Enter the CAPTCHA: ");
        driver.findElement(By.id("Captcha")).sendKeys(captcha);
        driver.findElement(By.id("btn_continue")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("btn_continue")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        driver.get(baseUrl + "/users/login");
        driver.findElement(By.id("Primary_Email")).clear();
        driver.findElement(By.id("Primary_Email")).sendKeys(email);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
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


