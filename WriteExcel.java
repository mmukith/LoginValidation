package excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class WriteExcel {

    public static void main(String[] args) {
    
    	String flnm = "C:\\test\\P1.xls";
    	String sheet = "Report";
    	WriteExcel wex= new WriteExcel();
    	String rc = "Mukith"+","+"Liton";
    	wex.writExcel(flnm,sheet,rc);
    }
    
	String rc1 ="";
    
    public static String writExcel(String filnm, String sheet,String rc1){
    	//rc1=rc1;
    	//String rc1 ="";
    	try {
            //create .xls and create a worksheet.
    FileOutputStream fos = new FileOutputStream(filnm);
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet worksheet = workbook.createSheet(sheet);


    //Create ROW-1
    HSSFRow row1 = worksheet.createRow((short) 0);

   //Create COL-A from ROW-1 and set data
   HSSFCell cellA1 = row1.createCell((short) 0);
   
   cellA1.setCellValue(rc1);
   HSSFCellStyle cellStyle = workbook.createCellStyle();
  cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
  cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
  cellA1.setCellStyle(cellStyle);
//Create COL-B from row-1 and set data
  /*HSSFCell cellB1 = row1.createCell((short) 1);
  cellB1.setCellValue(rc2);
            cellStyle = workbook.createCellStyle();
            cellStyle.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            cellB1.setCellStyle(cellStyle);

            //Create COL-C from row-1 and set data
            HSSFCell cellC1 = row1.createCell((short) 2);
            cellC1.setCellValue(true);

            //Create COL-D from row-1 and set data
            HSSFCell cellD1 = row1.createCell((short) 3);
            cellD1.setCellValue(new Date());
            cellStyle = workbook.createCellStyle();
            cellStyle.setDataFormat(HSSFDataFormat
                    .getBuiltinFormat("m/d/yy h:mm"));
            cellD1.setCellStyle(cellStyle);
*/
            //Save the workbook in .xls file
            workbook.write(fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return rc1;

    }

}