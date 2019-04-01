package com.example.interview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Base_Adapter2 extends BaseAdapter {
    Context context;
    List<City_Datum> list;
    LayoutInflater inflater;

    public Base_Adapter2(Context context, List<City_Datum> list) {
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);

    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.mylist,null);
        TextView name=convertView.findViewById(R.id.textView);


        City_Datum model=list.get(position);
        name.setText(model.getCityName());



        return convertView;
    }
}
