package ru.netology;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseXml {

    public static List<Employee> parsingXML(String fileNameXml) throws ParserConfigurationException, IOException, SAXException {
        List<Employee> staff = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(fileNameXml));

        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);
            NamedNodeMap attributes = employee.getAttributes();
            staff.add(new Employee(attributes.getNamedItem("id").getNodeValue(),
                    attributes.getNamedItem("firstName").getNodeValue(),
                    attributes.getNamedItem("lastName").getNodeValue(),
                    attributes.getNamedItem("country").getNodeValue(),
                    attributes.getNamedItem("age").getNodeValue()));
        }
        for (Employee employee : staff) {
            System.out.println(String.format("Информации о сотруднике: номер - %s, имя - %s, " +
                    "фамилия - %s,  страна - %s, возраст - %s", employee.getId(), employee.getFirstName(),
                    employee.getLastName(), employee.getCountry(), employee.getAge()));
        }
        return staff;
    }
}
