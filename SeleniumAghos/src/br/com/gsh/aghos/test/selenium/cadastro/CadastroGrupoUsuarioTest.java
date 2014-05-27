package br.com.gsh.aghos.test.selenium.cadastro;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class CadastroGrupoUsuarioTest extends SeleniumTest {

	@Test
	public void cadastroGrupoUsuarioTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			testCadastroGrupoUsuario();
		} else {
			testCadastroGrupoUsuarioChrome();
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

	public void testCadastroGrupoUsuario() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/usuario/grupos/");
	    driver.findElement(By.linkText("Novo")).click();
	    driver.findElement(By.id("descricao")).clear();
	    driver.findElement(By.id("descricao")).sendKeys("Grupo teste aghos");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
		assertTrue(isElementPresent(By.className("success")));
	}
	
	public void testCadastroGrupoUsuarioChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
