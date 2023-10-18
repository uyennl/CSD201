package Assignment2.ReadFile;

import Assignment2.Model.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {
    public Input() {
    }

    public static Book book = new Book();
    public static ArrayList<Book> books = new ArrayList<>();
    private static final String BASE_PATH = new File("").getAbsolutePath();
    private static final String READ_PATH = "src/Assignment2/Data/books.csv";
    private static final String BOOKS_FILE = BASE_PATH + READ_PATH;
    public void loadWordsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 8) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        String bookTitle = parts[1];
                        String bookAuthor = parts[2];
                        String yearOfPublication = parts[3];
                        String publisher = parts[4];
                        String imageURLS = parts[5];
                        String imageURLM = parts[6];
                        String imageURLL = parts[7];
                        books.add(new Book(id, bookTitle, bookAuthor, yearOfPublication, publisher, imageURLS, imageURLM, imageURLL));
                    } catch (NumberFormatException e) {
                        // Skip the book if ID cannot be parsed as an integer
                    }
                }
            }
//            books.forEach(book1 -> System.out.println(book1));
            System.out.println("Dictionary loaded successfully.");
        } catch (IOException e) {
            System.out.println("No existing dictionary found. Creating a new one.");
        }
    }

}
