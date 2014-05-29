package br.com.gsh.aghos.test.selenium.pessoaFisica;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class PessoaFisicaCadastroTest extends SeleniumTest{
	
	@Test
	public void pessoaFisicaTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			cadastroPessoaFisica();
		} else {
			cadastroPessoaFisicaChrome();
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

	private void cadastroPessoaFisica() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/pessoa/fisica/");
		driver.findElement(By.id("pessoa_nome")).clear();
		driver.findElement(By.id("pessoa_nome")).sendKeys("RYU KEN MASTER");
		driver.findElement(By.id("pessoa_apelido")).clear();
		driver.findElement(By.id("pessoa_apelido")).sendKeys("RYU KEN MASTER");
		driver.findElement(By.id("pessoa_nomeMae")).clear();
		driver.findElement(By.id("pessoa_nomeMae")).sendKeys("MAE DO RYU KEN MASTER");
		driver.findElement(By.name("pessoa.nomePai")).clear();
		driver.findElement(By.name("pessoa.nomePai")).sendKeys("PAI DO RYU KEN MASTER");
		driver.findElement(By.id("pessoa_nascimento")).clear();
		driver.findElement(By.id("pessoa_nascimento")).sendKeys("15101979");
		new Select(driver.findElement(By.id("pessoa_sexo"))).selectByVisibleText("Masculino");
		new Select(driver.findElement(By.name("pessoa.estadoCivil.id"))).selectByVisibleText("SOLTEIRO(A)");
		new Select(driver.findElement(By.id("selectRaca"))).selectByVisibleText("SEM INFORMAÇÃO");

		driver.findElement(By.linkText("Naturalidade")).click();
		driver.findElement(By.linkText("Naturalidade")).click();
		new Select(driver.findElement(By.id("ufNaturalidade"))).selectByVisibleText("CE");
		new Select(driver.findElement(By.id("municipioNaturalidade"))).selectByVisibleText("FORTALEZA");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		
		driver.findElement(By.linkText("Município de Trabalho")).click();
		driver.findElement(By.linkText("Município de Trabalho")).click();
		driver.findElement(By.cssSelector("#consultarMunicipioTrabalho > span.add-on.data > span.icon-white.icon-search")).click();
		driver.findElement(By.id("btnPesquisarMunicipioTrabalho")).click();
		driver.findElement(By.name("selectMunicipioTrabalho")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		
		driver.findElement(By.linkText("Nacionalidade")).click();
		driver.findElement(By.linkText("Nacionalidade")).click();
		new Select(driver.findElement(By.name("pessoa.nacionalidade.id"))).selectByVisibleText("BRASIL");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		
		driver.findElement(By.id("enderecoCollapse")).click();
		driver.findElement(By.id("enderecoCollapse")).click();
		driver.findElement(By.id("cep")).clear();
		driver.findElement(By.id("cep")).sendKeys("60540060");
		driver.findElement(By.id("cep")).getAttribute("value");
		driver.findElement(By.id("numeroResidencia")).clear();
		driver.findElement(By.id("numeroResidencia")).sendKeys("642");
		new Select(driver.findElement(By.name("pessoa.zona.id"))).selectByVisibleText("URBANA");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		
		driver.findElement(By.linkText("Ocupação")).click();
		driver.findElement(By.linkText("Ocupação")).click();
		driver.findElement(By.cssSelector("#consultarOcupacao > span.add-on.data > span.icon-white.icon-search")).click();
		driver.findElement(By.cssSelector("#btnPesquisarOcupacao > span.icon-white.icon-search")).click();
		driver.findElement(By.name("selectOcupacao")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);

		driver.findElement(By.linkText("Ocupação Auxiliar")).click();
		driver.findElement(By.linkText("Ocupação Auxiliar")).click();
		driver.findElement(By.cssSelector("#consultarOcupacaoAuxiliar > span.add-on.data > span.icon-white.icon-search")).click();
		driver.findElement(By.cssSelector("#btnPesquisarOcupacaoAuxiliar > span.icon-white.icon-search")).click();
		driver.findElement(By.xpath("//tbody[@id='resultadosOcupacaoAuxiliar']/tr/td[2]")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		
		driver.findElement(By.linkText("Responsáveis")).click();
		driver.findElement(By.linkText("Responsáveis")).click();
		driver.findElement(By.cssSelector("#consultarResponsavel1 > span.add-on.data > span.icon-white.icon-search")).click();
		driver.findElement(By.id("btnPesquisarPessoa")).click();
		driver.findElement(By.name("selectPessoa")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		
		driver.findElement(By.linkText("Domicílio")).click();
		driver.findElement(By.linkText("Domicílio")).click();
		new Select(driver.findElement(By.id("energia"))).selectByVisibleText("Sim");
		new Select(driver.findElement(By.id("tipoAbastecimentoAgua"))).selectByVisibleText("POÇO OU NASCENTE");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		
		driver.findElement(By.linkText("Telefones")).click();
		driver.findElement(By.linkText("Telefones")).click();
		new Select(driver.findElement(By.id("tipoDeTelefone"))).selectByVisibleText("RESIDENCIAL");

		driver.findElement(By.id("campoTelefone")).clear();
		driver.findElement(By.id("campoTelefone")).sendKeys("55555555555");
		driver.findElement(By.id("adicionarTelefone")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);

		driver.findElement(By.linkText("E-mails")).click();
		driver.findElement(By.linkText("E-mails")).click();
		driver.findElement(By.id("campoEmail")).clear();
		driver.findElement(By.id("campoEmail")).sendKeys("emaildoryu@streetfighter.com");
		driver.findElement(By.id("adicionarEmail")).click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		assertTrue(isElementPresent(By.id("mensagens")));
		assertTrue(isElementPresent(By.className("success")));
	}

	private void cadastroPessoaFisicaChrome() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/pessoa/fisica/");
		driver.findElement(By.id("pessoa_nome")).clear();
		driver.findElement(By.id("pessoa_nome")).sendKeys("RYU KEN MASTER");
		driver.findElement(By.id("pessoa_apelido")).clear();
		driver.findElement(By.id("pessoa_apelido")).sendKeys("RYU KEN MASTER");
		driver.findElement(By.id("pessoa_nomeMae")).clear();
		driver.findElement(By.id("pessoa_nomeMae")).sendKeys("MAE DO RYU KEN MASTER");
		driver.findElement(By.name("pessoa.nomePai")).clear();
		driver.findElement(By.name("pessoa.nomePai")).sendKeys("PAI DO RYU KEN MASTER");
		driver.findElement(By.id("pessoa_nascimento")).clear();
		driver.findElement(By.id("pessoa_nascimento")).sendKeys("15101979");
		new Select(driver.findElement(By.id("pessoa_sexo"))).selectByVisibleText("Masculino");
		new Select(driver.findElement(By.name("pessoa.estadoCivil.id"))).selectByVisibleText("SOLTEIRO(A)");
		new Select(driver.findElement(By.id("selectRaca"))).selectByVisibleText("SEM INFORMAÇÃO");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.linkText("Naturalidade")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		new Select(driver.findElement(By.id("ufNaturalidade"))).selectByVisibleText("CE");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		new Select(driver.findElement(By.id("municipioNaturalidade"))).selectByVisibleText("FORTALEZA");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.partialLinkText("Trabalho")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("consultarMunicipioTrabalho")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("btnPesquisarMunicipioTrabalho")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.name("selectMunicipioTrabalho")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.linkText("Nacionalidade")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		new Select(driver.findElement(By.name("pessoa.nacionalidade.id"))).selectByVisibleText("BRASIL");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("enderecoCollapse")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("cep")).clear();
		driver.findElement(By.id("cep")).sendKeys("60540060");
		driver.findElement(By.id("cep")).getAttribute("value");
		driver.findElement(By.id("numeroResidencia")).clear();
		driver.findElement(By.id("numeroResidencia")).sendKeys("642");
		new Select(driver.findElement(By.name("pessoa.zona.id"))).selectByVisibleText("URBANA");

		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.linkText("Ocupação")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.cssSelector("#consultarOcupacao > span.add-on.data > span.icon-white.icon-search")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.cssSelector("#btnPesquisarOcupacao > span.icon-white.icon-search")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.name("selectOcupacao")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.linkText("Ocupação Auxiliar")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.cssSelector("#consultarOcupacaoAuxiliar > span.add-on.data > span.icon-white.icon-search")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.cssSelector("#btnPesquisarOcupacaoAuxiliar > span.icon-white.icon-search")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.xpath("//tbody[@id='resultadosOcupacaoAuxiliar']/tr/td[2]")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.linkText("Responsáveis")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.cssSelector("#consultarResponsavel1 > span.add-on.data > span.icon-white.icon-search")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("btnPesquisarPessoa")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP + 600);
		driver.findElement(By.name("selectPessoa")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP + 600);
		driver.findElement(By.linkText("Domicílio")).click();
		new Select(driver.findElement(By.id("energia"))).selectByVisibleText("Sim");
		new Select(driver.findElement(By.id("tipoAbastecimentoAgua"))).selectByVisibleText("REDE PÚBLICA");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.linkText("Telefones")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		new Select(driver.findElement(By.id("tipoDeTelefone"))).selectByVisibleText("RESIDENCIAL");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("campoTelefone")).clear();
		driver.findElement(By.id("campoTelefone")).sendKeys("55555555555");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("adicionarTelefone")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.linkText("E-mails")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("campoEmail")).clear();
		driver.findElement(By.id("campoEmail")).sendKeys("emaildoryu@streetfighter.com");
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.id("adicionarEmail")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		assertTrue(isElementPresent(By.id("mensagens")));
		Thread.sleep(SeleniumConfig.TIMER_SLEEP);
		assertTrue(isElementPresent(By.className("success")));
	}
	
	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}
	
}
