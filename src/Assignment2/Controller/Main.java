package Assignment2.Controller;

import Assignment2.Model.Book;
import Assignment2.ReadWriteFile.BookIO;

import java.io.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        BookIO input = new BookIO();
        Sorting sorting = new Sorting();
        input.loadWordsFromFile(books);
        System.out.println("Bubble Sort By Author");
        long startTime = System.currentTimeMillis();
        sorting.bubbleSortBookA(books);//1518586 ms //25 phút
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Quick Sort By Author");
        long startTimeQ = System.currentTimeMillis();
        sorting.quickSort(books,0,books.size()-1);
        long endTimeQ = System.currentTimeMillis();//180 ms = 0,18s
        long executionTimeQ = endTimeQ - startTimeQ;
        System.out.println("Time: "+executionTimeQ);


    }
}
