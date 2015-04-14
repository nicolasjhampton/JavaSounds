package com.staggarlee.javasoundz.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.staggarlee.javasoundz.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecordingActivity extends ActionBarActivity {

    @InjectView(R.id.setTimeLeft) TextView mSetTimeLeft;
    @InjectView(R.id.artistImage) ImageView mArtistImageButton;
    @InjectView(R.id.nextArtistButton) Button mNextArtistButton;
    @InjectView(R.id.artistListView) ListView mArtistListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);

        ButterKnife.inject(this);


    }







}
