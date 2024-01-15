
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

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; 


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
		
		// Get the element with class="custom_dummy_label"
		WebElement labelElement = driver.findElement(By.className("custom_dummy_label"));

		// Get the text of the label
		String labelText = labelElement.getText();

		// Get the input field with id="input"
		WebElement inputField = driver.findElement(By.id("input"));

		// Clear the input field
		inputField.clear();

		// Paste the label's text into the input field
		inputField.sendKeys(labelText);

		// Get the button with id="next"
		WebElement nextButton = driver.findElement(By.id("next"));

		// Click the next button
		nextButton.click();
		
	
		//Level 4
		
		// Get the four buttons
		List<WebElement> buttons = driver.findElements(By.cssSelector("a.btn.btn-dark.btn-lga"));

		// Iterate over the buttons and click them
		for (WebElement button : buttons) {
			button.click();
		}
		
		
		//Level 5
		
		// Get the link
		WebElement link = driver.findElement(By.linkText("Enlace!"));

		// Click the link
		link.click();
		

		//Level 6
		
		// Get the hidden button element
		WebElement button = driver.findElement(By.id("hidden\""));
				
		// Execute JavaScript to make the button visible and click
		String onClick = button.getAttribute("onClick");
		((JavascriptExecutor)driver).executeScript(onClick);
		

		//Level 7
		

		//Level 8
		

		//Level 9
		

		//Level 10
		
		
	}

}
