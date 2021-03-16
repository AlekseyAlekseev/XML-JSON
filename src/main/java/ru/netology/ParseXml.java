package ru.netology;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParseXml {


    /**
     * Метод считывающий данные из указанного XML-файла и сохраняющий данные в объект по заданной маске
     */
    public static List<Map<String, String>> parsingXml(File inputFile, String[] columnMapping, String objNode) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        List<Map<String, String>> objectsList = new ArrayList<>();
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            NodeList nodeList = document.getElementsByTagName(objNode);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                objectsList.add(writeToMap(node, columnMapping));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return objectsList;
    }

    /**
     * Внутренний метод формирующий Map с полями будущего java объекта.
     * Key - наименование XML тэга, Value - значение XML тэга.
     *
     * @param node
     * @param fields
     * @return
     */
    private static Map<String, String> writeToMap(Node node, String[] fields) {
        Map<String, String> xmlMap = new LinkedHashMap<>();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            for (String field : fields) {
                NodeList list = element.getElementsByTagName(field).item(0).getChildNodes();
                Node myNode = list.item(0);
                xmlMap.put(field, myNode.getNodeValue());
            }
        }
        return xmlMap;
    }
}

