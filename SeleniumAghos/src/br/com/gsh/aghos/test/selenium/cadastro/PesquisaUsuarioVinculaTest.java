package br.com.gsh.aghos.test.selenium.cadastro;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class PesquisaUsuarioVinculaTest extends SeleniumTest {

	@Test
	public void cadastroPesquisaUsuarioTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			testCadastroPesquisaUsuario();
		} else {
			testCadastroPesquisaUsuarioChrome();
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

	public void testCadastroPesquisaUsuario() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/usuario/");
		driver.findElement(By.id("buscar")).click();
	    driver.findElement(By.xpath("//div[@id='resultados']/table/tbody/tr[5]/td[5]/div/a/span")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Vincular')])[5]")).click();
	    driver.findElement(By.name("usuario.grupoUsuarios[].id")).click();
	    driver.findElement(By.xpath("(//input[@name='usuario.grupoUsuarios[].id'])[3]")).click();
	    driver.findElement(By.id("botaoSalvar")).click();
		assertTrue(isElementPresent(By.className("success")));
	}
	
	public void testCadastroPesquisaUsuarioChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
