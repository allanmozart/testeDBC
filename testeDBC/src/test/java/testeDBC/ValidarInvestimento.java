package testeDBC;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidarInvestimento {

	@Test
	public void validarInvestimento() {
		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open test page
		String url = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";
		driver.get(url);
		driver.manage().window().maximize();

		// Validate page is correct
		WebElement simuladorInvestimento = driver.findElement(By.xpath("/html/body/div[2]/div/h2"));

		String actualMessage = simuladorInvestimento.getText();
		String expectedMessage = "Simulador de Investimento - Poupança";

		Assert.assertEquals(actualMessage, expectedMessage);

		// value to apply
		WebElement valorAplicacao = driver.findElement(By.id("valorAplicar"));
		valorAplicacao.sendKeys("2000");

		// how much to apply per month
		WebElement valorPorMes = driver.findElement(By.id("valorInvestir"));
		valorPorMes.sendKeys("2000");

		// how much time for application (months)
		WebElement tempoInvestimento = driver.findElement(By.id("tempo"));
		tempoInvestimento.sendKeys("36");

		// simulate button
		WebElement botaoSimular = driver
				.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[1]/form/div[5]/ul/li[2]/button"));
		botaoSimular.click();

		// validate response
		WebElement resultadoSimulacao = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]"));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated((By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]"))));

		Assert.assertEquals(true, resultadoSimulacao.isDisplayed());

		driver.quit();
	}

	@Test
	public void validarInvestimentoMinimo() {
		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open test page
		String url = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";
		driver.get(url);
		driver.manage().window().maximize();

		// Validate page is correct
		WebElement simuladorInvestimento = driver.findElement(By.xpath("/html/body/div[2]/div/h2"));
		String actualMessage = simuladorInvestimento.getText();
		String expectedMessage = "Simulador de Investimento - Poupança";
		Assert.assertEquals(actualMessage, expectedMessage);

		// Valor para aplicar
		WebElement valorAplicacao = driver.findElement(By.id("valorAplicar"));
		valorAplicacao.sendKeys("1999");
		valorAplicacao.sendKeys(Keys.ENTER);

		// Validar mensagem de erro - Mensagem Aplicação
		WebElement valorMinimoAplicar = driver.findElement(By.id("valorAplicar-error"));
		String actualErrorMessage = valorMinimoAplicar.getText();
		String expectedErrorMessage = "Valor mínimo de 20.00";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

		// Valor para poupar
		WebElement valorPorMes = driver.findElement(By.id("valorInvestir"));
		valorPorMes.sendKeys("1999");
		valorAplicacao.sendKeys(Keys.ENTER);

		// Validar mensagem de erro - Mensagem Poupar
		WebElement valorMinimoPoupar = driver.findElement(By.id("valorInvestir-error"));
		String actualPouparErrorMessage = valorMinimoPoupar.getText();
		String expectedPouparErrorMessage = "Valor mínimo de 20.00";
		Assert.assertEquals(actualPouparErrorMessage, expectedPouparErrorMessage);

		/*
		// Tempo investimento
		WebElement tempoInvestimento = driver.findElement(By.id("tempo"));
		tempoInvestimento.sendKeys("12");

		// Validar Botão Simular
		WebElement botaoSimular = driver
				.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[1]/form/div[5]/ul/li[2]/button"));
		botaoSimular.click();
		
		//Adicionar If/Else para validação do botão Simular
		 * 
		 */
		
		driver.quit();
	}

}
