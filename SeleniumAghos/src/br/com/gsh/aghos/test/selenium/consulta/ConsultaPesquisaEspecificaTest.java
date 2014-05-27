package br.com.gsh.aghos.test.selenium.consulta;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class ConsultaPesquisaEspecificaTest extends SeleniumTest {
	
	@Test
	public void consultaPesquisaEspecificaTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			testConsultaPesquisaEspecifica();
		} else {
			testConsultaPesquisaEspecificaChrome();
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

	public void testConsultaPesquisaEspecifica() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/atendimento/");
		driver.findElement(By.cssSelector("#consultarUnidade > span.add-on > span.icon-white.icon-search")).click();
	    driver.findElement(By.id("nome")).clear();
	    driver.findElement(By.id("nome")).sendKeys("santa casa de misericordia de cuiaba teste");
	    driver.findElement(By.id("btnPesquisarUnidade")).click();
	    driver.findElement(By.xpath("//tbody[@id='resultadosUnidadeDeSaude']/tr/td[3]")).click();
	    new Select(driver.findElement(By.id("prioridades"))).selectByVisibleText("Normal");
	    new Select(driver.findElement(By.id("tipoConsulta"))).selectByVisibleText("RETORNO");
	    new Select(driver.findElement(By.id("estados"))).selectByVisibleText("CANCELADO");
	    driver.findElement(By.cssSelector("#consultarSubEspecialidade > span.add-on > span.icon-white.icon-search")).click();
	    driver.findElement(By.id("nomeSubEspecialidade")).clear();
	    driver.findElement(By.id("nomeSubEspecialidade")).sendKeys("acidentes");
	    driver.findElement(By.xpath("//tbody[@id='resultadosSubEspecialidade']/tr/td[2]")).click();
	    //driver.findElement(By.name("selectSubEspecialidade")).toString("148:ACIDENTES").click();//148:ACIDENTES   selectSubEspecialidade
	    
	    driver.findElement(By.xpath("//form[@id='formPesquisa']/fieldset/div[12]/div[2]/div/div/span/span")).click();
	    
	    driver.findElement(By.id("buscar")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Ações')])[2]")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Visualizar')])[2]")).click();
	    driver.findElement(By.linkText("Voltar")).click();
		
		
//		driver.findElement(By.id("buscar")).click();
//		driver.findElement(By.linkText("6")).click();
//		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
//		driver.findElement(By.xpath("(//a[contains(text(),'Ações')])[3]")).click();
//	    driver.findElement(By.xpath("(//a[contains(text(),'Cupom\n				Solicitação')])[3]")).click();
//	    Thread.sleep(SeleniumConfig.TIMER_SLEEP + 3000);
//	    driver.findElement(By.cssSelector("#relatorioModal > div.modal-header > button.close")).click();
//	    Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		
	}
	
//	public void testAdicionaUpsIndicacaoConsulta() throws Exception {
//	    driver.findElement(By.linkText("5")).click();
//	    driver.findElement(By.linkText("Ações")).click();
//	    driver.findElement(By.linkText("UPS Indicação Consulta")).click();
//	    driver.findElement(By.cssSelector("span.icon-white.icon-search")).click();
//	    driver.findElement(By.id("btnPesquisarUnidade")).click();
//	    driver.findElement(By.xpath("(//input[@name='selectUnidadeDeSaude'])[11]")).click();
//	    driver.findElement(By.name("nome")).click();
//	    assertTrue(isElementPresent(By.className("success")));
//	    driver.findElement(By.linkText("Cancelar")).click();
//	    Thread.sleep(SeleniumConfig.TIMER_SLEEP + 6000);
//	}
	
	// Elaborar testes para Chrome
	public void testConsultaPesquisaEspecificaChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
