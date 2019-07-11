package com.example.list;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.list.R;

public class ItemAdapter extends BaseAdapter {
    String[] items, prices, descr;
    LayoutInflater mInflater;

    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
        items = i;
        prices = p;
        descr = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return items.length;
    }

    @Override
    public Object getItem(int i){
        return items[i];
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = v.findViewById(R.id.nameTextView);
        TextView descrTextView = v.findViewById(R.id.descTextView);
        TextView priceTextView = v.findViewById(R.id.priceTextView);

        String name = items[i];
        String desc = descr[i];
        String cost = prices[i];

        nameTextView.setText(name);
        descrTextView.setText(desc);
        priceTextView.setText(cost);
        return v;
    }
}
