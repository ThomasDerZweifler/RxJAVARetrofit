package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sachin on 25/8/17.
 */


public class Model
{
    @SerializedName("data")
    private Data data;

    public Data getData ()
    {
        return data;
    }

}


