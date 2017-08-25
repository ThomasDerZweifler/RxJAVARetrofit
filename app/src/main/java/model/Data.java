package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sachin on 25/8/17.
 */


public class Data
{
    @SerializedName("id")
    private String id;

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("avatar")
    private String avatar;

    public String getId ()
    {
        return id;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public String getLast_name ()
    {
        return last_name;
    }

    public String getAvatar ()
    {
        return avatar;
    }

}

