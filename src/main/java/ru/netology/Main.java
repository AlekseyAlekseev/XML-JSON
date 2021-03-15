package ru.netology;

import com.google.gson.reflect.TypeToken;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

//        /**
//         * Маска названия колонок и их порядка в CSV-файле
//         */
//        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
//        /**
//         * Имя считываемого CSV-файла
//         */
//        String fileNameCSV = "data.csv";
//        /**
//         * Имя считываемого XML-файла
//         */
        String fileNameXml = "data.xml";
//
//        Type listType = new TypeToken<List<Employee>>() {}.getType();
//
//        /**
//         * Сохраняем данные из CSV-файла в объект
//         */
//        List<Employee> listCSV = ParseCsv.parsingCSV(columnMapping, fileNameCSV);
//
//        /**
//         * Преобразуем объект в строчку формата JSON
//         */
//        String json = ParseJson.listToFormatJson(listCSV, listType);
//
//        /**
//         * Сохраняем данные полученные из метода "listToFormatJson" в data.json
//         */
//        ParseJson.writeJson(json);



        List<Employee> listXML = ParseXml.parsingXML(fileNameXml);
        System.out.println(listXML.toString());





    }
}
