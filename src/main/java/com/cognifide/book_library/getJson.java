package com.cognifide.book_library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class getJson {

    String jsonFile;
    List<Item> items;
    public void selectFile()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj sciezke do pliku");
        this.jsonFile = scan.nextLine();

    }

    public String getJsonFile() {
        return jsonFile;
    }

    public getJson() {
    }

    public getJson(String file)
    {
        this.jsonFile=file;
    }
    public static List<Item> readJson(String pathName) throws FileNotFoundException {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Book book;
        BufferedReader reader = new BufferedReader(new FileReader(pathName));
        book = gson.fromJson(reader, Book.class);
        List<Item> x =  book.getItems();
        return x;
    }


}