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
        getJson file = new getJson();
        //file.selectFile();
        file.readJson("C:\\Users\\komp\\Downloads\\Cognifide - Java Homework 2019 (2)\\books.json");


        SpringApplication.run(BookLibraryApplication.class, args);
    }

}
