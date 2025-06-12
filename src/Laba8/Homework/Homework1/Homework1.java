package Laba8.Homework.Homework1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class Homework1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1. Добавить новую задачу");
        System.out.println("2. Найти задачи по сложности");
        System.out.println("3. Удалить задачу по названию");
        int choice = Integer.parseInt(scanner.nextLine());


        try {
            if (choice == 1) {
                System.out.print("Введите название задачи: ");
                String name = scanner.nextLine();

                System.out.print("Введите срок выполнения (в формате До хх.хх.хххх): ");
                String term = scanner.nextLine();

                System.out.print("Введите сложность задачи (легкая/средняя/сложная): ");
                String complexity = scanner.nextLine();

                addTaskXmlFile(name, term, complexity);
                System.out.println("Задача успешно добавлена!");

            } else if (choice == 2) {
                System.out.print("Введите сложность для поиска (легкая/средняя/сложная): ");
                String complexity = scanner.nextLine();
                findTasksByComplexity(complexity);
            } else if (choice == 3) {
                System.out.print("Введите название задачи для удаления: ");
                String nameTask = scanner.nextLine();
                deleteTask(nameTask);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void addTaskXmlFile(String name, String term, String complexity) throws Exception {
        File file = new File("src/Laba8/Homework/Homework1.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        Element rootElement = doc.getDocumentElement();

        Element task = doc.createElement("task");
        rootElement.appendChild(task);

        Element nameXML = doc.createElement("name");
        nameXML.appendChild(doc.createTextNode(name));
        task.appendChild(nameXML);

        Element termXML = doc.createElement("term");
        termXML.appendChild(doc.createTextNode(term));
        task.appendChild(termXML);

        Element complexityXML = doc.createElement("complexity");
        complexityXML.appendChild(doc.createTextNode(complexity));
        task.appendChild(complexityXML);

        doc.setXmlStandalone(true);
        doc.normalizeDocument();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }

    private static void findTasksByComplexity(String complexity) {
        try {
            File file = new File("src/Laba8/Homework/Homework1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList taskList = doc.getElementsByTagName("task");
            List<Element> result = new ArrayList<>();

            for (int i = 0; i < taskList.getLength(); i++) {
                Element task = (Element) taskList.item(i);
                String taskComplexity = "";

                NodeList nodeList = task.getElementsByTagName("complexity");
                if (nodeList.getLength() > 0) {
                    Node node = nodeList.item(0);
                    taskComplexity = node.getTextContent();
                }

                if (taskComplexity.equalsIgnoreCase(complexity)) {
                    result.add(task);
                }
            }

            if (result.isEmpty()) {
                System.out.println("Задачи со сложностью '" + complexity + "' не найдены.");
            } else {
                System.out.println("Найдены задачи со сложностью '" + complexity + "':");
                for (int i = 0; i < result.size(); i++) {
                    Element task = result.get(i);
                    System.out.println((i + 1) + ". " + task.getElementsByTagName("name").item(0)
                            .getTextContent() + " (срок: " + task.getElementsByTagName("term").item(0)
                            .getTextContent() + ")");
                }
                System.out.println("Всего найдено задач: " + result.size());
            }
        } catch (Exception e) {
            System.out.println("Ошибка при работе с XML-файлом: " + e.getMessage());
        }
    }

    private static void deleteTask(String nameTask) {
        try {
            File file = new File("src/Laba8/Homework/Homework1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList taskList = doc.getElementsByTagName("task");
            boolean taskFound = false;

            for (int i = 0; i < taskList.getLength(); i++) {
                Node node = taskList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = "";
                    NodeList nodeList = element.getElementsByTagName("name");
                    if (nodeList.getLength() > 0) {
                        Node nodeName = nodeList.item(0);
                        name = nodeName.getTextContent();
                    }

                    if (name.equalsIgnoreCase(nameTask)) {
                        node.getParentNode().removeChild(node);
                        taskFound = true;
                        break;
                    }
                }
            }

            if (taskFound) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);

                System.out.println("Задача '" + nameTask + "' успешно удалена.");
            } else {
                System.out.println("Задача с названием '" + nameTask + "' не найдена.");
            }

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            System.out.println("Ошибка при работе с XML-файлом: " + e.getMessage());
        }
    }
}
