package io.pragra.shipcarte.data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {

    public static List<List<String>> credentials(String file, String sheet) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet workbookSheet = workbook.getSheet(sheet);
        Iterator<Row> rowIterator = workbookSheet.rowIterator();
        List<List<String>> sheetData = new ArrayList<>();
        List<String> rowData = new ArrayList<>();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                rowData.add(cell.toString());
            }
            sheetData.add(new ArrayList<>(rowData));
            rowData.clear();
        }
        return sheetData;
    }
}
