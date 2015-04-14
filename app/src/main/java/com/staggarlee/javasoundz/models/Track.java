package com.staggarlee.javasoundz.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by nicolas on 4/11/15.
 */
public class Track {




    // We're going to work in Ogg Vorbis and use MediaPlayer,
    // so there's no need to define the codec and bitrate here,
    // since it will be fixed.

    private Date mTime;
    private String mArtist;

    // Constructor
    public Track(String artist) {
        mArtist = artist;
        mTime = new Date();
    }


    @Override
    public String toString() {

        SimpleDateFormat militaryTime = new SimpleDateFormat("hh:mm");
        militaryTime.setTimeZone(TimeZone.getDefault());
        String timeStamp = militaryTime.format(mTime.getTime() * 1000);
        return mArtist + "-" + timeStamp + ".ogg";
    }




}
