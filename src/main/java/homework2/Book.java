package homework2;

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String genre;
    private int pages;

    public Book() {
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public Book(String title, String author, int year, String publisher, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
    }
    public void inputData(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void inputData(String title, String author, int year, String publisher, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public void displayInfo() {
        System.out.println("\nІнформація про книгу:");
        System.out.println("Назва: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Рік: " + year);
        System.out.println("Видавництво: " + publisher);
        System.out.println("Жанр: " + genre);
        System.out.println("Сторінок: " + pages);
    }

    public static void main(String[] args) {
        Book book1 = new Book("Енеїда", "Іван Котляревський", 1842, "Школа", "Поема", 500);
        book1.displayInfo();

        Book book2 = new Book();
        book2.inputData("Кайдаше́ва сім'я́", "Іван Нечуй-Левицький");
        book2.setYear(1879);
        book2.displayInfo();

    }
}