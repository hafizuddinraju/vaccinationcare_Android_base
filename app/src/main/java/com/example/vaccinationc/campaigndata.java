package com.example.vaccinationc;

public class campaigndata {

    String vaccine ,startage, endage, date, price, place;

    public campaigndata(){

    }

    public campaigndata(String vaccine, String startage, String endage, String date, String price, String place) {
        this.vaccine = vaccine;
        this.startage = startage;
        this.endage = endage;
        this.date = date;
        this.price = price;
        this.place = place;
    }



    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getStartage() {
        return startage;
    }

    public void setStartage(String startage) {
        this.startage = startage;
    }

    public String getEndage() {
        return endage;
    }

    public void setEndage(String endage) {
        this.endage = endage;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
