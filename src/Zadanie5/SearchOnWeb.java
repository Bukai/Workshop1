package src.Zadanie5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class SearchOnWeb {

    public static void main(String[] args) {

        String[] deleteWord = {"dla", "ale", "oraz"};

        System.out.println("I will search any website for you\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter which internet service to search! Remember about the correctly written address. Example: www.onet.pl");
        String link = scan.nextLine();

        try {
            connect("http://" + link);
            filteredPopularWords(deleteWord);
        } catch (IllegalArgumentException e) {
            System.out.println("You have entered an invalid address. Run the program again");
        }
    }

    private static void connect(String link) {
        try {
            Path fileToWrite = Paths.get("popular_words.txt");
            PrintWriter printWriter = new PrintWriter("popular_words.txt");
            Connection connect = Jsoup.connect(link);
            Document document = connect.get();
            Elements links = document.select("span.title");

            if (!Files.exists(fileToWrite)) {
                Files.createFile(fileToWrite);
            }

            for (Element elem : links) {
                printWriter.println(elem.text());
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filteredPopularWords(String[] deleteWord) {
        try {
            File file = new File("popular_words.txt");
            FileWriter fileWriter = new FileWriter("filtered_popular_words.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();

            while(scanner.hasNextLine()){
                for(String word : deleteWord){
                    line = line.replaceAll(word,"");
                }
                fileWriter.append(line).append("\n");
            }
            fileWriter.close();

        } catch (FileNotFoundException e){
            System.out.println("File does not exist");
        } catch (IOException e){
            System.out.println("Something goes wrong");
        }

    }
}
