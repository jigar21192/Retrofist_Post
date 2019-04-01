
package com.example.interview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City_Datum {

    @SerializedName("City_ID")
    @Expose
    private String cityID;
    @SerializedName("City_Name")
    @Expose
    private String cityName;

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
