package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {

    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
            List<Book> bookList = new ArrayList<Book>();
            if (titleFragment.length() < 3) return bookList;
            List<Book> resultList = libraryDatabase
                    .listBooksWithCondition(titleFragment);
            if (resultList.size() > 20) return bookList;
            bookList = resultList;
            return bookList;
    }

    List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        return libraryDatabase.listBooksInHandsOf(libraryUser);
    /*    Book book = new Book("The book title", "The book author", 2000);
        Book book2 = new Book("The book title 2", "The book author 2", 2001);
        theList.add(book);
        theList.add(book2);
*/
        //temporarily return list with 2 books

    }

}
