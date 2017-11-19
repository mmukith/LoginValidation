package pagelib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testBase.TestBaseSetup;

public class LoginPage extends TestBaseSetup{
	
	
	
	By username = By.name("username");
	By password = By.name("password");
	By submit = By.name("bt");

	public void enterUserInfo(String username,String password){
	driver.findElement(this.username).sendKeys(username);
	driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickOnSubmit(){
	driver.findElement(submit).click();		}
		

	
}
