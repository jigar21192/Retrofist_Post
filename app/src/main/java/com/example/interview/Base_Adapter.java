package com.example.interview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Base_Adapter extends BaseAdapter {
    private Context context;
    private List<Datum> list;
    private LayoutInflater inflater;

    public Base_Adapter(Context context, List<Datum> list) {
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


        Datum model=list.get(position);
        name.setText(model.getCountryName());



        return convertView;
    }
}
