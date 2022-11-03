package com.example.demo;

import com.google.gson.Gson;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.lang.constant.Constable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@Controller
@ResponseBody
public class firstcontroller {


    @RequestMapping("/test")
    public String start() {
        return "My first one";
    }

    @GetMapping("/bookdetails")
    public Book func() {
        //String bookname,String subject,String author,int price
        Book b = new Book("My Experiments", "Human Life", "MKG", 1000);

        return b;
    }

    @GetMapping("/variables")
    public String values(@RequestParam(name = "State") String rajya, @RequestParam(name = "Capital") String rajdhani) {
        return rajya + " ----> " + rajdhani;
    }

    @GetMapping("/learndefault")
    public String defaultvalues(@RequestParam(name = "State", defaultValue = "UP") String rajya, @RequestParam(name = "Capital") String rajdhani) {

        return rajya + " ----> " + rajdhani;

    }

    @GetMapping("/jsonwa")
    public Object funct(@RequestParam(name="City",defaultValue = "Varanasi")String c) throws Exception {
        Gson g = new Gson();
        URL u = new URL("https://api.openweathermap.org/data/2.5/weather?q="+c+"&appid=4a1f8a61b74546825af1e0be106e797b&units=metric");
        URLConnection connect = u.openConnection();
        StringBuilder s = new StringBuilder();
        Scanner sc = new Scanner(connect.getInputStream());
        while (sc.hasNextLine())
            s.append(sc.nextLine());

        // Book b=new Book(); spring 4.6

String h=s+"";
Weather weat=g.fromJson(h,Weather.class);
        return weat;// g.toJson(h);

        //return h;
    }
    @GetMapping("/weather")
    public Weather functi()
    { //String lat, String log, String temp_min, String temp_max, String name, String country
        Weather w=new Weather();
        return w;

    }
    @GetMapping("/city")
    public void city_(@RequestParam(name="city")String cityname) throws Exception {
        funct(cityname);
    }
    @RequestMapping("/lets")
    public ModelAndView lets(@RequestParam (name="city",defaultValue = "Varanasi")String city) throws Exception {

        ModelAndView m=new ModelAndView();
        m.setViewName("index.html");
        m.addObject("city1",city);
        Object all_details=funct(city);

       // System.out.println(t);
        //String h=t.toString();
        m.addObject("sys",all_details);

         return m;
    }

    @GetMapping("/view")
    public ModelAndView c(@RequestParam(name="city") String city)
    {
       ModelAndView m=new ModelAndView();
       m.setViewName("data.html");
       return m;
    }
@GetMapping("/latitudewa")
    public Object latlong(@RequestParam(name="Latitude", defaultValue = "25.3333")String lat,@RequestParam(name="Longitude",defaultValue = "83.0")String lon) throws IOException {
        Gson g=new Gson();
        URL u=new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=9c12fb310fd215ae354e8b41b7126479&lang=en&units=metric"
);
        URLConnection con= u.openConnection();
        StringBuilder s = new StringBuilder();
        Scanner sc = new Scanner(con.getInputStream());
        while (sc.hasNextLine())
            s.append(sc.nextLine());
        String h1=s+"";

        Weather an=g.fromJson(h1,Weather.class);

        return an;

    }

    @RequestMapping("/lati")
    public ModelAndView lati(@RequestParam(name="lat", defaultValue = "25.3333")String lat,@RequestParam(name="lon",defaultValue = "83.0")String lon) throws IOException {

        ModelAndView m=new ModelAndView();
        m.setViewName("second.html");
        Object t1=latlong(lat,lon);

        m.addObject("sys",t1);
        m.addObject("lat",lat);
        m.addObject("lon",lon);
       // m.addObject("lat",lat);
        return m;

    }



}
