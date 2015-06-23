package com.staggarlee.javasoundz.models;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;


/**
 * Created by nicolas on 4/11/15.
 */
public class CoffeeShow {

    private static String mLocation;
    private static String mDateStamp;
    private List<Map<String,ArtistSet>> mSetList;
    private String mShowDirectory;


    public CoffeeShow(List<Map<String,ArtistSet>> show, String location) {
        mLocation = location;
        SimpleDateFormat yearMonthDay = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        yearMonthDay.setTimeZone(TimeZone.getDefault());
        mDateStamp = yearMonthDay.format(new Date().getTime() * 1000);
        mSetList = show;

    }

    public static String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public static String getDate() {
        return mDateStamp;
    }

    public void setDate(String year, String month, String day) {
        String yearMonthDay = year + "-" + month + "-" + day;
        mDateStamp = yearMonthDay;
    }

    public ArtistSet getArtistSet(int index){
        return mSetList.get(index).get("Artists");
    }

    // public void addArtistSet(String artist) {
    //    mSetList.put(new ArtistSet(artist));
    // }

    public List<Map<String,ArtistSet>> getSetList() {
        return mSetList;
    }

    public void setSetList(List<Map<String,ArtistSet>> setList) {
        mSetList = setList;
    }


}
