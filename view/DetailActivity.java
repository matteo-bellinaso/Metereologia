package com.example.matteobellinaso.metereologia.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.example.matteobellinaso.metereologia.R;
import com.example.matteobellinaso.metereologia.data.City;
import com.example.matteobellinaso.metereologia.data.Singleton;
import com.example.matteobellinaso.metereologia.data.Weather;
import com.example.matteobellinaso.metereologia.utility.DataAccess;
import com.example.matteobellinaso.metereologia.utility.GsonRequest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by matteobellinaso on 30/03/18.
 */

public class DetailActivity extends Activity {

    private String currentItem;
    private String preferito;

     TextView textCity;

     TextView textMain;
     TextView textDesc;
     TextView textTemp;
     TextView textHum;
     ImageView textImg;

   @Override
    protected void onCreate(Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       Date date = Calendar.getInstance().getTime();
       DateFormat format = new SimpleDateFormat("hh:mm");
       final String today = format.format(date);



        Intent intent = getIntent();
        final int selectedItem = intent.getIntExtra(MainActivity.EXTRA_SELECTED_ITEM , 0);

       if(selectedItem == 0){
           currentItem = getCurrentCityName(this);
       }else{
           currentItem = DataAccess.getIndex(this, selectedItem).getName();
       }





        String url = "http://api.openweathermap.org/data/2.5/weather?q=" +currentItem + "&units=metric&appid=2439d518e81cee90fd7a61cfe1109dd4";

        textCity = (TextView) findViewById(R.id.text_city);
        textMain = (TextView) findViewById(R.id.text_main);
        textDesc = (TextView) findViewById(R.id.text_desc);
        textHum = (TextView) findViewById(R.id.text_hum);
        textTemp = (TextView) findViewById(R.id.text_temp);
        textImg = (ImageView) findViewById(R.id.text_img);




        textCity.setText(currentItem);

       GsonRequest jsonObjectReq = new GsonRequest( url, City.class,null , new Response.Listener<City>() {
           @Override
           public void onResponse(City response) {
               textMain.setText(response.getWeather().get(0).getMain());
               textDesc.setText( response.getWeather().get(0).getDescription());
               textTemp.setText("" + response.getMain().getTemp()+ "°");
               textHum.setText(today);
               String icon = response.getWeather().get(0).getIcon();

               switch(icon){
                   case "50d":
                       textImg.setImageDrawable(getResources().getDrawable(R.drawable.rain_cloud_icon));
                       break;
                   case "02d":
                       textImg.setImageDrawable(getResources().getDrawable(R.drawable.sun_and_rain_icon));
                       break;
                   case "10d":
                       textImg.setImageDrawable(getResources().getDrawable(R.drawable.sun));
                       break;

               }
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               VolleyLog.d("VOLLEY", "Error: " + error.getMessage());
                }
       });

      Singleton.getInstance(this).addToRequestQueue(jsonObjectReq);



   }


    public static String getCurrentCityName(Context context){
        LocationManager locationManager=(LocationManager)context.getSystemService(LOCATION_SERVICE);
        Criteria criteria=new Criteria();

        locationManager.getBestProvider(criteria, true);

        @SuppressLint("MissingPermission") Location location= locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria,true));

        Geocoder gcd=new Geocoder(context, Locale.getDefault());
        List<Address> addresses;
        String cityName = "";
        try {
            addresses=gcd.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            if(addresses.size()>0){
                cityName = addresses.get(0).getLocality().toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityName;
    }


}
