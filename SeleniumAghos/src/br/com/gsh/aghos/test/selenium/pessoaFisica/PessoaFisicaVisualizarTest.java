package br.com.gsh.aghos.test.selenium.pessoaFisica;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class PessoaFisicaVisualizarTest extends SeleniumTest{
	
	@Test
	public void pessoaFisicaTest() throws Exception {
		login();
		visualizarPessoaFisica();
		efetuaLogoutDoAghos();
	}

	private void login() {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("GSH6");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("GSH");
		driver.findElement(By.xpath("//input[@value='LOGAR']")).click();
	}

	private void visualizarPessoaFisica() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/pessoa/visualizar/2"); 		
		assertTrue(isElementPresent(By.id("visualizacaoPessoaFisica")));
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
