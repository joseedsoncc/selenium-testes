package br.com.gsh.aghos.test.selenium.prontuarioEletronico;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class ProntuarioEletronicoCadastroAlteradoTest extends SeleniumTest {

	@Test
	public void prontuarioEletronicoCadAlteradoTest() throws Exception {
		login();
		if (SeleniumConfig.isFirefox()) {
			testProntuarioEletronicoCadastroAlterado();
		} else {
			testProntuarioEletronicoCadastroAlteradoChrome();
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

	public void testProntuarioEletronicoCadastroAlterado() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/prontuario/");
	    new Select(driver.findElement(By.id("selectSexo"))).selectByVisibleText("Feminino");
	    driver.findElement(By.id("buscar")).click();
	    Thread.sleep(SeleniumConfig.TIMER_SLEEP);
	    driver.findElement(By.xpath("(//a[contains(text(),'Ações')])[7]")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Editar')])[8]")).click();
	    driver.findElement(By.id("prontuario_codigo")).clear();
	    driver.findElement(By.id("prontuario_codigo")).sendKeys("77778888");
	    driver.findElement(By.name("_method")).click();
	    driver.findElement(By.id("btLimparProntuario")).click();
		assertTrue(isElementPresent(By.className("success")));
	}
	
	public void testProntuarioEletronicoCadastroAlteradoChrome() {
		// sem teste para chrome!!
	}

	private void efetuaLogoutDoAghos() throws Exception {
		driver.findElement(By.xpath("//div[@id='menuUsuarios']/button[2]")).click();
		driver.findElement(By.linkText("Sair do Sistema")).click();
	}

}
