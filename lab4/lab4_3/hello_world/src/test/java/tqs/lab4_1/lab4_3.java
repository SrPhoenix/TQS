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
import tqs.lab4_1.pagemodels.ChooseFlight;
import tqs.lab4_1.pagemodels.FirstPage;
import tqs.lab4_1.pagemodels.FormPage;

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
    
    FirstPage fp = new FirstPage(driver);
    fp.chooseFromPort(0);
    fp.chooseToPort(1);
    fp.confirmFlight();

    ChooseFlight cf = new ChooseFlight(driver);
    cf.confirmFlight();

    FormPage formP = new FormPage(driver);

    formP.fillInputName("vicente costa");
    formP.fillAddress("123 Main St.");
    formP.fillCity("Aveiro");
    formP.fillState("Minesoda");
    formP.fillZipCode("12345");
    formP.fillCreditCardNumber("1232412414124");
    formP.fillNameOnCard("john miles");
    formP.getConfirmPurchaceBtn();
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
