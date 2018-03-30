package com.example.matteobellinaso.metereologia.data;

import java.io.Serializable;

/**
 * Created by matteobellinaso on 30/03/18.
 */

public class Weather implements Serializable {

    private String main;
    private String description;
    private String icon;

    public String getMain(){
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon){this.icon = icon;}

    public String getIcon(){return icon;}

    @Override
    public String toString() {
        return "ForecastOutput{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
