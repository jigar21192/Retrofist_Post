
package com.example.interview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class State_Datum {

    @SerializedName("State_Id")
    @Expose
    private String stateId;
    @SerializedName("State_Name")
    @Expose
    private String stateName;

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

}
