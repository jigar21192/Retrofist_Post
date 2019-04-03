package com.example.interview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    Api_Interface api_interface;
    Spinner country,state_spi,city_spi;
    String country_id;
    String sate_id;
    List<Datum> list1=new ArrayList<>();
    List<State_Datum> state;
    List<City_Datum> city_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        country = (Spinner) findViewById(R.id.spinner_country);
        country.setOnItemSelectedListener(this);
        state_spi = (Spinner) findViewById(R.id.spinner_state);
        state_spi.setOnItemSelectedListener(this);
        city_spi = (Spinner) findViewById(R.id.spinner_city);
        city_spi.setOnItemSelectedListener(this);
        api_interface=ApiClient.getClient().create(Api_Interface.class);

        getCountryData();



    }

    private void getStatesData() {
        if (country_id != null) {
            Toast.makeText(this, country_id, Toast.LENGTH_SHORT).show();
            state = new ArrayList<>();
            Call<List<StatesClas>> call = api_interface.getState("GetStates", "727", country_id, "eyviE/IAKm8gJ/kpDUztODmyuMcbHsaBiXBVNx9r1rc=");

            call.enqueue(new Callback<List<StatesClas>>() {
                @Override
                public void onResponse(Call<List<StatesClas>> call, Response<List<StatesClas>> response) {
                    List<StatesClas> states = response.body();


                    for (int i = 0; i < states.size(); i++) {
                        if (states.get(i).getStatus()==true){
                            state = states.get(i).getData();

                        }else {
                            Log.e("State",">>>>>"+"State not found");
                            state.clear();
                            city_data.clear();
                        }
                        Base_Adapter1 adapter1 = new Base_Adapter1(MainActivity.this, state);
                        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        state_spi.setAdapter(adapter1);
                        adapter1.notifyDataSetChanged();




                    }






                }

                @Override
                public void onFailure(Call<List<StatesClas>> call, Throwable t) {

                }
            });
        }else {

            Toast.makeText(this, "country id null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch(parent.getId()){
            case R.id.spinner_country :
                country_id=list1.get(position).getCountryId();

               // Toast.makeText(this, country_id.toString(), Toast.LENGTH_SHORT).show();

                getStatesData();
                getCityData();



                break;
            case R.id.spinner_state :
                sate_id=state.get(position).getStateId();

                getCityData();
                //Your Another Action Here.
                break;
            case R.id.spinner_city :
            //    Toast.makeText(this, , Toast.LENGTH_SHORT).show();
                //Your Another Action Here.
                break;
        }

    }

    private void getCityData() {
        if (sate_id!=null) {
            Toast.makeText(this, sate_id, Toast.LENGTH_SHORT).show();
            city_data = new ArrayList<>();
            Call<List<CityClas>> call = api_interface.getCity("GetCity", "727", sate_id, "NfdICexlA6feO6sNkqzHZA==");

            call.enqueue(new Callback<List<CityClas>>() {
                @Override
                public void onResponse(Call<List<CityClas>> call, Response<List<CityClas>> response) {
                    List<CityClas> cityClas = response.body();


                    for (int i = 0; i < cityClas.size(); i++) {
                       if(cityClas.get(i).getStatus()==true) {
                           Log.e("list", ">>>>>>" + cityClas.get(i).getData());
                           city_data = cityClas.get(i).getData();

                       }else
                       {
                           Log.e("City",">>>>>"+"City not found");
                           city_data.clear();
                       }
                        Base_Adapter2 adapter2 = new Base_Adapter2(MainActivity.this, city_data);
                        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        city_spi.setAdapter(adapter2);


                    }



                }

                @Override
                public void onFailure(Call<List<CityClas>> call, Throwable t) {

                }
            });

        }
        else {
            Toast.makeText(this, "City id null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show();

    }

    private void getCountryData() {
        Call<List<CountryClas>> call=api_interface.getcountry("GetCountry","727","cl1oEntQ32PxZsS3VJnC+H+CY5oLfFLRU5j1H4bg+1g=");

        call.enqueue(new Callback<List<CountryClas>>() {
            @Override
            public void onResponse(Call<List<CountryClas>> call, Response<List<CountryClas>> response) {
                List<CountryClas> list=response.body();
                for (int i=0;i<list.size();i++){
                 //   Log.e("list",">>>>>>"+list.size());
                    list1=list.get(i).getData();


                    Base_Adapter adapter=new Base_Adapter(MainActivity.this,list1);
                    // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    country.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<List<CountryClas>> call, Throwable t) {
                Log.e("Error",">>>>>>"+t.getMessage());
            }
        });
    }


}
