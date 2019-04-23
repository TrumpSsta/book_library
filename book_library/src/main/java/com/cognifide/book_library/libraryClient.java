package com.cognifide.book_library;

import com.google.api.services.books.model.Volume;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class libraryClient {


    @RequestMapping(value="/isbn/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getBookByIsbn(@PathVariable("id") String id) throws FileNotFoundException {
        getJson json = new getJson();
        List<Item> list = json.readJson("C:\\Users\\komp\\Downloads\\Cognifide - Java Homework 2019 (2)\\books.json");
        for(Item item : list) {

            if (item.getVolumeInfo().getIsbn().equals(id)) {
                item.getVolumeInfo().getIsbn();
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                String json1 = gson.toJson(item.getVolumeInfo());
                return new ResponseEntity<>(json1, HttpStatus.OK);
            }


        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @RequestMapping(value="rating", method = RequestMethod.GET)
    public ResponseEntity<String> getAuthorsRating() throws FileNotFoundException {
        getJson json = new getJson();
        String listOfBooks ="[ \n";
        StringBuilder sB = new StringBuilder(listOfBooks);
        List<Item> list = json.readJson("C:\\Users\\komp\\Downloads\\Cognifide - Java Homework 2019 (2)\\books.json");
        for(Item item : list)
        {
            if(item.getVolumeInfo().getAverageRating()>0.1)
                sB.append(item.getVolumeInfo().toString()+","+ System.lineSeparator());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value="/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getBookByCategory(@PathVariable("id") String id) throws FileNotFoundException {
        getJson json = new getJson();
        String listOfBooks ="[ \n";
        StringBuilder sB = new StringBuilder(listOfBooks);
        List<Item> list = json.readJson("C:\\Users\\komp\\Downloads\\Cognifide - Java Homework 2019 (2)\\books.json");
        for(Item item : list) {
            item.getVolumeInfo().getIsbn();
            List<String> categories = item.getVolumeInfo().getCategories();
            if(categories!=null) {
                for (int i=0;i<categories.size();i++) {
                    System.out.println(categories.get(i));
                    if (categories.get(i).equals(id)){
                        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
                        String json1 = gson.toJson(item.getVolumeInfo());
                        sB.append(json1+","+ System.lineSeparator());
                    }


                }
            }
        }
        sB.append("\n]");
        listOfBooks= sB.toString();
        Gson gson = new Gson();


        return new ResponseEntity<>(listOfBooks, HttpStatus.OK);

    }
}
