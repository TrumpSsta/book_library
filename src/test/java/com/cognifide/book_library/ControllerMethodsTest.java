package com.cognifide.book_library;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class ControllerMethodsTest {
    GetJson json =null;
    ControllerMethods controllerMethods=null;
    @Before
    public void setUp() throws Exception {
        json=new GetJson("books.json");
        controllerMethods= new ControllerMethods();
    }

    @Test
    public void getbookByIsbnNumbers() throws FileNotFoundException {

    assertNotEquals(book,controllerMethods.getbookByIsbnNumber(json,"9780080568782"));
    }

    @Test
    public void getbookByCategoryName() {
    }

    @Test
    public void getAuthorsWithRatings() {
    }

    @Test
    public void getAuthors() {
    }

    @Test
    public void checkAuthorsList() {
    }
    String book= "{\n" +
            "  \"isbn\": \"9780080568722\",\n" +
            "  \"title\": \"TCP/IP Sockets in Java\",\n" +
            "  \"subtitle\": \"Practical Guide for Programmers\",\n" +
            "  \"publisher\": \"Morgan Kaufmann\",\n" +
            "  \"publishedDate\": \"2011-08-29\",\n" +
            "  \"description\": \"The networking capabilities of the Java platform have been extended considerably since the first edition of the book\",\n" +
            "  \"pageCount\": 192,\n" +
            "  \"thumbnailUrl\": \"http://books.google.com/books/content?id=lfHo7uMk7r4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\",\n" +
            "  \"language\": \"en\",\n" +
            "  \"previewLink\": \"http://books.google.pl/books?id=lfHo7uMk7r4C&printsec=frontcover&dq=java&hl=&cd=38&source=gbs_api\",\n" +
            "  \"averageRating\": 4.0,\n" +
            "  \"authors\": [\n" +
            "    \"Kenneth L. Calvert\",\n" +
            "    \"Michael J. Donahoo\"\n" +
            "  ],\n" +
            "  \"categories\": [\n" +
            "    \"Computers\"\n" +
            "  ]\n" +
            "}";
}