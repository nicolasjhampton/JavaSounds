package com.staggarlee.javasoundz.models;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.staggarlee.javasoundz.recorder.AudioRecorder;

import java.io.File;
import java.io.IOException;

/**
 * Created by nicolas on 4/11/15.
 */
public class SetRecorder {

    private CoffeeShow mShow;
    private String mDirectory = "";
    private AudioRecorder mRecorder;
    private int mTrackNumber;
    private ArtistSet mArtist;
    private int mSetNumber;
    private Context mContext;



    public SetRecorder(Context context, CoffeeShow show) {


        mSetNumber = 0;
        mShow = show;
        mArtist = mShow.getArtistSet(mSetNumber);
        mDirectory = mShow.getLocation();
        mTrackNumber = 0;
        mContext = context;




    }

    public ArtistSet getArtist() {
        return mArtist;
    }

    public void setArtist(ArtistSet artist) {
        mArtist = artist;
    }

    public int getSetNumber() {
        return mSetNumber;
    }

    public void setSetNumber(int setNumber) {
        mSetNumber = setNumber;
    }

    public int getTrackNumber() {
        return mTrackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        mTrackNumber = trackNumber;
    }

    public CoffeeShow getShow() {
        return mShow;
    }

    public void setShow(CoffeeShow show) {
        mShow = show;
    }

    public AudioRecorder getRecorder() {
        return mRecorder;
    }

    public String getDirectory() {
        return mDirectory;
    }

    public void setDirectory() {
        // make the path for the current show location and date
        mDirectory.concat(File.separator + mShow.getDate());
    }

    public void setRecorder() {
        // Update to the current artist set
        mArtist = mShow.getArtistSet(mSetNumber);

        // define the directory path:
        // "environment.musicfolder/venue/date/set#/"
        File dir = new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
                + File.separator
                + getDirectory() + File.separator
                + mShow.getDate() + File.separator
                + (getSetNumber() + 1)));

        // check if the directory is made
        if (!dir.exists()) {
            // if the directory isn't made, make it
            if (dir.mkdirs()) {

            }
        }

        // set the recorder to the directory and file name:
        // "environment.musicfolder/venue/date/set#/track#-artistname.aac"
        mRecorder = AudioRecorder.build(mContext,
                        dir + File.separator
                        + (getTrackNumber() + 1) + "-"
                        + getArtist().getArtist() + ".aac");

    }

    public void nextTrack() {
        // get the next track number, set the recorder for the next track,
        // then seamlessly start the new track
        mTrackNumber++;
        setRecorder();
        startRec();
    }

    public void nextArtist(){

        // increment the set number and set the track to zero
        mSetNumber = mSetNumber + 1;
        mTrackNumber = 0;
        // set the recorder to the next artist
        setRecorder();
    }

    public void pauseRec() {
        mRecorder.pause(new AudioRecorder.OnPauseListener() {
            @Override
            public void onPaused(String activeRecordFileName) {
                // do nothing yet
            }

            @Override
            public void onException(Exception e) {
                Toast.makeText(mContext, "An error has occured:" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void startRec() {
        mRecorder.start(new AudioRecorder.OnStartListener() {
            @Override
            public void onStarted() {
                // started
            }

            @Override
            public void onException(Exception e) {
                // error
                Toast.makeText(mContext, "Unable to start:" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }





   // public void addArtist(String name) {
   //     ArtistSet artist = new ArtistSet(name);
   //     mShow.getSetList().add(artist);
    //
   // }
}
