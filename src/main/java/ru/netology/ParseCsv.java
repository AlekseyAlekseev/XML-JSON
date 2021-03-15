package ru.netology;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseCsv {

    /**
     * Метод считывающий данные из указанного CSV-файла и сохраняющий данные в объект по заданной маске
     * @param columnMapping Маска названия колонок и их порядка
     * @param fileName      Имя считываемого CSV-файла
     * @return
     */
    public static List<Employee> parsingCSV(String[] columnMapping, String fileName) {
        List<Employee> staff = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping("id", "firstName", "lastName", "country", "age");

            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();

            staff = csv.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staff;
    }
}
