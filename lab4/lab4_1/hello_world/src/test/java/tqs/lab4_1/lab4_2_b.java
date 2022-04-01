package tqs.lab4_1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class lab4_2_b {
  //private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeEach
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

    //driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    //driver.manage().timeouts();//.implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase(FirefoxDriver driver) throws Exception {
    driver.get("https://blazedemo.com/");
    driver.findElement(By.xpath("//body")).click();
    driver.findElement(By.name("fromPort")).click();
    driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
    driver.findElement(By.xpath("//tr[3]/td/input")).click();
    driver.findElement(By.id("inputName")).click();
    driver.findElement(By.id("inputName")).clear();
    driver.findElement(By.id("inputName")).sendKeys("vicente costa");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("123 Main St.");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Aveiro");
    driver.findElement(By.id("state")).clear();
    driver.findElement(By.id("state")).sendKeys("Minesoda");
    driver.findElement(By.id("zipCode")).clear();
    driver.findElement(By.id("zipCode")).sendKeys("12345");
    driver.findElement(By.id("creditCardNumber")).click();
    driver.findElement(By.id("creditCardNumber")).clear();
    driver.findElement(By.id("creditCardNumber")).sendKeys("1232412414124");
    driver.findElement(By.id("creditCardMonth")).click();
    driver.findElement(By.id("creditCardYear")).click();
    driver.findElement(By.id("nameOnCard")).click();
    driver.findElement(By.id("nameOnCard")).clear();
    driver.findElement(By.id("nameOnCard")).sendKeys("john miles");
    driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='home'])[1]/following::div[2]")).click();
    assertEquals("BlazeDemo Confirmation", driver.getTitle());
  }

  @AfterEach
  public void tearDown(FirefoxDriver driver) throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(FirefoxDriver driver, By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent(FirefoxDriver driver) {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText(FirefoxDriver driver) {
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

