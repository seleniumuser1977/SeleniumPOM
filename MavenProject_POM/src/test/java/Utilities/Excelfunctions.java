package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfunctions

{
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fo;
	public static CellStyle style;
	
	public static int getRowCount(String Excelsheet,String worksheet) throws IOException
	{
		
		
		fi = new FileInputStream(Excelsheet);
		
		wb= new XSSFWorkbook(fi);
		
		ws= wb.getSheet(worksheet);
		
		int rownum= ws.getLastRowNum();
		wb.close();
		
		return rownum;
	
			
	}
	
	
	
	public static int getColumnCount(String Excelsheet,String worksheet, int rownum ) throws IOException
	{
		
		fi = new FileInputStream(Excelsheet);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(worksheet);
		row = ws.getRow(rownum);
		int columncount= row.getLastCellNum();
		wb.close();
		return columncount;
		
	}
	
	
	
	public static String getStringData(String Excelsheet,String worksheet, int rownum,int cellnum ) throws IOException
	
	{
		
		fi=new FileInputStream(Excelsheet);
		
		wb=new XSSFWorkbook(fi);
		
		ws= wb.getSheet(worksheet);
		
		row=ws.getRow(rownum);
		
		cell = row.getCell(cellnum);
		
		String celldata= cell.getStringCellValue();
		
		wb.close();
		
		return celldata;
	}
	
	
	public static Boolean getBooleanData(String Excelsheet,String worksheet, int rownum,int cellnum) throws IOException
	{
		
		
		fi= new FileInputStream(Excelsheet);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(worksheet);
		row= ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		Boolean celldata= cell.getBooleanCellValue();
		
		wb.close();
		
		return celldata;
			
	}
	
	
	public static Double getNumericData(String Excelsheet,String worksheet, int rownum,int cellnum) throws IOException
	{
		
		fi=new FileInputStream(Excelsheet);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(worksheet);
		row=ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		Double celldata= cell.getNumericCellValue();
		
		wb.close();
		return celldata;
						
	}
	
	public static void setData(String Excelsheet,String worksheet, int rownum,int cellnum, String result) throws IOException
	{
		
		fi= new FileInputStream(Excelsheet);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(worksheet);
		row=ws.getRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(result);
		fo= new FileOutputStream(Excelsheet);
		wb.write(fo);
		wb.close();
	}
	
	public static void fillGreencolor(String Excelsheet,String worksheet, int rownum,int cellnum) throws IOException
	{
		
		fi= new FileInputStream(Excelsheet);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(worksheet);
		row=ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style= wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo= new FileOutputStream(Excelsheet);
		wb.write(fo);
		wb.close();
	}
	
	
	public static void fillredcolor(String Excelsheet,String worksheet, int rownum,int cellnum) throws IOException
	{
		
		fi= new FileInputStream(Excelsheet);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(worksheet);
		row=ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		
		fo= new FileOutputStream(Excelsheet);
		wb.write(fo);
		wb.close();
	}
	
}
