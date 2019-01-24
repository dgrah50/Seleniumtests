import org.junit.runners.MethodSorters;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

        public Person() {
            Person.Population++;
    }
//    public Person() {
//        this.FName = "Denish";
//        this.LName = "Rai";
//    }
//
//    public Person(string FName) {
//        this.FName = FName;
//        this.LName = "Rai";
//    }
//
//    public Person(string FName, string LName) {
//        this.FName = FName;
//        this.LName = LName;
//    }

    public String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public static String forename;
    public static String surname;
    public static String email;
    public static String password;
    public static File pathToBinary = new File("C:\\Users\\dayan.graham\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    public static FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
    public static FirefoxProfile firefoxProfile = new FirefoxProfile();
    public static WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
    private String lala = "hello there friend";


    @BeforeClass
      public static void setUp() throws Exception {

        System.out.println("before class called");
        System.out.println(lala);

          String baseUrl = "https://pp-portal.crises-control.com/";
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          //This block loads info from CSV
          int i ;
          i =  Integer.parseInt(JOptionPane.showInputDialog("Enter the ID Number you wish to test with: "));
          CSVLoad holder = new CSVLoad();
          List userinfo = holder.fetch(i);
          forename = userinfo.get(1).toString() ;
          surname = userinfo.get(2).toString() ;
          email = userinfo.get(3).toString() ;
          password = userinfo.get(4).toString() ;
          driver.get(baseUrl + "/users/login");
          driver.findElement(By.id("Primary_Email")).clear();
          driver.findElement(By.id("Primary_Email")).sendKeys(email);
          driver.findElement(By.id("password")).clear();
          driver.findElement(By.id("password")).sendKeys(password);
          driver.findElement(By.name("btnLogin")).click();
      }

    @Test
    public void ZZZZtestLoginTestJava() throws Exception {
        //System.out.println("Hello world!");
        baseUrl = ("https://pp-portal.crises-control.com/");
        driver.get("https://www.google.com");
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        System.out.println("hello world");

        driver.findElement(By.id("Primary_Email")).clear();
        driver.findElement(By.id("Primary_Email")).sendKeys(email);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("BadPassword");
        driver.findElement(By.name("btnLogin")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
        driver.findElement(By.xpath(".//*[@id='user-options']/div[1]/div")).click();
        driver.findElement(By.xpath("//a[contains(@href,\"https://pp-portal.crises-control.com/users/logout\")]")).click();


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


