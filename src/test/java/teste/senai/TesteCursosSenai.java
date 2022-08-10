package teste.senai;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		
		WebElement campoEmail = driver.findElement(By.id("login-email"));
		WebElement campoSenha = driver.findElement(By.id("login-password"));
		WebElement botao = driver.findElement(By.className("button-account-login"));
		
		String[] listaEmail = {"pedro.henrique@email.com", "pedro.teste@teste.com", "pedro.teste@email.com"};
		String[] listaSenha = {"senhadopedro", "senhadopedro", "senhadopedro"};
		try {
			
			for (int contador = 0; contador < 3; contador++) {
				campoEmail.sendKeys(listaEmail[contador]);
				campoSenha.sendKeys(listaSenha[contador]);
				botao.click();
				
				Thread.sleep(3000);
				
				campoEmail.clear();
				campoSenha.clear();

			}
		
			driver.findElement(By.className("logo-text")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void Fechar() {
		driver.quit();
	}
	
}
