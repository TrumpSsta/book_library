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
    public void selectFile()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj sciezke do pliku");
        jsonFile = scan.nextLine();
    }
    public static List<Item> readJson(String pathName) throws FileNotFoundException {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Book book;
        BufferedReader reader = new BufferedReader(new FileReader(pathName));
        // BufferedReader reader = new BufferedReader(new FileReader("/home/jedrzej/Documents/books.json"));
        book = gson.fromJson(reader, Book.class);
        List<Item> x =  book.getItems();
        VolumeInfo informations = x.get(1).getVolumeInfo();
        return x;
    }
}
