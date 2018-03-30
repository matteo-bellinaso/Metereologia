package com.example.matteobellinaso.metereologia.data;

import java.io.Serializable;

/**
 * Created by matteobellinaso on 30/03/18.
 */

public class Main implements Serializable {

    private float temp;
    private int humidity;

    public float getTemp(){
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "ForecastOutput{" +
                "temp='" + temp + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
