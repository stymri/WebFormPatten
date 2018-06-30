package formfill;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testclass {
	WebDriver driver;
	Formclass fm;
	Jsondatareader jsonread;
	@BeforeTest
	public void beforem()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Common_Resources\\jars\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();


	}

	@Test
	public void test1() {
		driver.get("https://my.naukri.com/account/register/basicdetails");
		driver.findElement(By.xpath("//button[@name='userType' and contains(text(), 'Fresher')]")).click();;

		By formWebElements = By.xpath("//form[@id='basicDetailForm']//input[@type='text' or @type='password']");
		Formclass fm = new Formclass();
		//HashMap<String, InputType> map = fm.getFormWebElements(driver, formWebElements);
		jsonread = new Jsondatareader();
		JSONObject data = jsonread.getData("data.json");
		fm.fillform(driver, formWebElements, data);
		By form = By.xpath("//form[@id='basicDetailForm']");
		WebElement ele = driver.findElement(form);
		ele.submit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello");
		//formWebElements = By.xpath("//form//input[@type='text' or @type='password']");
		//fm.fillform(driver, formWebElements, data);
		//form = By.xpath("//form");
		//ele = driver.findElement(form);
		//ele.submit();
		
		//fm.fill(data, map);
		
	}
	@Test
	public void testfirstnaukri() {
		driver.get("https://www.firstnaukri.com/freshersmnj/index.php/Register/newUser/othersrcp/homebtn");

		By formWebElements = By.xpath("//form//input");
		Formclass fm = new Formclass();
		jsonread = new Jsondatareader();
		JSONObject data = jsonread.getData("firstnaukri.json");
		fm.fillform(driver, formWebElements, data);
		
	}
}
