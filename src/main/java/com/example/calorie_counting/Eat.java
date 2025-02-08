package com.example.calorie_counting;

import java.time.LocalDate;
import java.sql.Date;

public class Eat {
    private int iduser;
    private String eat;
    private int calories;
    private Date date;

    public Eat(int iduser, String eat, int calories) {
        this.iduser = iduser;
        this.eat = eat;
        this.calories = calories;
        date = Date.valueOf(LocalDate.now());
    }

    public Eat() {

    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    public void sumCalories(int calories){
        this.calories += calories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
