package com.saucedemo.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest { 
	
	protected WebDriver driver;
	
	@BeforeEach
	public void abrirNavegador() {
		
		
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-features=PasswordManagerEnabled");
	    options.addArguments("--incognito"); 
		driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/"); 
	}
	
	@AfterEach
	public void fecharNavegador() {
		if (driver != null) { 
			driver.quit(); 
			
		}
	}
	
	 public void fazerLogin(String usuario, String senha) {
	        driver.findElement(By.id("user-name")).sendKeys(usuario);
	        driver.findElement(By.id("password")).sendKeys(senha);
	        driver.findElement(By.id("login-button")).click();
	    }
	
	public void tirarPrint(String nomeDaEvidencia) {
		 
        File pasta = new File("Evidencias");
        if (!pasta.exists()) {
            pasta.mkdirs(); 
        }		
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try { 
			Files.copy(  
					screenShot.toPath(),  
					new File("Evidencias/" + nomeDaEvidencia + ".png").toPath(), 
					StandardCopyOption.REPLACE_EXISTING 
					);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
