package br.com.gsh.aghos.test.selenium.login;

import static org.junit.Assert.assertTrue;

import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.gsh.aghos.test.selenium.config.SeleniumConfig;
import br.com.gsh.aghos.test.selenium.config.SeleniumTest;

public class LoginErrorTest extends SeleniumTest{

	@Test
	public void testLoginError() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/login");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("GSH6");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("GSH3");
		driver.findElement(By.xpath("//input[@value='LOGAR']")).click();
		assertTrue(isElementPresent(By.className("alert-error")));
	}

	@Test
	public void testLoginOk() throws Exception {
		driver.get(SeleniumConfig.SERVER + "/login");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("GSH6");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("GSH");
		driver.findElement(By.xpath("//input[@value='LOGAR']")).click();
		assertTrue(isElementPresent(By.id("Menu")));
	}
	
}
