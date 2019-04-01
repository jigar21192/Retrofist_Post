package com.example.interview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Base_Adapter1 extends BaseAdapter {
    Context context;
    List<State_Datum> list;
    LayoutInflater inflater;

    public Base_Adapter1(Context context, List<State_Datum> list) {
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


        State_Datum model=list.get(position);
        name.setText(model.getStateName());



        return convertView;
    }
}
