package com.cognifide.book_library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {


    @Test
    public void VolumeInfo_language_ShouldEquals() {
        Book book= prepareJson();

        List<Item> items =  book.getItems();
        VolumeInfo informations = items.get(1).getVolumeInfo();
        assertEquals("en",informations.getLanguage());
    }
    @Test
    public void volumeInfo_title_ShouldEquals(){
        Book book= prepareJson();

        List<Item> items =  book.getItems();
        VolumeInfo informations = items.get(0).getVolumeInfo();
        assertEquals("A Hypervista of the Java Landscape", informations.getTitle());
    }

    @Test
    public void item_shouldBe2Objects(){
        Book book= prepareJson();

        List<Item> items =  book.getItems();
        assertEquals(2,items.size() );
    }

    public Book prepareJson()
    {
        String file = "{\n" +
                " \"requestedUrl\": \"https://www.googleapis.com/books/v1/volumes?q=java&maxResults=40\",\n" +
                " \"items\": [\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"7tkN1CYzn2cC\",\n" +
                "   \"etag\": \"pfjjxSpetIM\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/7tkN1CYzn2cC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"A Hypervista of the Java Landscape\",\n" +
                "    \"publisher\": \"InfoStrategist.com\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781592432172\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1592432174\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": true,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"1.0.1.0.preview.3\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.pl/books?id=7tkN1CYzn2cC&dq=java&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/A_Hypervista_of_the_Java_Landscape.html?hl=&id=7tkN1CYzn2cC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"PL\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"PL\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.pl/books/download/A_Hypervista_of_the_Java_Landscape-sample-epub.acsm?id=7tkN1CYzn2cC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.pl/books/download/A_Hypervista_of_the_Java_Landscape-sample-pdf.acsm?id=7tkN1CYzn2cC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=7tkN1CYzn2cC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  }, {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"T-Z8HKgIi5EC\",\n" +
                "   \"etag\": \"fDA90EtJH14\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/T-Z8HKgIi5EC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Back Door Java\",\n" +
                "    \"subtitle\": \"State Formation and the Domestic in Working Class Java\",\n" +
                "    \"authors\": [\n" +
                "     \"Janice C. Newberry\"\n" +
                "    ],\n" +
                "    \"publisher\": \"University of Toronto Press\",\n" +
                "    \"publishedDate\": \"2006\",\n" +
                "    \"description\": \"\\\"An important contribution to studies of gender and the state in Southeast Asia, this eminently readable book is at once engaging and profound.\\\" - Mary Steedly, Harvard University\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"1551116898\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9781551116891\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 200,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Social Science\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.0.1.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=T-Z8HKgIi5EC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=T-Z8HKgIi5EC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"en\",\n" +
                "    \"previewLink\": \"http://books.google.pl/books?id=T-Z8HKgIi5EC&printsec=frontcover&dq=java&hl=&cd=40&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.pl/books?id=T-Z8HKgIi5EC&dq=java&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Back_Door_Java.html?hl=&id=T-Z8HKgIi5EC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"PL\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"PL\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=T-Z8HKgIi5EC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   },\n" +
                "   \"searchInfo\": {\n" +
                "    \"textSnippet\": \"&quot;An important contribution to studies of gender and the state in Southeast Asia, this eminently readable book is at once engaging and profound.&quot; - Mary Steedly, Harvard University\"\n" +
                "   }\n" +
                "  }\n" +
                " ]\n" +
                "}";
        Gson gson = new Gson();
        Book book;
        Reader reader = new BufferedReader(new StringReader(file));
        book = gson.fromJson(reader, Book.class);

        return book;

    }
}