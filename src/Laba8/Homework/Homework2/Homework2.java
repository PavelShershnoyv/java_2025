package Laba8.Homework.Homework2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1. Найти задачу по названию");
        System.out.println("2. Добавить новую задачу");
        System.out.println("3. Удалить задачу по названию");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Введите название задачи для поиска: ");
                    String taskName = scanner.nextLine();
                    findTaskByNameInJson(taskName);
                    break;
                case 2:
                    addNewTask(scanner);
                    break;
                case 3:
                    System.out.print("Введите название задачи для удаления: ");
                    String taskToDelete = scanner.nextLine();
                    deleteTaskByName(taskToDelete);
                    break;
                default:
                    System.out.println("Неизвестная команда.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void findTaskByNameInJson(String taskName) {
        try {
            File jsonFile = new File("src/Laba8/Homework/Homework2/Homework2.json");
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(new FileReader(jsonFile));
            JSONArray tasks = (JSONArray) jsonData.get("tasks");
            boolean found = false;

            for (Object obj : tasks) {
                JSONObject task = (JSONObject) obj;
                String name = (String) task.get("name");

                if (name != null && name.equalsIgnoreCase(taskName)) {
                    found = true;
                    System.out.println("Найдена задача в JSON:");
                    System.out.println("Название: " + name);
                    System.out.println("Срок: " + task.get("term"));
                    System.out.println("Сложность: " + task.get("complexity"));
                    break;
                }
            }

            if (!found) {
                System.out.println("Задача с названием '" + taskName + "' не найдена в JSON файле.");
            }

        } catch (IOException | ParseException e) {
            System.out.println("Ошибка при работе с JSON файлом: " + e.getMessage());
        }
    }

    private static void addNewTask(Scanner scanner) {
        try {
            File jsonFile = new File("src/Laba8/Homework/Homework2/Homework2.json");
            JSONObject jsonData;
            JSONArray tasks;
            JSONParser parser = new JSONParser();
            jsonData = (JSONObject) parser.parse(new FileReader(jsonFile));
            tasks = (JSONArray) jsonData.get("tasks");


            System.out.println("Добавление новой задачи в JSON:");

            System.out.print("Введите название задачи: ");
            String name = scanner.nextLine();

            System.out.print("Введите срок выполнения (в формате До хх.хх.хххх): ");
            String term = scanner.nextLine();

            System.out.print("Введите сложность задачи (легкая/средняя/сложная): ");
            String complexity = scanner.nextLine();

            JSONObject newTask = new JSONObject();
            newTask.put("name", name);
            newTask.put("term", term);
            newTask.put("complexity", complexity);

            tasks.add(newTask);

            try (FileWriter fileWriter = new FileWriter(jsonFile)) {
                fileWriter.write(jsonData.toJSONString());
                System.out.println("Задача '" + name + "' успешно добавлена в JSON файл.");
                System.out.println("Всего задач в файле: " + tasks.size());
            }

        } catch (IOException | ParseException e) {
            System.out.println("Ошибка при работе с JSON файлом: " + e.getMessage());
        }
    }

    private static void deleteTaskByName(String taskName) {
        try {
            File jsonFile = new File("src/Laba8/Homework/Homework2/Homework2.json");
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(new FileReader(jsonFile));
            JSONArray tasks = (JSONArray) jsonData.get("tasks");
            boolean taskFound = false;
            int taskIndex = -1;

            for (int i = 0; i < tasks.size(); i++) {
                JSONObject task = (JSONObject) tasks.get(i);
                String name = (String) task.get("name");

                if (name != null && name.equalsIgnoreCase(taskName)) {
                    taskFound = true;
                    taskIndex = i;
                    break;
                }
            }

            if (taskFound) {
                tasks.remove(taskIndex);
                try (FileWriter fileWriter = new FileWriter(jsonFile)) {
                    fileWriter.write(jsonData.toJSONString());
                    System.out.println("Задача '" + taskName + "' успешно удалена из JSON файла.");
                    System.out.println("Всего задач в файле: " + tasks.size());
                }
            } else {
                System.out.println("Задача с названием '" + taskName + "' не найдена в JSON файле.");
            }

        } catch (IOException | ParseException e) {
            System.out.println("Ошибка при работе с JSON файлом: " + e.getMessage());
        }
    }
}
