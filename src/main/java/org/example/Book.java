package org.example;

public class Book {
    // static List<Book> books = new ArrayList<>();

    private String name;
    private Integer numberOfPages;

    public Book(){
        this("Unknown", 0);
    }

    public Book(String name, Integer numberOfPages){
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages + ",";

    }
}
