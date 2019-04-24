package com.cognifide.book_library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;

import java.util.List;


@RestController
public class LibraryClient {

    GetJson json = new GetJson();
    @PostConstruct
    public void initialize() {
    json.selectFile();
    }
    //Metoda GET, zwracająca książke o danym numerze isbn
    @RequestMapping(value="/isbn/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getBookByIsbn(@PathVariable("id") String id) throws FileNotFoundException {
        ControllerMethods methods = new ControllerMethods();
        String json1= methods.getbookByIsbnNumber(json,id);

        if(json1!="0")
            return new ResponseEntity<>(json1, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);



    }
    //metoda zwracająca rating --work in progress
    @RequestMapping(value="/rating", method = RequestMethod.GET)
    public ResponseEntity<String> getAuthorsRating() throws FileNotFoundException {
        ControllerMethods methods = new ControllerMethods();
        String returnableValue=methods.getAuthorsWithRatings(json);
        return new ResponseEntity<>(returnableValue, HttpStatus.OK);
    }

    //metoda GET zwracająca książki dla danej kategorii
    @RequestMapping(value="/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getBookByCategory(@PathVariable("id") String id) throws FileNotFoundException {
        ControllerMethods methods = new ControllerMethods();
        String returnableValue = methods.getbookByCategoryName(json,id);
        if(returnableValue.length()<10)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(returnableValue, HttpStatus.OK);

    }

}
