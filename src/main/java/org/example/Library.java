package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library
{
    private List<Book> books = new ArrayList<>();

    public static void main( String[] args ) {
        Library library = new Library();

        Scanner keyboard = new Scanner(System.in);
        String action;

        do{
            displayMenu();
            action = keyboard.nextLine();

            switch (action){
                case "A":
                    System.out.println("Book name= ?");
                    String bookName = keyboard.nextLine();

                    Integer numberOfPages = 0;
                    boolean isValidNoOfPages = false;
                    while (!isValidNoOfPages){
                        isValidNoOfPages = true;
                        System.out.println("Number of pages = ?");
                        String nop = keyboard.nextLine();
                        try {
                            numberOfPages = Integer.parseInt(nop);
                        }catch(NumberFormatException numberFormatException){
                            isValidNoOfPages = false;
                        }
                    }

                    Book book = new Book();
                    boolean isValidBook = false;
                    while(!isValidBook) {
                        isValidBook = true;
                        System.out.println("N = novel; A = ArtAlbum");
                        String inputType = keyboard.nextLine();
                        if ("N".equals(inputType)) {
                            System.out.println("Novel type = ? ");
                            String type = keyboard.nextLine();
                            book = new Novel(bookName, numberOfPages, type);
                        } else if ("A".equals(inputType)) {
                            System.out.println("Art album paper quality = ? ");
                            String paperQuality = keyboard.nextLine();
                            book = new ArtAlbum(bookName, numberOfPages, paperQuality);
                        } else{
                            isValidBook = false;
                        }
                    }

                    library.addBook(book);

                    break;

                case "D":
                    System.out.println("Book name = ?");
                    String bookNameToBeDeleted = keyboard.nextLine();
                    library.deleteBook(bookNameToBeDeleted);
                    break;

                case "L":
                    library.listBooks();
            }



        }while (!"X".equals(action));

//        Novel tsshf = new Novel("Tom Sawyer and Huckleberry Finn", 237, "adventure");
//        // books.add(tsshf);
//        library.addBook(tsshf);
//        ArtAlbum artAlbum1 = new ArtAlbum("Album cu flori", 1237, "glossy");
//        library.addBook(artAlbum1);
//
//        library.listBoooks();

    }

    public void addBook(Book book){
        if(!(book instanceof Novel) || (book instanceof Novel && !((Novel)book).getType().equals("adult"))) {
            this.books.add(book);
        }
    }

    public void deleteBook(String name){
        Book bookToBeDeleted = null;
        for (Book book: books) {
            if(book.getName().equals(name)){
                bookToBeDeleted = book;
                break;
            }
        }

        if(bookToBeDeleted != null){
            books.remove(bookToBeDeleted);
        }
    }

    public void listBooks(){
        for (Book book: books) {
            System.out.println(book.toString());
        }
    }

    static void displayMenu(){
        System.out.println("A = add");
        System.out.println("D = delete");
        System.out.println("L = list");
        System.out.println("X = exit");
        System.out.println("Type your option");
    }

}
