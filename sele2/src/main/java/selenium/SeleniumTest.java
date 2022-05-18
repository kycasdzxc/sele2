package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
	private WebDriver driver;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/devtools/chromedriver_win32/chromedriver.exe";
	
	private String base_url;
	
	public SeleniumTest() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		driver = (WebDriver) new ChromeDriver();
		base_url = "https://www.yogiyo.co.kr/mobile/?gclid=CjwKCAjwjZmTBhB4EiwAynRmDyvXi5eUV_SCIxak68PgFoJeYdnptwmzj_Lt5_iGs-mgXQhafmKyBhoCcFoQAvD_BwE#/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C/150041/%EC%B9%98%ED%82%A8/";
	}
	
	public void crawl() throws Exception {
		driver.get(base_url);
//		System.out.println(driver.getPageSource());
		driver.findElement(By.name("address_input")).click();
//		new Actions(driver).pause(1000);
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("현재 위치로 설정합니다.")).click();
		Thread.sleep(2000);
//		System.out.println(driver.getPageSource());
		WebElement clsContent = driver.findElement(By.id("content")).findElements(By.cssSelector(".content > div")).get(3);
		List<WebElement> infos = clsContent.findElements(By.cssSelector(".restaurant-list > div table .restaurants-info"));
		for(WebElement el : infos) {
			System.out.println(el.getText());
		}
		System.out.println(infos.size());
	}
	
	public static void main(String[] args) throws Exception {
		new SeleniumTest().crawl();
	}
}
