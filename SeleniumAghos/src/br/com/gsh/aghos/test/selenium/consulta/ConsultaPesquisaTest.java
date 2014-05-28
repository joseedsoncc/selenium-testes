package br.com.gsh.aghos.test.selenium.consulta;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class ConsultaPesquisaTest extends SeleniumTest {

	@Test
	public void consultaPesquisaTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			testConsultaCupomSolicitacao();
			testAdicionaUpsIndicacaoConsulta();
		} else {
			testConsultaCupomSolicitacaoChrome();
			testAdicionaUpsIndicacaoConsultaChrome();
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

	public void testConsultaCupomSolicitacao() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/atendimento/");
		driver.findElement(By.id("buscar")).click();
		driver.findElement(By.linkText("6")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.xpath("(//a[contains(text(),'Ações')])[3]")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Cupom\n				Solicitação')])[3]")).click();
	    Thread.sleep(SeleniumConfig.TIMER_SLEEP + 3000);
	    driver.findElement(By.cssSelector("#relatorioModal > div.modal-header > button.close")).click();
	    Thread.sleep(SeleniumConfig.TIMER_SLEEP);
	}
	
	public void testAdicionaUpsIndicacaoConsulta() throws Exception {
	    driver.findElement(By.linkText("2")).click();
	    driver.findElement(By.linkText("Ações")).click();
	    driver.findElement(By.linkText("UPS Indicação Consulta")).click();
	    driver.findElement(By.cssSelector("span.icon-white.icon-search")).click();
	    driver.findElement(By.id("btnPesquisarUnidade")).click();
	    driver.findElement(By.xpath("(//input[@name='selectUnidadeDeSaude'])[11]")).click();
	    driver.findElement(By.name("nome")).click();
	    assertTrue(isElementPresent(By.className("success")));
	    driver.findElement(By.linkText("Cancelar")).click();
	    Thread.sleep(SeleniumConfig.TIMER_SLEEP + 6000);
	}
	
	// Elaborar testes para Chrome
	public void testConsultaCupomSolicitacaoChrome() {
		// sem teste para chrome!!
	}
	
	public void testAdicionaUpsIndicacaoConsultaChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
