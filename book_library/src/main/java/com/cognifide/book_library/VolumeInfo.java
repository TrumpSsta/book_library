package com.cognifide.book_library;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import static ch.qos.logback.core.joran.action.ActionConst.NULL;

public class VolumeInfo {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    private  List<IndustryIdentifier> industryIdentifiers = null;
    private  ReadingModes readingModes;
    private  String printType;
    private  String maturityRating;
    private  Boolean allowAnonLogging;
    private  String contentVersion;
    private  ImageLinks imageLinks;

    @SerializedName("language")
    @Expose
    private String language;
    private  String previewLink;
    private  String infoLink;
    private  String canonicalVolumeLink;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("authors")
    @Expose
    private List<String> authors = null;
    @SerializedName("publishedDate")
    @Expose
    private String publishedDate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("averageRating")
    @Expose
    private double averageRating;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public ReadingModes getReadingModes() {
        return readingModes;
    }

    public void setReadingModes(ReadingModes readingModes) {
        this.readingModes = readingModes;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public Boolean getAllowAnonLogging() {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging(Boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    public String getIsbn(Item item ){
        List <IndustryIdentifier> isbn = industryIdentifiers;



        if(isbn.get(0).getType().contentEquals("ISBN_13"))return isbn.get(0).getIdentifier();
            else if(isbn.size()>1) {
            if (isbn.get(1).getType().contentEquals("ISBN_13"))
                return isbn.get(1).getIdentifier();

        }
        if(isbn.get(0).getType()!="ISBN_13" && isbn.get(0).getType()!="ISBN_10")
            return item.getId();
        else return "1";
    }

   // @Override
   // public String toString() {
    //    List <IndustryIdentifier> isbn = getIndustryIdentifiers();
     //   if(subtitle==null)
     //       return new ToStringBuilder(this).append("isbn", getIsbn()).append("title", title).append("publisher", publisher).append("publishedDate",publishedDate).append("pageCount",pageCount).append("thumbnailUrl",getImageLinks().getThumbnail()).append("language", language).append("previewLink", previewLink).append("averageRating",averageRating).append("authors", authors).append("categories", categories).toString();
       // else return new ToStringBuilder(this).append("isbn", getIsbn()).append("title", title).append("subtitle",subtitle).append("publisher", publisher).append("publishedDate",publishedDate).append("description", StringUtils.substringBefore(description,".")).append("pageCount",pageCount).append("thumbnailUrl",getImageLinks().getThumbnail()).append("language", language).append("previewLink", previewLink).append("averageRating",averageRating).append("authors", authors).append("categories", categories).toString();

   // }
}
