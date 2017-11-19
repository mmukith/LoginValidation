package mainp;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import dbUtil.OracleUtil;

import fileutil.ReadFile;
import miscutil.DiffOtherFunc;
import miscutil.Prop;

public class MainTest {
 
 // private static String setProperty;

public static void main(String[] args) throws IOException, ClassNotFoundException {
   
   
 // =============================================================================
    //               1.    Read Properties file 
 //
 //        Get URL
 //        Get Expected Title 
 //        Get Input File Name which contains the Data to populate 
 //        Get expectedH1 
 // =============================================================================
   
   
   
     Prop pr = new Prop();
     String allprop=pr.readprop();
     System.out.println("allprop=" + allprop);
   
   
     String url=allprop.split(",")[0];
     String expTitle=allprop.split(",")[1];
     String filename=allprop.split(",")[2];
     String expH1=allprop.split(",")[3];
     
     System.out.println("=========================================================");
     System.out.println("Step1==> Get all the Properties ");
     System.out.println("=========================================================");
     
     
     System.out.println("url=" + url);
     System.out.println("expTitle=" + expTitle);
     System.out.println("filename=" + filename);
   
     
     //System.out.println("expH1=" + expH1);
     // =============================================================================
     //               2.    get the Data from the Input file to populate 
     // ==============================================================================
     
        ReadFile rf = new ReadFile();
       
        String rec = rf.readrec(filename);
        
        
        String vcustno=rec.split(",")[0];
        String vcustnm=rec.split(",")[1];
        String vcustpayamt=rec.split(",")[2];
        String vcustjndt=rec.split(",")[3];
        //String vcustjoindt=rec.split(",")[2];
        //String vcustemail=rec.split(",")[3];
        
        System.out.println("=========================================================");
        System.out.println("Step2==> Get the input data ");
        System.out.println("=========================================================");
     
        System.out.println("vcustno=" + vcustno);
        System.out.println("vcustnm=" + vcustnm);
        System.out.println("vcustpayamt=" + vcustpayamt);
        System.out.println("vcustjndt=" + vcustjndt);

        

        // =============================================================================
        //               3.    Call the URL  
      //                    Verify the Title
      //       
        //                   if not match then exit from the test 
      //=============================================================================
        // System.setProperty("webdriver.chrome.driver","C:\\2017sep\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\2017sep\\chromedriver.exe");
         
      // WebDriver driver=new InternetExplorerDriver(); 
       //System.setProperty("webdriver.ie.driver", "C:\\2017sep\\IEDriverServer.exe");
        WebDriver driver =new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","C:\\2017sep\\chromedriver.exe");
    // WebDriver driver= new FirefoxDriver();

       driver.get(url);
       
       String Acttitle=driver.getTitle();
        DiffOtherFunc df = new DiffOtherFunc();
       //String Acttitle1="xxx";
        
        boolean res=false;
        res=df.compareString(Acttitle, expTitle);
        
            System.out.println("=========================================================");
         System.out.println("Step3==> verify proper screen is displayed ");
         System.out.println("=========================================================");
     
        
        
         if (res)
            System.out.println("Actual Title " + Acttitle + " is equal " + expTitle);
        else
          {
             System.out.println("Actual Title " + Acttitle + " is NOT EQUAL " + expTitle);
             System.exit(1);
          
              
          }
         // =============================================================================
         //               4.    Verify H1 element 
      // =============================================================================
         
      System.out.println("=========================================================");
      System.out.println("Step4==> done by Muhit ");
      System.out.println("=========================================================");
     
         
     String actualH1 = driver.findElement(By.tagName("h1")).getText();
     System.out.println("Actual H1 Element: "+actualH1);
     boolean resh1 = false;
     resh1 = df.compareString(actualH1,expH1);
     
     if(resh1){
         System.out.println("Actual h1 " + actualH1 + " is equal " + expH1);
     } else
       {
          System.out.println("Actual h1 " + actualH1 + " is not equal " + expH1);
          System.exit(1);
       }
         // =============================================================================
         //               5.    populate the Screen
      //                     click on add
      //        
         //                   
      // =============================================================================

            
             driver.findElement(By.name("custno")).sendKeys(vcustno);
             driver.findElement(By.name("custnm")).sendKeys(vcustnm);
             driver.findElement(By.name("payamt")).sendKeys(vcustpayamt);
             driver.findElement(By.name("jndt")).sendKeys(vcustjndt);
             //driver.findElement(By.id("subbtn")).click();

             
          System.out.println("=========================================================");
          System.out.println("Step5==> populate the screen ");
          System.out.println("=========================================================");

         

//     000
          // =============================================================================
          //               6.    Verify the Database
          //                     
          //                   
          // =============================================================================        
             
             
             String sql="select * from cust where custno='" + vcustno + "'";
             OracleUtil orut = new OracleUtil();
             
             rec=orut.getdb(sql);
             
             System.out.println("from database==> " +  rec);
             
             String dcustno=rec.split(",")[0];
             String dcustnm=rec.split(",")[1];
             String dcustpayamt=rec.split(",")[2];
             String dcustjndt=rec.split(",")[3];  
              
              
             // System.out.println("Dcustno=" + dcustno);
             // System.out.println("dcustnm=" + dcustnm);
             // System.out.println("dcustpayamt=" + dcustpayamt);
             // System.out.println("dcustjndt=" + dcustjndt);

             // =============================================================================
             //                   Compare input value with the Database Value
          // =============================================================================
             System.out.println("=========================================================");
           System.out.println("Ste6==> verify database  ");
           System.out.println("=========================================================");
       
            if (df.compareString(dcustno,vcustno))  
                  System.out.println("Custno is Matching with the Database Data");
              else 
                  System.out.println("Expected Value=" + vcustno  + " actual Value=" + dcustno);

             
          
}
}
      
