package gamescode;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertyFileReader;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ListOfGames {
	
	protected WebDriver driver=null;
	PropertyFileReader configReader=null;
	WebElement elm= null;
	WebDriverWait wait=null;
    private PropertyFileReader objectRepository=null;
	int statusCode;
    

	
  @Test(priority=0)
  
  public void clickOnMeetTourneyLink() throws InterruptedException {
	 
	  Thread.sleep(500);
	  elm=driver.findElement(By.xpath(objectRepository.getValue("availableGames")));
      elm.getText();
      System.out.println(elm.getText());
      List<WebElement> gamesList = driver.findElements(By.xpath(objectRepository.getValue("listOfGames")));
      gamesList.size();
      System.out.println(gamesList.size());
     
      List<WebElement> gamesList1 = driver.findElements(By.xpath(objectRepository.getValue("listOfGames")));
      gamesList.size();
      System.out.println(gamesList.size());
     
      
  }
  
  @Test(priority=1)
  public void getURL() throws InterruptedException {
	  elm=driver.findElement(By.xpath(objectRepository.getValue("clashofClan")));
      elm.click();
      wait = new WebDriverWait(driver, 20);
//      elm=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepository.getValue("heading"))));
//      elm.getText();
      System.out.println(elm.getText());
      
  }
  
  @Test	(priority=2)
	void getUserDetailsTest() {
      //The base URI to be used
	 
      RestAssured.baseURI ="https://www.game.tv/find-tournaments/clash-of-clans-tournaments";

      //Define the specification of request. Server is specified by baseURI above.
      RequestSpecification httpRequest = RestAssured.given();

      //Makes calls to the server using Method type.
      Response response = httpRequest.request(Method.GET, "2");

      //Checks the Status Code
      int statusCode = response.getStatusCode();
      Assert.assertEquals(statusCode, 200);
      
      System.out.println(statusCode);
  }

@BeforeTest
  public void setUp() throws Exception
	{	
		configReader=new PropertyFileReader("./src/main/resources/EnvironmentConfig.properties");
		objectRepository = new PropertyFileReader("./src/main/resources/ObjectRepository.properties");
		
		System.setProperty("webdriver.chrome.driver", "/Users/vandanamoriwal/Desktop/Assignment_BlueStacks/bluestacks.com/drivers/chromedriver");
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
        String url=configReader.getValue("URL");		
		System.out.println("URL: "+url);
		driver.get(url);
		
	}

  @AfterTest
  public void afterTest() {
//	  driver.quit();
  }

}
