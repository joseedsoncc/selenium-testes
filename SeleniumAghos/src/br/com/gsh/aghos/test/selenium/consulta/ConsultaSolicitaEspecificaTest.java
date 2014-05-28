package br.com.gsh.aghos.test.selenium.consulta;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class ConsultaSolicitaEspecificaTest extends SeleniumTest {
	
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
		driver.get(SeleniumConfig.SERVER + "/atendimento/solicitar");
		driver.findElement(By.cssSelector("#consultarUnidade > span.add-on > span.icon-white.icon-search")).click();
	    driver.findElement(By.id("nome")).clear();
	    driver.findElement(By.id("nome")).sendKeys("centro municipal de saude de agua boa");
	    driver.findElement(By.id("btnPesquisarUnidade")).click();
	    driver.findElement(By.xpath("//tbody[@id='resultadosUnidadeDeSaude']/tr/td[3]")).click();
	    driver.findElement(By.cssSelector("#consultarProntuario > span.add-on > span.icon-white.icon-search")).click();
	    driver.findElement(By.id("pessoaNome")).clear();
	    driver.findElement(By.id("pessoaNome")).sendKeys("romeu dendena");
	    driver.findElement(By.id("btnPesquisarProntuario")).click();
	    driver.findElement(By.xpath("//tbody[@id='resultadosProntuario']/tr/td[2]")).click();
	    new Select(driver.findElement(By.id("tipoConsulta"))).selectByVisibleText("INICIAL");
	    new Select(driver.findElement(By.id("atendimento.origemDaDemanda.id"))).selectByVisibleText("MINISTERIO PUBLICO");
	    driver.findElement(By.cssSelector("#consultarProfissional > span.add-on > span.icon-white.icon-search")).click();
	    driver.findElement(By.cssSelector("#btnPesquisarProfissional > span.icon-white.icon-search")).click();
	    driver.findElement(By.id("nomeProfissional")).clear();
	    driver.findElement(By.id("nomeProfissional")).sendKeys("mauricio de siqueira");

	    
	    
//	    driver.findElement(By.cssSelector("#consultarSubEspecialidade > span.add-on > span.icon-white.icon-search")).click();
//	    driver.findElement(By.cssSelector("#btnSubEspecialidade > span.add-on > span.icon-white.icon-search")).click();
//	    driver.findElement(By.xpath("//tbody[@id='resultadosSubEspecialidade']/tr[4]/td[3]")).click();
//	    driver.findElement(By.name("nome")).click();
//	    new Select(driver.findElement(By.id("prioridade"))).selectByVisibleText("Emergência");
//	    driver.findElement(By.cssSelector("div.form-actions > input[name=\"nome\"]")).click();
//	    driver.findElement(By.cssSelector("#consultarCid > span.add-on > span.icon-white.icon-search")).click();
//	    driver.findElement(By.cssSelector("#btnPesquisarCid > span.icon-white.icon-search")).click();
//	    driver.findElement(By.xpath("//tbody[@id='resultadosCid']/tr[10]/td[3]")).click();
//	    driver.findElement(By.cssSelector("div.form-actions > input[name=\"nome\"]")).click();
//	    driver.findElement(By.linkText("Demanda Judicial")).click();
//	    driver.findElement(By.linkText("Demanda Judicial")).click();
//	    driver.findElement(By.linkText("Reabilitação")).click();
//	    driver.findElement(By.linkText("Reabilitação")).click();
//	    driver.findElement(By.linkText("Queixa Principal")).click();
//	    driver.findElement(By.linkText("Queixa Principal")).click();
//	    driver.findElement(By.linkText("Reabilitação")).click();
//	    driver.findElement(By.linkText("Demanda Judicial")).click();
//	    driver.findElement(By.linkText("Queixa Principal")).click();
//	    driver.findElement(By.linkText("Histórico Fisiológica")).click();
//	    driver.findElement(By.linkText("Histórico Fisiológica")).click();
//	    driver.findElement(By.linkText("Histórico Fisiológica")).click();
//	    driver.findElement(By.linkText("Doença Atual e Observação")).click();
//	    driver.findElement(By.linkText("Doença Atual e Observação")).click();
//	    driver.findElement(By.linkText("Doença Atual e Observação")).click();
//	    driver.findElement(By.linkText("Histórico Familiar e Social")).click();
//	    driver.findElement(By.linkText("Histórico Familiar e Social")).click();
//	    driver.findElement(By.linkText("Histórico Familiar e Social")).click();
//	    driver.findElement(By.linkText("Impedimento De Acesso ou Não Resolutividade")).click();
//	    driver.findElement(By.linkText("Impedimento De Acesso ou Não Resolutividade")).click();
//	    driver.findElement(By.linkText("Impedimento De Acesso ou Não Resolutividade")).click();
//	    driver.findElement(By.cssSelector("div.form-actions > input[name=\"nome\"]")).click();
//	    new Select(driver.findElement(By.id("selectClassificacao"))).selectByVisibleText("3 - PENDENTE FALTA DE INFORMAÇÕES");
//	    driver.findElement(By.id("uti")).click();
//	    driver.findElement(By.cssSelector("div.form-actions > input[name=\"nome\"]")).click();
//	    driver.findElement(By.id("limpar")).click();
//	    driver.findElement(By.xpath("(//a[contains(text(),'×')])[2]")).click();
//	    driver.findElement(By.id("limpar")).click();
	    
//	    Thread.sleep(SeleniumConfig.TIMER_SLEEP);
	}
	
	// Elaborar testes para Chrome
	public void testConsultaPesquisaEspecificaChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
