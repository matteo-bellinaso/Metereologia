package com.example.matteobellinaso.metereologia.utility;

import android.content.Context;

import com.example.matteobellinaso.metereologia.data.City;
import com.example.matteobellinaso.metereologia.data.Singleton;

import java.util.List;

/**
 * Created by matteobellinaso on 30/03/18.
 */

public class DataAccess {


    public static void  initData(Context context){

        City current = new City("Current Position");
        City milano = new City("Milano");
        City piacenza = new City("Piacenza");
        City bologna = new City("Bologna");

        dataAdd(context.getApplicationContext(), current);
        dataAdd(context.getApplicationContext(), milano);
        dataAdd(context.getApplicationContext(),piacenza);
        dataAdd(context.getApplicationContext(),bologna);
    }


    public static void dataAdd(Context context,City city){
        List<City> data = Singleton.getInstance(context.getApplicationContext()).getList();
        data.add(city);
        Singleton.getInstance(context.getApplicationContext()).setItemList(data);
    }

    public static City getIndex(Context context, int position){
        List<City> data = Singleton.getInstance(context.getApplicationContext()).getList();
        return data.get(position);
    }

}
