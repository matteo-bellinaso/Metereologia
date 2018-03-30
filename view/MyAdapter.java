package com.example.matteobellinaso.metereologia.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matteobellinaso.metereologia.R;

import java.util.Random;

/**
 * Created by matteobellinaso on 30/03/18.
 */


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private String[] mData;
        private LayoutInflater mInflater;
        private int colore;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            private TextView mTextView;
            private ImageView img;

            public ViewHolder(View v) {
                super(v);
                mTextView = v.findViewById(R.id.item_text);
                img = v.findViewById(R.id.item_img);
            }
        }


        public MyAdapter(Context context, String[] myDataset) {
            mData = myDataset;
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
            String parola = mData[position];
            holder.mTextView.setText(parola);
            holder.img.setImageDrawable(R.drawable.ic_city);

        }

        @Override
        public int getItemCount() {
            return mData.length;
        }
    }


