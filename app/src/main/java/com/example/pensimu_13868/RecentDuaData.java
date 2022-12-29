package com.example.pensimu_13868;

public class RecentDuaData {

    String konserName;
    String placeName;
    String price;
    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }


    public RecentDuaData(String konserName, String placeName, String price, Integer imageUrl) {
        this.konserName = konserName;
        this.placeName = placeName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getKonserName() {
        return konserName;
    }

    public void setKonserName(String konserName) {
        this.konserName = konserName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
