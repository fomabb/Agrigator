package com.kirilyuk.agrigator.dto;

public class FindAllDTO {

    private String title;

    private String info;

    private String category;

    private String image;

    public FindAllDTO(String title, String info, String category, String image) {
        this.title = title;
        this.info = info;
        this.category = category;
        this.image = image;
    }

    public FindAllDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
