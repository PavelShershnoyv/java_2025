package Laba8.Homework.Homework4;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Homework4 {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        XSSFWorkbook workbook = null;

        try {
            String filePath = "src/Laba8/Example7/example7.xlsx";

            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("Ошибка: Файл не найден: " + filePath);
            }

            try {
                inputStream = new FileInputStream(filePath);

                try {
                    workbook = new XSSFWorkbook(inputStream);
                    XSSFSheet sheet = workbook.getSheet("Товары");
                    if (sheet == null) {
                        throw new IllegalArgumentException("Ошибка: Лист 'Товары' не найден в документе");
                    }

                    boolean isEmpty = true;
                    for (Row row : sheet) {
                        boolean hasData = false;
                        StringBuilder rowContent = new StringBuilder();

                        for (Cell cell : row) {
                            String cellValue = cell.toString();
                            rowContent.append(cellValue).append("\t");
                            if (!cellValue.trim().isEmpty()) {
                                hasData = true;
                            }
                        }

                        if (hasData) {
                            System.out.println(rowContent.toString());
                            isEmpty = false;
                        }
                    }

                    if (isEmpty) {
                        System.out.println("Предупреждение: Лист 'Товары' не содержит данных");
                    }

                } catch (NotOfficeXmlFileException e) {
                    System.err.println("Ошибка: Файл не является документом Excel в формате .xlsx");
                    System.err.println("Рекомендация: Убедитесь, что файл имеет формат .xlsx, а не .xls или другой формат");
                } catch (InvalidFormatException e) {
                    System.err.println("Ошибка: Недопустимый формат Excel-файла: " + e.getMessage());
                    System.err.println("Рекомендация: Проверьте, не поврежден ли файл");
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении Excel-файла: " + e.getMessage());
                    System.err.println("Рекомендация: Проверьте, не открыт ли файл в другой программе");
                }
            } catch (FileNotFoundException e) {
                System.err.println("Ошибка: Не удалось открыть файл: " + e.getMessage());
                System.err.println("Рекомендация: Убедитесь, что у вас есть права на чтение файла");
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии ресурсов: " + e.getMessage());
            }
        }
    }
}
