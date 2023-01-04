package com.kodilla.patterns2.adapter.company.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("Author", "Title", 1975, "sdlfasdfla");
        Book book2 = new Book("Author", "Title", 1980, "sdlfajdfsdfla");
        Book book3 = new Book("Author", "Title", 1999, "sdlfajsddffla");
        Book book4 = new Book("Author", "Title", 2020, "sdlfadfsjsdfla");
        Book book5 = new Book("Author", "Title", 2021, "sdlfajsfdfla");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(1999, median);
    }
}
