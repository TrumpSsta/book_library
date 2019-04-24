package com.cognifide.book_library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileNotFoundException;
import java.util.*;

public class ControllerMethods {
    //return json as string, for given isbn number
    public String getbookByIsbnNumber(GetJson json, String id ) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        List<Item> list = json.readJson(json.getJsonFile());
        String json1;
        for(Item item : list) {

            if (item.getVolumeInfo().getIsbn().equals(id)) {
                item.getVolumeInfo().getIsbn();

                json1 = gson.toJson(item.getVolumeInfo());
                return json1;
            }else if (item.getVolumeInfo().getIsbn().equals("0")) {
                item.getVolumeInfo().setIsbn13(item.getId());
                if (item.getVolumeInfo().getIsbn13().equals(id)) {
                    json1 = gson.toJson(item.getVolumeInfo());
                    return  json1;
                }
            }


        }


        return "0";
    }
    //return json as String, for given category
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
    //return authors with ratings
    public String getAuthorsWithRatings(GetJson json) throws FileNotFoundException {
        List<String>authors = getAuthors(json);
        String listOfBooks ="[ \n";
        Map<String,Double> authorWithRating = new HashMap<>();
        StringBuilder sB = new StringBuilder(listOfBooks);
        List<Item> list = json.readJson(json.getJsonFile());
        for(String author : authors) {
            double rating=0.0;
            int counter=0;
            for(Item item : list) {
                if (item.getVolumeInfo().getAuthors() != null) {
                    for (String name : item.getVolumeInfo().getAuthors()) {
                        if (name.equals(author)&&!Double.isNaN(item.getVolumeInfo().getAverageRating())) {

                                rating+=item.getVolumeInfo().getAverageRating();
                                counter++;
                            }

                    }

                }
            }

            if(counter>0&&(rating=rating/counter)>0) {
                authorWithRating.put(author,rating);


            }
        }

        LinkedHashMap<String, Double> reverseSortedMap = new LinkedHashMap<>();
        authorWithRating.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        for (Map.Entry<String,Double> pair : reverseSortedMap.entrySet()) {
            sB.append("  {  \n    \"author\": \"" + pair.getKey() + "\"," + System.lineSeparator());
            sB.append("  {  \n    \"averageRating\": " + pair.getValue() + System.lineSeparator() + "  }," + System.lineSeparator());
        }
        sB.append("]");
        listOfBooks= sB.toString();
        return listOfBooks;

    }
    //return list of authors
    public List<String> getAuthors (GetJson json) throws FileNotFoundException {

        List<String>authors = new LinkedList<>();
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
    //check author is already on list
    public boolean checkAuthorsList(List<String> authors, String name){
        for(String author :authors)
        {
            if(author==name)return true;
        }
        return false;
    }
}
