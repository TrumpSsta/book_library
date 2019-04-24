package com.cognifide.book_library;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;




@RestController
public class LibraryClient {

    GetJson json = new GetJson();
    @PostConstruct
    public void initialize() {
    json.selectFile();
    }
    //Metoda GET, zwracająca książke o danym numerze isbn
    @GetMapping(value="/isbn/{id}")
    public ResponseEntity<String> getBookByIsbn(@PathVariable("id") String id) throws FileNotFoundException {
        ControllerMethods methods = new ControllerMethods();
        String json1= methods.getbookByIsbnNumber(json,id);

        if(json1!="0")
            return new ResponseEntity<>(json1, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);



    }
    //metoda zwracająca rating --work in progress
    @GetMapping(value="/rating")
    public ResponseEntity<String> getAuthorsRating() throws FileNotFoundException {
        ControllerMethods methods = new ControllerMethods();
        String returnableValue=methods.getAuthorsWithRatings(json);
        return new ResponseEntity<>(returnableValue, HttpStatus.OK);
    }

    //metoda GET zwracająca książki dla danej kategorii
    @GetMapping(value="/category/{id}")
    public ResponseEntity<String> getBookByCategory(@PathVariable("id") String id) throws FileNotFoundException {
        ControllerMethods methods = new ControllerMethods();
        String returnableValue = methods.getbookByCategoryName(json,id);
        if(returnableValue.length()<10)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(returnableValue, HttpStatus.OK);

    }

}