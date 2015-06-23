package com.staggarlee.javasoundz.ui;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.staggarlee.javasoundz.R;
import com.staggarlee.javasoundz.models.SetRecorder;

import java.io.IOException;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecordingActivity extends ActionBarActivity {


    @InjectView(R.id.artistImage) ImageView mArtistImage;
    @InjectView(R.id.nextArtistButton) Button mNextArtistButton;
    @InjectView(R.id.artistListView) ListView mArtistListView;


    @InjectView(R.id.pauseRecButton) Button mPauseRecButton;
    @InjectView(R.id.newTrackButton) Button mNewTrackButton;
    @InjectView(R.id.setTimeLeft) TextView mSetTimeLeft;
    @InjectView(R.id.currentArtistText) TextView mCurrentArtist;
    @InjectView(R.id.trackNumberText) TextView mTrackNumberText;
    @InjectView(R.id.trackTimeText) TextView mTrackTimeText;
    private long trackEndTime;
    private long timeElapsed = 0;
    private boolean startOfTrack = true;
    private SimpleAdapter simpleAdpt;
    private SetRecorder mRecorder;
    private CountDownTimer trackTime = new CountDownTimer(1200000, 1000) {
        @Override
        public void onTick(long millUntilFinished) {
            if(startOfTrack) {
                startOfTrack = false;
                trackEndTime = millUntilFinished;
                timeElapsed = 0;
            } else {
                // Take this count and subtract any other time elapsed, then get the new time elapsed
                timeElapsed = (trackEndTime - (millUntilFinished - timeElapsed));
            }

            // display the time elapsed
            mTrackTimeText.setText(String.valueOf((timeElapsed) / 1000));
        }

        @Override
        public void onFinish() {
            // if we're starting a new track, set time elapsed to 0
            if(startOfTrack) {
                mTrackTimeText.setText("0");
            }
            // else do nothing
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);

        ButterKnife.inject(this);

        // Set the show to the SetRecorder
        mRecorder = new SetRecorder(this, CreateSetActivity.currentShow);
        mRecorder.setRecorder();


        // Creating our new simple adapter
        simpleAdpt = new SimpleAdapter(RecordingActivity.this,
                mRecorder.getShow().getSetList(), android.R.layout.simple_list_item_1,
                new String[] {getString(R.string.artists_label)},
                new int[] {android.R.id.text1});


        // Set the listView of the show
        mArtistListView.setAdapter(simpleAdpt);
        mCurrentArtist.setText(mRecorder.getArtist().getArtist());
        //mCurrentArtist.setText(CreateSetActivity.currentShow
        //                       .getArtistSet(mRecorder.getSetNumber())
        //                       .getArtist());
        mTrackNumberText.setText("Track " + Integer.toString(mRecorder.getTrackNumber() + 1));
        // mTrackTimeText.setText();


        mNextArtistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startOfTrack = true;
                mRecorder.nextArtist();
                mCurrentArtist.setText(mRecorder.getArtist().getArtist());
                mPauseRecButton.setText("Start");
                mTrackNumberText.setText("Track " + Integer.toString(mRecorder.getTrackNumber() + 1));
                trackTime.cancel();
                mTrackTimeText.setText("0");

            }
        });

        mNewTrackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startOfTrack = true;
                mRecorder.nextTrack();
                mTrackNumberText.setText("Track " + Integer.toString(mRecorder.getTrackNumber() + 1));
                trackTime.cancel();
                trackTime.start();

            }
        });

        mPauseRecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // determine if we are currently recording
                if (mRecorder.getRecorder().isRecording()) {
                    /* If we are recording...
                    * 1. Toggle the recording to off
                    * 2. Set the text on the P/R button to REC
                    * 3. Run the onFinish method on the trackTime CountdownTimer
                    */
                    mRecorder.pauseRec();
                    mPauseRecButton.setText("REC");
                    trackTime.cancel();



                } else {
                    /* If we aren't recording...
                    * 1. Toggle the recording to on
                    * 2. Set the text on the P/R button to PAUSE
                    * 3. Run the onFinish method on the trackTime CountdownTimer
                    */
                    mRecorder.startRec();
                    mPauseRecButton.setText("PAUSE");
                    trackTime.start();

                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();






    }
}
