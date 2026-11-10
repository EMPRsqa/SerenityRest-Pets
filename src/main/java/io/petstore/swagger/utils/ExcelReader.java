package io.petstore.swagger.utils;

import io.petstore.swagger.models.pet.UserModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static UserModel getDataFromExcel(String filePath, String sheetName) {
        UserModel user = null;
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(1); // Fila 1 (Fila 0 es la cabecera)

            // Usamos DataFormatter para leer cualquier celda (texto o número) de forma segura como String o convertimos a int
            int id = (int) Double.parseDouble(formatter.formatCellValue(row.getCell(0)));
            String username = formatter.formatCellValue(row.getCell(1));
            String firstName = formatter.formatCellValue(row.getCell(2));
            String lastName = formatter.formatCellValue(row.getCell(3));
            String email = formatter.formatCellValue(row.getCell(4));
            String password = formatter.formatCellValue(row.getCell(5));
            String phone = formatter.formatCellValue(row.getCell(6));
            int userStatus = (int) Double.parseDouble(formatter.formatCellValue(row.getCell(7)));

            user = new UserModel(id, username, firstName, lastName, email, password, phone, userStatus);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}