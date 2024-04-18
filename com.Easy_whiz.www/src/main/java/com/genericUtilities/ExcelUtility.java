package com.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	
	/**
	 * this method is used to fetch 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return value
	 * @throws Exception
	 */
   public String ReadSingleDatafromExcel(String sheetname, int rownum , int cellnum) throws Exception
   {
	   FileInputStream fis = new FileInputStream(IPathConstant.Excelpath);
	                   Workbook wb = WorkbookFactory.create(fis);
	                 Sheet sh = wb.getSheet(sheetname);
	                String value = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
	                wb.close();
	                return value;
	 }
     
   
   /**
    * this method will insert data into excel 
    * @param sheetname
    * @param rownum
    * @param cellnum
    * @param value
    * @throws Exception
    * @throws Exception
    */
   public void writeDataIntoExcel(String sheetname , int rownum , int cellnum , String value ) throws Exception, Exception
   {
	   FileInputStream fis = new FileInputStream(IPathConstant.Excelpath);
       Workbook wb = WorkbookFactory.create(fis);
       Sheet sh = wb.createSheet(sheetname);
                  sh.createRow(rownum).getCell(cellnum).setCellValue(value);
                  
                  FileOutputStream fout = new FileOutputStream(IPathConstant.Excelpath);
                  wb.write(fout);
                  wb.close();
        }
   
   
   public void writeDataIntoExcel(String sheetname , int rownum , int cellnum , int  value ) throws Exception, Exception
   {
	   FileInputStream fis = new FileInputStream(IPathConstant.Excelpath);
       Workbook wb = WorkbookFactory.create(fis);
       Sheet sh = wb.getSheet(sheetname);
                  sh.getRow(rownum).createCell(cellnum).setCellValue(value);
                  
                  FileOutputStream fout = new FileOutputStream(IPathConstant.Excelpath);
                  wb.write(fout);
                  wb.close();
        }
   public void writeDataSingleIntoExcel(String sheetname , int rownum , int cellnum , String value ) throws Exception, Exception
   {
	   FileInputStream fis = new FileInputStream(IPathConstant.Excelpath);
       Workbook wb = WorkbookFactory.create(fis);
       Sheet sh = wb.getSheet(sheetname);
                  sh.getRow(rownum).getCell(cellnum).setCellValue(value);
                  
                  FileOutputStream fout = new FileOutputStream(IPathConstant.Excelpath);
                  wb.write(fout);
                  wb.close();
        }
   
   
      /**
       * this method will fetch all the data (rows*cols) in the excel sheet
       * @param sheetname
       * @param rownum
       * @param cellnum
     * @return 
       * @return
       * @throws IOException
       */
   public HashMap<String, String> ReadMultipleDataFromExcel(String sheetname , int cellnum ) throws  IOException
   {
	   FileInputStream fis = new FileInputStream(IPathConstant.Excelpath);
       Workbook wb = WorkbookFactory.create(fis);
       Sheet sh = wb.getSheet(sheetname);
          int rowcount = sh.getLastRowNum();
          
            HashMap<String, String> map = new HashMap<String ,String>() ;
                   
                   for (int i = 0; i <= rowcount; i++)
                 {
					String key = sh.getRow(i).getCell(cellnum).getStringCellValue();
					String value = sh.getRow(i).getCell(cellnum).getStringCellValue();
					map.put(key, value);
				}
                   return map;
   }
   
   
	
     }






