package tqs.lab4_1.pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class FirstPage extends BasePage {

    @FindBy(name = "fromPort")
    WebElement fromPort; 

  
    @FindBy(name = "toPort")
    WebElement toPort; 

    @FindBy(xpath = "//input[@value='Find Flights']")
    WebElement find_Flights; 

    public FirstPage(WebDriver driver, int timeoutSec) { 
        this(driver);
        setTimeoutSec(timeoutSec);
    }

    public FirstPage(WebDriver driver) { 
        super(driver);
        visit("https://blazedemo.com/");
    }

    public void chooseFromPort( int i ) {
        Select drop = new Select( (WebElement) fromPort );
        drop.selectByIndex( i );
      }
      
      public void chooseToPort( int i ) {
        Select drop = new Select( (WebElement) toPort );
        drop.selectByIndex( i );
      }
      
      public void confirmFlight() {
        click(find_Flights);
      }


}
