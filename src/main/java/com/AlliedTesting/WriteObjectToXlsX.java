package com.AlliedTesting;


import java.io.*;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class WriteObjectToXlsX {

    private static String[] columns = {"NumCode", "CharCode","Nominal", "Name","Value","ID"};

    public static void writeValCursToXlsX(ValCurs valCurs){

        String excelFilePath = "workbook.xls"; //файл должен быть создан

        try{
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);                   // создаю стиль для Header
            headerFont.setFontHeightInPoints((short) 14);

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);



            List<Valute> arrayListOfValute = valCurs.getValutes();
            Sheet newSheet = workbook.createSheet(valCurs.getDate());

            for (int j = 0 ,i=1; j < arrayListOfValute.size(); j++, i++) {

                Row headerRow = newSheet.createRow(0);
                for (int q = 0; q < columns.length; q++) {
                    Cell cell = headerRow.createCell(q);
                    cell.setCellValue(columns[q]);         //заполняю нашу шапку(Header) значениями
                    cell.setCellStyle(headerCellStyle);
                }

                Row row = newSheet.createRow(i);

                row.createCell(0).setCellValue(arrayListOfValute.get(j).getNumCode());
                row.createCell(1).setCellValue(arrayListOfValute.get(j).getCharCode());
                row.createCell(2).setCellValue(arrayListOfValute.get(j).getNominal());
                row.createCell(3).setCellValue(arrayListOfValute.get(j).getName());
                row.createCell(4).setCellValue(arrayListOfValute.get(j).getValue());
                row.createCell(5).setCellValue(arrayListOfValute.get(j).getId());

            }


//                     Resize all columns to fit the content size
            for (int q = 0; q < columns.length; q++) {
                newSheet.autoSizeColumn(q);
            }

            FileOutputStream outputStream = new FileOutputStream("workbook.xls");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void CreateXlsFile(){

        Workbook wb = new HSSFWorkbook();

        Sheet sheet1 = wb.createSheet("I-1702");
        Row newRow = sheet1.createRow(1);
        newRow.createCell(1).setCellValue("Pinzaru Georghe");
        try  (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
