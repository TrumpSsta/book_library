package com.cognifide.book_library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class ControllerMethods {

    public String getbookByIsbnNumber(GetJson json, String id ) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        List<Item> list = json.readJson(json.getJsonFile());
        for(Item item : list) {

            if (item.getVolumeInfo().getIsbn().equals(id)) {
                item.getVolumeInfo().getIsbn();

                String json1 = gson.toJson(item.getVolumeInfo());
                return json1;
            }else if (item.getVolumeInfo().getIsbn().equals("0")) {
                item.getVolumeInfo().setIsbn13(item.getId());
                if (item.getVolumeInfo().getIsbn13().equals(id)) {
                    String json1 = gson.toJson(item.getVolumeInfo());
                    return  json1;
                }
            }


        }


        return "0";
    }

    public String getbookByCategoryName(GetJson json, String id) throws FileNotFoundException {
        String listOfBooks ="[ \n";
        StringBuilder sB = new StringBuilder(listOfBooks);
        List<Item> list = json.readJson(json.getJsonFile());
        for(Item item : list) {
            item.getVolumeInfo().getIsbn();
            if (item.getVolumeInfo().getIsbn().equals("0"))
                item.getVolumeInfo().setIsbn13(item.getId());
            List<String> categories = item.getVolumeInfo().getCategories();
            if(categories!=null) {
                for (int i=0;i<categories.size();i++) {
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
        return listOfBooks;

    }

    public String getAuthorsWithRatings(GetJson json) throws FileNotFoundException {
        List<String>authors = getAuthors(json);
        String listOfBooks ="[ \n";
        StringBuilder sB = new StringBuilder(listOfBooks);
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        List<Item> list = json.readJson(json.getJsonFile());
        for(String author : authors) {
            double rating=0.0;
            int counter=0;
            for(Item item : list) {
                if (item.getVolumeInfo().getAuthors() != null) {
                    for (String name : item.getVolumeInfo().getAuthors()) {
                        if (name.equals(author)) {
                            if(!Double.isNaN(item.getVolumeInfo().getAverageRating())) {

                                rating+=item.getVolumeInfo().getAverageRating();
                                counter++;
                            }
                        }
                    }

                }
            }

            if((rating=rating/counter)>0) {
                sB.append("  {  \n    \"author\": \"" + author + "\"," + System.lineSeparator());
                sB.append("  {  \n    \"averageRating\": " + rating + System.lineSeparator() + "  }," + System.lineSeparator());

            }
        }
        sB.append("]");
        listOfBooks= sB.toString();
        return listOfBooks;

    }
    public List<String> getAuthors (GetJson json) throws FileNotFoundException {

        List<String>authors = new LinkedList<String>();
        List<Item> list = json.readJson(json.getJsonFile());
        for(Item item : list) {
            if(item.getVolumeInfo().getAuthors()!=null) {
                for (String name : item.getVolumeInfo().getAuthors()) {
                    if (!checkAuthorsList(authors, name))
                        authors.add(name);
                }
            }
        }
        return authors;
    }
    public boolean checkAuthorsList(List<String> authors, String name){
        for(String author :authors)
        {
            if(author==name)return true;
        }
        return false;
    }
}
