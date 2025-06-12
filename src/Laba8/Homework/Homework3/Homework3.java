package Laba8.Homework.Homework3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Homework3 {
    private static final String URL = "https://itlearn.ru/first-steps";
    private static final String OUTPUT_DIRECTORY = "src/Laba8/Homework/Homework3";
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 2000;

    public static void main(String[] args) {
        System.out.println("Запуск парсера новостей...");

        try {
            List<String> links = new ArrayList<>();

            boolean success = parseNewsWithRetry(links);

            if (success && !links.isEmpty()) {
                saveNewsToFile(links);
            } else {
                System.out.println("Не удалось получить новости после нескольких попыток.");
            }

        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean parseNewsWithRetry(List<String> links) {
        int retryCount = 0;
        boolean success = false;

        while (!success && retryCount < MAX_RETRIES) {
            try {
                System.out.println("Попытка подключения к " + URL + " (" + (retryCount + 1) + "/" + MAX_RETRIES + ")");
                Document doc = Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0")
                        .timeout(10000)
                        .get();

                Elements newsElements = doc.select("a[href]");

                for (Element element : newsElements) {
                    try {
                        String link = element.attr("abs:href");
                        links.add(link);
                    } catch (Exception e) {
                        System.out.println("Ошибка при обработке элемента новости: " + e.getMessage());
                    }
                }

                System.out.println("Успешно получены данные с сайта. Найдено новостей: " + links.size());
                success = true;

            } catch (IOException e) {
                retryCount++;
                System.out.println("Ошибка при подключении к сайту: " + e.getMessage());

                if (retryCount < MAX_RETRIES) {
                    System.out.println("Повторная попытка через " + (RETRY_DELAY_MS / 1000) + " секунд...");
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Достигнуто максимальное количество попыток. Не удалось подключиться к сайту.");
                }
            }
        }

        return success;
    }

    private static void saveNewsToFile(List<String> links) {
        String fileName = "news_links.txt";
        File outputFile = new File(OUTPUT_DIRECTORY, fileName);

        try (FileWriter writer = new FileWriter(outputFile)) {
            for (int i = 0; i < links.size(); i++) {
                writer.write("Новость #" + (i + 1) + "\n");
                writer.write("Ссылка: " + links.get(i) + "\n");
                writer.write("=".repeat(50) + "\n\n");
            }

            System.out.println("Данные успешно сохранены в файл: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
