package ru.netology;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        /**
         * Маска названия колонок и их порядка в CSV-файле
         */
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};

        /**
         * Вводные файлы для чтения
         */
        File fileNameCSV = new File("data.csv");
        File fileNameXml = new File("data.xml");

        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        /**
         * Сохраняем данные из CSV-файла в объект
         */
        List<Employee> listCsv = ParseCsv.parsingCSV(columnMapping, fileNameCSV);

        /**
         * Преобразуем объект в строчку формата JSON
         */
        String jsonCsv = ParseJson.listToFormatJson(listCsv, listType);

        /**
         * Сохраняем данные полученные из метода "listToFormatJson" в data.json
         */
        ParseJson.writeJson(jsonCsv, "data.json");


        /**
         * Сохраняем данные из XML-файла в объект
         */
        List<Map<String, String>> listXml = ParseXml.parsingXml(fileNameXml, columnMapping, "employee");


        /**
         * Преобразуем объект в строчку формата JSON
         */
        String jsonXml = ParseJson.listToFormatJson(listXml, listType);

        /**
         * Сохраняем данные полученные из метода "listToFormatJson" в data.json
         */
        ParseJson.writeJson(jsonXml, "data2.json");
    }
}