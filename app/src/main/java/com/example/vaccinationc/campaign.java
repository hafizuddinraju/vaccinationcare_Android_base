package com.example.vaccinationc;

public class campaign {

    String vaccine ,startage, endage, date, price, place;

    public campaign(String vaccine, String startage, String endage, String date, String price, String place) {
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

    public String getStartage() {
        return startage;
    }

    public String getEndage() {
        return endage;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public String getPlace() {
        return place;
    }
}
