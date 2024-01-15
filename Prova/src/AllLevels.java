
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AllLevels {
	
	private static WebDriver driver = null;
	private By startButton = By.id("start_button");
	private By levelTitle=By.cssSelector("h1");
	private By input = By.id("input");
	private By nextButton = By.id("next");

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		
  		WebDriverManager.chromedriver().setup();
  		ArrayList<String> optionsList = new ArrayList<String>();
		ChromeOptions chromeOptions = new ChromeOptions();
		optionsList.add("--start-maximized");
		optionsList.add("--incognito");
		optionsList.add("disable-notifications");
		chromeOptions.addArguments(optionsList);
		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
  		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		
		driver = new ChromeDriver(chromeOptions);
		
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		//Close browser
		driver.quit();
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		
		//Open URL
		driver.get("https://pruebaselenium.serviciosdetesting.es/");
		WebElement levelTitleElement=driver.findElement(levelTitle);
		
		//Level 1
		assertEquals(levelTitleElement.getText(),"Práctica Selenium");
		WebElement startButtonElement=driver.findElement(startButton);
		startButtonElement.click();
		levelTitleElement=driver.findElement(levelTitle);
		assertEquals(levelTitleElement.getText(),"Level 2");
		
		//Useful to debug by waiting some miliseconds
		Thread.sleep(2000);
		
		//Level 2

		String text="selenium";
		WebElement inputElement = driver.findElement(input);
		inputElement.sendKeys(text);

		WebElement nextButtonElement = driver.findElement(nextButton);
		nextButtonElement.click();

		
		levelTitleElement=driver.findElement(levelTitle);
		assertEquals("Level 3",levelTitleElement.getText());

		//Level 3
		
	
		//Level 4
		
		
		//Level 5
		

		//Level 6
		

		//Level 7
		

		//Level 8
		

		//Level 9
		

		//Level 10
		
		
	}

}
