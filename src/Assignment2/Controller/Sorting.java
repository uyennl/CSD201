package Assignment2.Controller;

import Assignment2.Model.Book;

import java.util.ArrayList;

public class Sorting {
    public void bubbleSortBookA(ArrayList<Book> books ) {
        for (int i = 0; i < books.size() - 1; i++) {
            for (int j = 0; j < books.size() - i - 1; j++) {
                String bookA1 = books.get(j).getBookAuthor();
                String bookA2 = books.get(j + 1).getBookAuthor();

                if (bookA1.compareTo(bookA2) > 0) {
                    Book temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
    }
    int partition(ArrayList<Book> books, int left, int right) {
        int i = left, j = right;
        String pivot = books.get(left + (right - left) / 2).getBookTitle();

        while (i <= j) {
            while (books.get(i).getBookTitle().compareTo(pivot) < 0) {
                i++;
            }
            while (books.get(j).getBookTitle().compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
                i++;
                j--;
            }
        }
        return i;
    }

    public void quickSort(ArrayList<Book> books, int left, int right) {
        if (left < right) {
            int index = partition(books, left, right);
            quickSort(books, left, index - 1);
            quickSort(books, index, right);
        }
    }

}
