package com.cognifide.book_library;

import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

@SpringBootApplication
public class BookLibraryApplication {

    public static void main(String[] args) throws FileNotFoundException {

        Gson gson = new GsonBuilder().serializeNulls().create();

        Book book;
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\komp\\Downloads\\Cognifide - Java Homework 2019 (2)\\books.json"));
        book = gson.fromJson(reader, Book.class);
        List<Item> x =  book.getItems();
        VolumeInfo informations = x.get(1).getVolumeInfo();
        System.out.println(informations.toString());

       // SpringApplication.run(BookLibraryApplication.class, args);
    }

}
