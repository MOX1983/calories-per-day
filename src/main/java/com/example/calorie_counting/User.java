package com.example.calorie_counting;

public class User {
    private String age;
    private String height;
    private String weight;
    private String gender;
    private String log;
    private String pass;

    public User(String age, String height, String weight, String gender, String log, String pass) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.log = log;
        this.pass = pass;
    }

    public User() {

    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
