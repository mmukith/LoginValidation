package dbUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleUtil {
	public static String getdb(String sql){

		String rec="";

		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Statement st=null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		Connection cn = DriverManager.getConnection( url, "muhit", "muhit" );
		System.out.println("connection worked");

		//=============================================================

		st = cn.createStatement();

		rs = st.executeQuery(sql );

		//String queryStringuser="";

		//SimpleDateFormat sdfDestination=null;

		//int count=0;

		//String strcolor = "";
		//String sql="select * from cust where custno=0";
		while(rs.next()){
		rec=rs.getString(1) + "," + rs.getString(2)+ "," + rs.getString(3)+ "," + rs.getString(4) ;
		//System.out.println("orautil:"+rec);

		}

		cn.close();

		}

		catch (Exception e)

		{

		e.printStackTrace();

		}

		return rec;

		}
}
