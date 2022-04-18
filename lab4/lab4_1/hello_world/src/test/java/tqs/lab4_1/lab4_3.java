package tqs.lab4_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.seljup.SeleniumJupiter;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@ExtendWith(SeleniumJupiter.class)
public class lab4_3 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeEach
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts();//.implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
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
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
}
