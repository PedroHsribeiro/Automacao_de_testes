package teste.senai;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteCursosSenai {

	private WebDriver driver;
	
	@Before
	public void ConfigurarTeste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4200/");
	}
	
	@Test
	public void TesteNavegabilidade() {
		
		driver.findElement(By.className("menuLogin")).click();
		
		try {
			
			driver.findElement(By.xpath("//*[@id=\"register-email\"]")).sendKeys("pedro.henrique@email.com");
			driver.findElement(By.xpath("//*[@id=\"register-password\"]")).sendKeys("senhadopedro");
			driver.findElement(By.xpath("//*[@id=\"register-cpf\"]")).sendKeys("Pedro");
			driver.findElement(By.xpath("//*[@id=\"register-cep\"]")).sendKeys("Silva");
			driver.findElement(By.className("button-account-register")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("login-email")).sendKeys("pedro.henrique@email.com");
			driver.findElement(By.id("login-password")).sendKeys("senhadopedro");
			driver.findElement(By.className("button-account-login")).click();
			
			
			Thread.sleep(3000);
			
			driver.findElement(By.className("logo-text")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	
		

	}
	
	//@After
	//public void Fechar() {
	//	driver.quit();
	//}
	
}
