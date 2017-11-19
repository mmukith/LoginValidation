package miscutil;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Prop {
 public static  String readprop() throws IOException
   {
  Properties props = new Properties();
  FileInputStream in = new FileInputStream("C:\\eclipsinfosys\\ProjectLoginTest\\src\\property.properties");
  props.load(in);
 // ========================================================
//           Getting the Filename from the properties file 
 // ========================================================
  String url = props.getProperty("url");
     String expTitle = props.getProperty("expTitle");
    String browser = props.getProperty("browser");
   //  String expectedH1 =  props.getProperty("expectedH1");
     
 // ========================================================
     //String retrec=url + ","  + expTitle + "," + inpfilenm + "," + expectedH1;
  //System.out.println(retrec);
     String retrec=browser + ","  +url +","+ expTitle;
     
    in.close();
         return retrec;
   }
 }
