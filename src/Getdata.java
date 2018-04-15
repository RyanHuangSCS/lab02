

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
/**
 * 一个Excel文件的层次：Excel文件->工作表->行->单元格
 * 对应到POI中，为：workbook->sheet->row->cell
 */
public class Getdata
{
public static String fileToBeRead = "C:\\Users\\37125\\Downloads\\input.xlsx";
    
 
    public String[][] readExcel()
    {
        String[] urls=new String[97*2];

        try
        {
        	int i=0;
            // 创建对Excel工作簿文件的引用
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileToBeRead));
            //System.out
            //  .println("===SheetsNum===" + workbook.getNumberOfSheets());//获取sheet数
            for(int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++)
            {
                if(null != workbook.getSheetAt(numSheets))
                {
                    XSSFSheet aSheet = workbook.getSheetAt(numSheets); //获得一个sheet
 
                    for(int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++)
                    {
                        if(null != aSheet.getRow(rowNumOfSheet))
                        {
                            XSSFRow aRow = aSheet.getRow(rowNumOfSheet);
 
                            for(short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++)
                            {
 
                                if(null != aRow.getCell(cellNumOfRow))
                                {
                                    XSSFCell aCell = aRow.getCell(cellNumOfRow);
                                   aCell.setCellType(aCell.CELL_TYPE_STRING);
//                                    System.out.println(aCell.getStringCellValue());
                                   urls[i]=aCell.getStringCellValue().toString();
                                   i++;
 
                                }
 
                            }
                        }
 
                    }
 
                }
 
            }
 
        }
        catch(Exception e)
        {
            System.out.println("ReadExcelError" + e);
        }
        String[][] a=new String[97][3];
        String[] acs=new String[97];
		  String[] pws=new String[97];
		  String[] exs=new String[97];
		  int i1=0,i2=0;
		  for(int i=0;i<97*2;i++)
		  {
			  if(i%2==0)
			  {
				  acs[i1]=urls[i];
				  pws[i1]=urls[i].substring(4, 10);
				  i1++;
			  }
			  else
			  {
				  exs[i2]=urls[i];
				  i2++;
			  }
		  }
		for(int i=0;i<97;i++)
		{
			a[i][0]=acs[i];
			a[i][1]=pws[i];
			a[i][2]=exs[i];
		}
		  System.out.println(a);
		return a;
 
    }
 
  
}
 