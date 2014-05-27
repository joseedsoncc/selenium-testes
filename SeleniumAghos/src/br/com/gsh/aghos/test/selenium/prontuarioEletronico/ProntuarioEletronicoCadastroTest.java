package br.com.gsh.aghos.test.selenium.prontuarioEletronico;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class ProntuarioEletronicoCadastroTest extends SeleniumTest {

	@Ignore
	@Test
	public void prontuarioEletronicoCadTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			testProntuarioEletronicoCadastro();
		} else {
			testProntuarioEletronicoCadastroChrome();
		}
		efetuaLogoutDoAghos();
	}

	private void login() {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("GSH6");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("GSH");
		driver.findElement(By.xpath("//input[@value='LOGAR']")).click();
	}

	public void testProntuarioEletronicoCadastro() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/prontuario/cadastro");
		driver.findElement(By.cssSelector("#consultarUnidade > span.add-on > span.icon-white.icon-search")).click();
		driver.findElement(By.id("btnPesquisarUnidade")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.xpath("(//input[@name='selectUnidadeDeSaude'])[12]")).click();
		driver.findElement(By.id("prontuario_codigo")).clear();
		driver.findElement(By.id("prontuario_codigo")).sendKeys("157");
		driver.findElement(By.cssSelector("span.icon-white.icon-calendar")).click();
		driver.findElement(By.linkText("14")).click();
		driver.findElement(By.id("prontuario_anterior")).clear();
		driver.findElement(By.id("prontuario_anterior")).sendKeys("156");
		driver.findElement(By.cssSelector("#consultarPessoa > span.add-on > span.icon-white.icon-search")).click();
		driver.findElement(By.id("btnPesquisarPessoa")).click();
		driver.findElement(By.xpath("(//input[@name='selectPessoa'])[24]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertTrue(isElementPresent(By.className("success")));
	}
	
	// Elaborar testes para Chrome
	public void testProntuarioEletronicoCadastroChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
