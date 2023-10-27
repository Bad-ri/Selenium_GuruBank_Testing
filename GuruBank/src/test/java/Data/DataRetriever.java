package Data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataRetriever {
    FileInputStream input_file ;
    XSSFWorkbook workbook ;
    XSSFSheet sheet ;
    int table_row ;
    public DataRetriever(int row){
        this.table_row = row ;
    }
    public String ExcelData (int sheet_number, int row, int cell) {
        ExcelSetup(sheet_number);
        return String.valueOf(sheet.getRow(row).getCell(cell));
    }
    public void ExcelSetup (int sheet_number){
        String path = System.getProperty("user.dir") + "/src/main/resources/Data/Excel/Data.xlsx" ;
        try{
            input_file = new FileInputStream(path);
            workbook = new XSSFWorkbook(input_file);
            sheet = workbook.getSheetAt(sheet_number);
        }catch (IOException e){
            System.out.println("excel file error");
        }
    }
    public String getAccountUsername(){
        return ExcelData(0,table_row,0);
    }
    public String getAccountPassword(){
        return ExcelData(0,table_row,1);
    }
    public String getName(){return ExcelData(1,table_row,0);}
    public String getGender(){return ExcelData(1,table_row,1);}
    public String getBirthDay(){return ExcelData(1,table_row,2);}
    public String getAddress(){return ExcelData(1,table_row,3);}
    public String getCity(){return ExcelData(1,table_row,4);}
    public String getState(){return ExcelData(1,table_row,5);}
    public String getPin(){return ExcelData(1,table_row,6);}
    public String getMobile(){return ExcelData(1,table_row,7);}
    public String getEmail(){return ExcelData(1,table_row,8);}
    public String getPassword(){return ExcelData(1,table_row,9);}

}

