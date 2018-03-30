package com.example.matteobellinaso.metereologia.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by matteobellinaso on 30/03/18.
 */

public class City implements Serializable {

    private String name;
    private String id;
    private List<Weather> weather;
    private Main main;

    public City(String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMain(Main main){
        this.main = main;
    }
    public Main getMain(){
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherOutput{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weather=" + weather +
                '}';
    }

}
