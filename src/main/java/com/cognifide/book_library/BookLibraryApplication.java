package com.cognifide.book_library;

import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BookLibraryApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(BookLibraryApplication.class, args);
    }

}
