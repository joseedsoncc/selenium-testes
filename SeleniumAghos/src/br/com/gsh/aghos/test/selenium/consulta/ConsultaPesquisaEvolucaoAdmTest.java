package br.com.gsh.aghos.test.selenium.consulta;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class ConsultaPesquisaEvolucaoAdmTest extends SeleniumTest {

	@Ignore
	@Test
	public void consultaPesquisaEvolucaoAdmTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			testConsultaPesquisaEvolucaoAdm();
		} else {
			testConsultaPesquisaEvolucaoAdmChrome();
		}
		efetuaLogoutDoAghos();
	}

	private void login() {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("GSH8");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("GSH");
		driver.findElement(By.xpath("//input[@value='LOGAR']")).click();
	}

	public void testConsultaPesquisaEvolucaoAdm() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/atendimento/");	
		driver.findElement(By.id("buscar")).click();
	    driver.findElement(By.linkText("Ações")).click();
	    driver.findElement(By.linkText("Evolução Administrativa")).click();
	    driver.get(SeleniumConfig.SERVER + "/atendimento/431461/evolucaoAdministrativa/");
	    driver.findElement(By.linkText("Ações")).click();
	    driver.findElement(By.linkText("Marcar como lida")).click();
	    assertTrue(isElementPresent(By.className("success")));
	    Thread.sleep(SeleniumConfig.TIMER_SLEEP + 6000);
	    driver.findElement(By.linkText("Ações")).click();
	    driver.findElement(By.linkText("Remover")).click();
	}
	
	// Elaborar testes para Chrome
	public void testConsultaPesquisaEvolucaoAdmChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

	@After
	public void tearDown() throws Exception {
		// volta o banco id="431461" para "marca como lida"
		super.tearDown();
	}
	
}
