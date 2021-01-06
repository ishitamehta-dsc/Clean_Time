package com.example.cleantime.model;

public class MyRequestModel {

    private int imageUrl;
    private String carWashName;
    private String carName;
    private String date;
    private String price;


    public MyRequestModel(int imageUrl, String carWashName, String carName, String date, String price) {
        this.imageUrl = imageUrl;
        this.carWashName = carWashName;
        this.carName = carName;
        this.date = date;
        this.price = price;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCarWashName() {
        return carWashName;
    }

    public void setCarWashName(String carWashName) {
        this.carWashName = carWashName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
