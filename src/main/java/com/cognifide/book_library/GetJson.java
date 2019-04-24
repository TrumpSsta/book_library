package com.cognifide.book_library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
//clas for reading json file
public class GetJson {

    String jsonFile;
    List<Item> items;
    //zapisywanie ścieżki do pliku json z klawiatury
    public void selectFile()
    {
        Scanner scan = new Scanner(System.in);
        this.jsonFile = scan.nextLine();

    }

    public String getJsonFile() {
        return jsonFile;
    }

    public GetJson() {
    }
    //odczytywanie książek z jsona
    public GetJson(String file)
    {
        this.jsonFile=file;
    }
    public static List<Item> readJson(String pathName) throws FileNotFoundException {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Book book;
        BufferedReader reader = new BufferedReader(new FileReader(pathName));
        book = gson.fromJson(reader, Book.class);

        return book.getItems();
    }


}