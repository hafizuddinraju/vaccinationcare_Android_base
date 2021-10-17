package com.example.vaccinationc;

public class uservaccine {

    String name,startdate,dose,price,place;

    public uservaccine(String name, String startdate, String dose, String price, String place) {
        this.name = name;
        this.startdate = startdate;
        this.dose = dose;
        this.price = price;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
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
