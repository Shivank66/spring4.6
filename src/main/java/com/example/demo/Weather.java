package com.example.demo;

public class Weather {

    Object coord;
    Object main;
    Object sys;
    Object weather[];
    String name;
Weather()
{
weather=null;
    coord=null;
    main=null;
    sys=null;
    name="";

}



    public void setLog(Object coord) {
        this.coord = coord;
    }

    public void setTemp_min(Object main) {
        this.main = main;
    }

    public void setSys(Object sys) {
        this.sys=sys;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Object getWeather() {
        return weather;
    }

    public void getWeather(String[] weather) {
        this.weather = weather;
    }

    Weather(Object coord, Object main, Object sys, String name, Object weather[])
{
this.weather=weather;
    this.coord=coord;
    this.main=main;
    this.sys=sys;
    this.name=name;

}



    public Object getCoord() {
        return coord;
    }

    public Object getMain() {
        return main;
    }

    public Object getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }


}
