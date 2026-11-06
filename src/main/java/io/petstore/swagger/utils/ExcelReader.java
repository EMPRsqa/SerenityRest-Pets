package io.petstore.swagger.utils;

import io.petstore.swagger.models.pet.UserModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    public static UserModel getDataFromExcel(String filePath, String sheetName) {
        UserModel user = null;
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(1); // Fila 1 (asumiendo cabecera en fila 0)

            int id = (int) row.getCell(0).getNumericCellValue();
            String username = row.getCell(1).getStringCellValue();
            String firstName = row.getCell(2).getStringCellValue();
            String lastName = row.getCell(3).getStringCellValue();
            String email = row.getCell(4).getStringCellValue();
            String password = row.getCell(5).getStringCellValue();
            String phone = row.getCell(6).getStringCellValue();
            int userStatus = (int) row.getCell(7).getNumericCellValue();

            user = new UserModel(id, username, firstName, lastName, email, password, phone, userStatus);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}