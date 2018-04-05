package com.example.matteobellinaso.metereologia.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matteobellinaso.metereologia.R;
import com.example.matteobellinaso.metereologia.data.City;
import com.example.matteobellinaso.metereologia.data.Singleton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static android.content.Context.LOCATION_SERVICE;

/**
 * Created by matteobellinaso on 30/03/18.
 */


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private List<City> mData;
        private LayoutInflater mInflater;
        private Context contesto;

        public final static String EXTRA_SELECTED_ITEM = "accademia.lynxspa.com.SELECTED_ITEM";

        public static class ViewHolder extends RecyclerView.ViewHolder {

            private View root;
            private TextView mTextView;
            private ImageView img;

            public ViewHolder(View v) {
                super(v);
                root = v;
                mTextView = v.findViewById(R.id.item_text);
                img = v.findViewById(R.id.item_img);

            }

            public void setOnItemClickCustom(Context context, final int position){

                context = root.getContext();
                final Context finalContext = context;
                root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(finalContext, DetailActivity.class);
                        intent.putExtra(EXTRA_SELECTED_ITEM, position);
                        finalContext.startActivity(intent);
                    }
                });
            }
        }


        public MyAdapter(Context context) {

            contesto = context;
            mData = Singleton.getInstance(context.getApplicationContext()).getList();
            mInflater = LayoutInflater.from(context);
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.item_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String parola = mData.get(position).getName();
            holder.mTextView.setText(parola);
            holder.img.setImageResource(R.drawable.ic_city);

            holder.setOnItemClickCustom(contesto, position);

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }






}


