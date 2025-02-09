package com.example.calorie_counting;

public class User {
    private static User instance;

    private int age;
    private int height;
    private int weight;
    private String gender;
    private String log;
    private String pass;

    public User(int age, int height, int weight, String gender, String log, String pass) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.log = log;
        this.pass = pass;
    }

    public User() {

    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
