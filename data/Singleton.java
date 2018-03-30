package com.example.matteobellinaso.metereologia.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matteobellinaso on 30/03/18.
 */

public class Singleton {

    private List<City> list;
    private RequestQueue mRequestQueue;
    private  static Context mCtx;

    private static Singleton ourInstance = new Singleton();

    private Singleton() {
        this.list = new ArrayList<City>();
    }

    public static Singleton getInstance(Context context) {
        mCtx = context.getApplicationContext();
        return ourInstance;
    }

    public void  setItemList(List<City> list){// devo dichiarare cosa gli passo
        this.list = list;
    }

    public  List<City> getList(){
        return list;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue =  Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
