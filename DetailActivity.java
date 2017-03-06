package com.cs60333.mpenny2.lab2_mpenny2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by michaelpenny on 2/19/17.
 */

public class DetailActivity extends Activity {
    @Override

    public void onCreate (Bundle bundle) {

        super.onCreate(bundle);

        setContentView(R.layout.activity_detail);
        TextView oppName = (TextView) findViewById(R.id.oppName);
        TextView oppRecord = (TextView) findViewById(R.id.oppRecord);
        TextView score = (TextView) findViewById(R.id.score);
        TextView location = (TextView) findViewById(R.id.location);
        TextView date = (TextView) findViewById(R.id.Date);
        ImageView oppImage = (ImageView) findViewById(R.id.oppImage);
        ImageView ndImage = (ImageView) findViewById(R.id.ndImage);
        bundle = getIntent().getExtras();
        Team team = (Team) bundle.getSerializable("info");



        oppName.setText(team.getTeamName());
        date.setText(team.getLongDate());
        location.setText(team.getStadium());
        oppRecord.setText(team.getRecord());
        score.setText(team.getScore());

        String mDrawableName = team.getTeamLogo();
        Log.d("MyActivity", mDrawableName);
        int resID = getApplicationContext().getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
//int resID = Integer.parseInt(mDrawableName);

        oppImage.setImageResource(resID);
        mDrawableName = "i";
        Log.d("MyActivity", mDrawableName);
        resID = getApplicationContext().getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
        ndImage.setImageResource(resID);
        Button camStart = (Button) findViewById(R.id.camera);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            }
        };
        camStart.setOnClickListener(clickListener);
    }
//initialize all the widgets of your layout file here.

    }



