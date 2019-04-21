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
    public String getFromIsbn(@PathVariable("id") String id) throws FileNotFoundException {
        getJson json = new getJson();
        Item returnableItem= new Item();
        List<Item> list = json.readJson("/home/jedrzej/Documents/books.json");
        for(Item item : list) {

            if (item.getVolumeInfo().getIsbn().equals(id))
               returnableItem= item;

        }
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json1 = gson.toJson(returnableItem.getVolumeInfo());
        return  json1;
    }
}
