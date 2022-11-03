package com.example.demo;

public class User {
    String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "cityname='" + city + '\'' +
                '}';
    }
}
