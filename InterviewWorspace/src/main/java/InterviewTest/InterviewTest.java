package InterviewTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class InterviewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System. setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
		// Initialize browser.
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("This is a link")).click();
		driver.navigate().back();
		driver.findElement(By.name("firstName")).sendKeys("Ravish");
		WebElement male = driver.findElement(By.id("male"));
		System.out.println(male.isSelected());
		male.click();
		System.out.println(male.isSelected());
		WebElement female =driver.findElement(By.id("female"));
		System.out.println(female.isSelected());
		female.click();
		System.out.println(female.isSelected());
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		for(WebElement checkbox:checkboxes) {
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
		}
		for(WebElement checkbox:checkboxes) {
			if(checkbox.getAttribute("value").equals("Automation")) {
					checkbox.click();
			}
		}
		Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
		dropdown.selectByValue("Performance");
		dropdown.selectByIndex(0);
		dropdown.selectByVisibleText("Database Testing");
		List<WebElement> dropdowns = dropdown.getOptions();
		for(WebElement e:dropdowns) {
			System.out.println(e.getText());
		}
		
		driver.findElement(By.xpath("//button[text() = 'Generate Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		driver.findElement(By.xpath("//button[text() = 'Generate Confirm Box']")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		
		Actions action = new Actions(driver);
		
		WebElement From = driver.findElement(By.cssSelector("#sourceImage"));
		WebElement To = driver.findElement(By.cssSelector("#targetDiv"));
		action.dragAndDrop(From, To).build().perform();
		
		Actions action2 = new Actions(driver);	
		WebElement doubleclk = driver.findElement(By.cssSelector("##dblClkBtn"));
		
		action2.doubleClick(doubleclk).build().perform();
		
		//driver.close();

	}

}
