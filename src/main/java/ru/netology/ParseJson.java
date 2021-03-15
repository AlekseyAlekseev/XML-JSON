package ru.netology;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ParseJson {

    /**
     * Преобразуем объект в строчку формата JSON
     * @param list объект с данными полученными из CSV-файла
     * @param listType тип списка
     * @return
     */
    public static String listToFormatJson(List list, Type listType) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(list, listType);
    }

    /**
     * Сохраняем данные полученные из метода "listToFormatJson" в data.json
     * @param json строка с данными из метода "listToFormatJson"
     */
    public static void writeJson(String json) {
        try (FileWriter file = new FileWriter("data.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
