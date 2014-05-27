package br.com.gsh.aghos.test.selenium.cadastro;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class RegistraObitoTest extends SeleniumTest {

	@Test
	public void registraObitoTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			testRegistraObito();
		} else {
			testRegistraObitoChrome();
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

	public void testRegistraObito() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/infoObito/obito/");
		driver.findElement(By.cssSelector("#consultarPessoa > span.add-on > span.icon-white.icon-search")).click();
	    driver.findElement(By.id("btnPesquisarPessoa")).click();
	    driver.findElement(By.xpath("(//input[@name='selectPessoa'])[8]")).click();
	    driver.findElement(By.cssSelector("#consultarUnidade > span.add-on > span.icon-white.icon-search")).click();
	    driver.findElement(By.id("btnPesquisarUnidade")).click();
	    driver.findElement(By.xpath("(//input[@name='selectUnidadeDeSaude'])[14]")).click();
	    driver.findElement(By.cssSelector("#consultarCid > span.add-on > span.icon-white.icon-search")).click();
	    driver.findElement(By.id("btnPesquisarCid")).click();
	    driver.findElement(By.xpath("(//input[@name='selectCid'])[11]")).click();
	    driver.findElement(By.id("dataFalecimento")).clear();
		driver.findElement(By.id("dataFalecimento")).sendKeys("260520141310");
		driver.findElement(By.className("ui-datepicker-close")).click();
	    driver.findElement(By.id("btConfirmarObito")).click();	
	}
	
	public void testRegistraObitoChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
