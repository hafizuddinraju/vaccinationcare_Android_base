package com.example.vaccinationc;

public class dataholder {
    String name,course,duration,last;

    public dataholder(String name, String course, String duration ,String last) {
        this.name = name;
        this.course = course;
        this.duration = duration;
        this.last = last;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
