package Assignment2.Model;

public class Book {
    private int ISBN;
    private String bookTitle;
    private String bookAuthor;
    private String yearOfPublication;
    private String publisher;
    private String imageURLS;
    private String imageURLM;
    private String imageURLL;

    public Book() {
    }

    public Book(int ISBN, String bookTitle, String bookAuthor, String yearOfPublication, String publisher, String imageURLS, String imageURLM, String imageURLL) {
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.imageURLS = imageURLS;
        this.imageURLM = imageURLM;
        this.imageURLL = imageURLL;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageURLS() {
        return imageURLS;
    }

    public void setImageURLS(String imageURLS) {
        this.imageURLS = imageURLS;
    }

    public String getImageURLM() {
        return imageURLM;
    }

    public void setImageURLM(String imageURLM) {
        this.imageURLM = imageURLM;
    }

    public String getImageURLL() {
        return imageURLL;
    }

    public void setImageURLL(String imageURLL) {
        this.imageURLL = imageURLL;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", yearOfPublication='" + yearOfPublication + '\'' +
                ", publisher='" + publisher + '\'' +
                ", imageURLS='" + imageURLS + '\'' +
                ", imageURLM='" + imageURLM + '\'' +
                ", imageURLL='" + imageURLL + '\'' +
                '}';
    }
}
