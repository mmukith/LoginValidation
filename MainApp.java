package mainp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import miscutil.DiffOtherFunc;
import miscutil.Prop;
import pagelib.LoginPage;
import testBase.TestBaseSetup;

public class MainApp {
	
	//static WebDriver driver;
	public static void main(String[] args) throws IOException {
	
		TestBaseSetup invkbrowser = new TestBaseSetup();
		Prop pr = new Prop();
		DiffOtherFunc df = new DiffOtherFunc();
		LoginPage lp= new LoginPage();
		
String allprop=pr.readprop();
System.out.println("allprop=" + allprop);
	     
	     
 String browsr=allprop.split(",")[0];
 String url=allprop.split(",")[1];
 String expTitle=allprop.split(",")[2];

 invkbrowser.setDriver(browsr, url);
	     
  String Acttitle=invkbrowser.getDriver().getTitle();
  System.out.println(Acttitle);
	     
  boolean res=false;
  res=df.compareString(Acttitle, expTitle);
   if (res)
      System.out.println("Actual Title " + Acttitle + " is equal " + expTitle);
  else
    {
       System.out.println("Actual Title " + Acttitle + " is NOT EQUAL " + expTitle);
       //System.exit(1);
       invkbrowser.getDriver().quit();
    }
	     
   String username = "jhon";
   String password = "jh123";
   
lp.enterUserInfo(username, password);
lp.clickOnSubmit();



 
	     
	     
	     
		
	}
	


}
