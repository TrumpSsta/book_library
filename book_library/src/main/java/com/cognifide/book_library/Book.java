package com.cognifide.book_library;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Book {

    @SerializedName("requestedUrl")
    @Expose
    private String requestedUrl;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getRequestedUrl() {
        return requestedUrl;
    }

    public void setRequestedUrl(String requestedUrl) {
        this.requestedUrl = requestedUrl;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("requestedUrl", requestedUrl).append("items", items).toString();
    }
}
