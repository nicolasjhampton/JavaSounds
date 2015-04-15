package com.staggarlee.javasoundz.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.staggarlee.javasoundz.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.venueName) EditText mLocation;
    @InjectView(R.id.startButton) Button mStart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        final String locationLabel = getString(R.string.location);


        final Intent intent = new Intent(MainActivity.this, CreateSetActivity.class);


        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = mLocation.getText().toString();
                intent.putExtra(locationLabel, location);
                startActivity(intent);
            }
        });


    }



}
