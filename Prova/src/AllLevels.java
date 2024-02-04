
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration; 


public class AllLevels {
	
	private static WebDriver driver = null;

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
		
		WebElement levelTitleElement=driver.findElement(By.cssSelector("h1"));
		
		//Level 1
		
		assertEquals(levelTitleElement.getText(),"Práctica Selenium");
		
		WebElement startButtonElement=driver.findElement(By.id("start_button"));
		startButtonElement.click();
		
		levelTitleElement=driver.findElement(By.cssSelector("h1"));
		assertEquals(levelTitleElement.getText(),"Level 2");
		
		//Useful to debug by waiting some miliseconds
		Thread.sleep(2000);
		
		//Level 2

		String text="selenium";
		WebElement inputElement = driver.findElement(By.id("input"));
		inputElement.sendKeys(text);

		WebElement nextButtonElement = driver.findElement(By.id("next"));
		nextButtonElement.click();
		
		levelTitleElement=driver.findElement(By.cssSelector("h1"));
		assertEquals("Level 3",levelTitleElement.getText());
		
		Thread.sleep(2000);

		//Level 3
		
		// Locate the element of the label
		WebElement labelElement = driver.findElement(By.className("custom_dummy_label"));

		// Get the text of the label
		String labelText = labelElement.getText();

		// Locate the input field element
		WebElement inputField = driver.findElement(By.id("input"));

		// Clear the input field
		inputField.clear();

		// Paste the label's text into the input field
		inputField.sendKeys(labelText);

		// Locate the button element
		WebElement nextButton = driver.findElement(By.id("next"));

		// Click the next button
		nextButton.click();
		
		// Locate and check the title of next level
		levelTitleElement=driver.findElement(By.cssSelector("h1"));
		assertEquals("Level 4",levelTitleElement.getText());
		
		// Useful to debug by waiting some miliseconds
		Thread.sleep(2000);
	
		//Level 4
		
		// Locate the list of four buttons
		List<WebElement> listButtons = driver.findElements(By.cssSelector("a.btn.btn-dark.btn-lga"));

		// Iterate over the buttons and click them
		for (WebElement changeColorButton : listButtons) {
			changeColorButton.click();
		}
		
		// Locate and check the title of next level
		levelTitleElement=driver.findElement(By.cssSelector("h1"));
		assertEquals("Level 5",levelTitleElement.getText());
		
		// Wait
		Thread.sleep(2000);
		
		//Level 5
		
		// Locate the link element
		WebElement linkElement = driver.findElement(By.linkText("Enlace!"));

		// Click it
		linkElement.click();
		
		// Locate and check the title of next level
		levelTitleElement=driver.findElement(By.cssSelector("h1"));
		assertEquals("Level 6",levelTitleElement.getText());
		
		// Wait
		Thread.sleep(2000);

		//Level 6
		
		// Locate the hidden button element
		WebElement button = driver.findElement(By.id("hidden\""));
				
		// Execute JavaScript to make the button visible and click
		String onClick = button.getAttribute("onClick");
		((JavascriptExecutor)driver).executeScript(onClick);
		
		// Wait
		Thread.sleep(2000);

		//Level 7
		
		// Wait for the alert to appear
		WebDriverWait waitAlert7 = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert7 = waitAlert7.until(ExpectedConditions.alertIsPresent());

		// Assert the alert text
		String expectedAlert7Text = "Quieres ir al siguiente nivel?";
		assertEquals(expectedAlert7Text, alert7.getText());

		// Click the button
		alert7.accept();
		
		// Wait
		Thread.sleep(2000);

		//Level 8
		
		// Wait for the alert to appear
		WebDriverWait waitAlert8 = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert8 = waitAlert8.until(ExpectedConditions.alertIsPresent());
		
		// Assert the alert text
		String expectedAlert8Text = "Introduce el número del próximo nivel y presiona 'Aceptar'";
		assertEquals(expectedAlert8Text, alert8.getText());

		// Write the next level's number in the input text box
		alert8.sendKeys("9");

		// Click the "Aceptar" button
		alert8.accept();
		
		// Locate and check the title of next level
		levelTitleElement=driver.findElement(By.cssSelector("h1"));
		assertEquals("Level 9",levelTitleElement.getText());
		
		// Wait
		Thread.sleep(2000);

		//Level 9
		
		// Given the driver is the WebDriver instance
		String mainWindowHandle = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the number of windows to increase indicating a pop-up
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Switch to the popup window
		for (String windowHandle : driver.getWindowHandles()) {
		    if (!mainWindowHandle.equals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}

		// Extract the text from the pop-up
		WebElement passwordElement = driver.findElement(By.id("pass"));
		String password = passwordElement.getText();

		// Close the pop-up and switch back to the main window
		driver.close();
		driver.switchTo().window(mainWindowHandle);

		// Paste the extracted text into the input box
		WebElement inputElement9 = driver.findElement(By.id("input"));
		inputElement9.sendKeys(password);

		// Click the "Continuar" button
		WebElement continueButton = driver.findElement(By.id("next"));
		continueButton.click();
		
		// Locate and check the title of next level
		levelTitleElement=driver.findElement(By.cssSelector("h1"));
		assertEquals("Level 10",levelTitleElement.getText());
		
		// Wait
		Thread.sleep(2000);

		//Level 10
		
		// Locate the source and target elements
		WebElement sourceElement = driver.findElement(By.id("source"));
		WebElement targetElement = driver.findElement(By.id("target"));

		// Create an instance of the Actions class
		Actions actions = new Actions(driver);

		// Perform drag-and-drop action
		actions.dragAndDrop(sourceElement, targetElement).perform();
		
		// Assert successful test message
		levelTitleElement=driver.findElement(By.cssSelector("h1"));
		assertEquals("¡Enhorabuena! Has llegado al final de la práctica",levelTitleElement.getText());
		
	}

}
