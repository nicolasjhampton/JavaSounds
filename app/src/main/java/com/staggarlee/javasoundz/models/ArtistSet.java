package com.staggarlee.javasoundz.models;

import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nicolas on 4/11/15.
 */
public class ArtistSet {

    private String mArtist;
    private String mSlideFile;
    private List<Track> mTracks;
    private SimpleDateFormat mSetTimeFormat;
    private SimpleDateFormat mSetTimeFormatPrint;
    private Date mSetTime;


    public ArtistSet (String artist) {

        mArtist = artist;

        mTracks = new ArrayList<Track>();
        //mTracks.set(0, new Track(mArtist));
        // formatting numbers coming in
        mSetTimeFormat = new SimpleDateFormat("Kmmss");
        mSetTimeFormatPrint = new SimpleDateFormat("K:mm:ss");

        mSetTime = null;

    }

    public String getSetTime() {

        if(mSetTime != null) {
            return mSetTimeFormat.format(mSetTime);
        } else {
            return "0000";
        }
    }

    public void setSetTime(String setTime) throws ParseException {
        // take out any spaces
        setTime.trim();


        if(setTime.contains(":")) {
           setTime = setTime.replaceAll(":","");
        }

        // If 5 digits entered and the interpretation is over 2 hours
        if(setTime.length() > 5 || setTime.length() == 0 || Integer.decode(setTime) >= 20000) {
            // The set is too goddamn long, don't let that motherfucker on stage
            throw new ParseException("Time Too Long", 57);
        }

        // If four digits entered
        if(setTime.length() == 4) {
        // Assume input in minutes
            setTime = "0".concat(setTime);
        }

        // If three digits entered
        if (setTime.length() == 3) {
        // Assume input in minutes (In case of poetry open mic)
            setTime = "00".concat(setTime);
        }

        // If 2 digits entered
        if(setTime.length() == 2) {
        // Assume input in minutes
            setTime = "0".concat(setTime);
            setTime = setTime.concat("00");
        }

        // If 1 digit entered
        if(setTime.length() == 1) {
        // Assume input in minutes
            setTime = "00".concat(setTime);
            setTime = setTime.concat("00");
        }



            mSetTime = mSetTimeFormat.parse(setTime);

    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public String getSlideFile() {
        return mSlideFile;
    }

    public void setSlideFile(String slideFile) {
        mSlideFile = slideFile;
    }

    public Track getTrack(int index) {
        return mTracks.get(index);
    }

    public void setTrack() {
        mTracks.add(new Track(getArtist()));
    }

    public List<Track> getTracks() {
        return mTracks;
    }

    public void setTracks(List<Track> tracks) {
        mTracks = tracks;
    }

    @Override
    public String toString() {

        return mArtist + " - " + mSetTimeFormatPrint.format(mSetTime);
    }

}
