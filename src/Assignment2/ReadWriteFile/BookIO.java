package Assignment2.ReadWriteFile;

import Assignment2.Model.Book;

import java.io.*;
import java.util.ArrayList;

public class BookIO {
    public BookIO() {
    }

    public static Book book = new Book();
    private static final String BASE_PATH = new File("").getAbsolutePath();
    private static final String READ_PATH = "src/Assignment2/Data/books.csv";
    private static final String WRITE_PATH = "src/Assignment2/Data/books1.csv";
    private static final String BOOK_FILE = BASE_PATH+READ_PATH;

    public void loadWordsFromFile(ArrayList<Book> books) {
        try (BufferedReader reader = new BufferedReader(new FileReader("F:\\CSD201\\src\\Assignment2\\Data\\books.csv"))) {
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
//        public void saveFile() {
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(BASE_PATH + WRITE_PATH))) {
////                for (AuthorB authorB : abList) {
////                    bw.write(authorB.getISBN()+ ';'+authorB.getBookTitle()+ ';'+authorB.getBookAuthor()+';'+ authorB.getYearOfPu()+';'+ authorB.getPulisher()+';'+ authorB.getUrlS()+';'+ authorB.getUrlM()+';'+ authorB.getUrlL());
////                    bw.newLine();
////                }
//                books.forEach(book1 -> {
//                    try {
//                        writer.write(book1.getISBN() + ';'+ book1.getBookTitle()+';'+book1.getBookAuthor()+';'+book1.getYearOfPublication()+';'+book1.getPublisher()+';'+book1.getImageURLS()+';'+book1.getImageURLM()+';'+book1.getImageURLL());
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//            writer.newLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }


}
