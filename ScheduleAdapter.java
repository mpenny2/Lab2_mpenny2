package com.cs60333.mpenny2.lab2_mpenny2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by michaelpenny on 2/8/17.
 */



public class ScheduleAdapter extends ArrayAdapter<Team> {
    ScheduleAdapter (Context context, ArrayList<Team> schedule) {
        super(context, R.layout.schedule_item, schedule);
    }
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, parent, false);
        Team team = getItem(position);
      //Team team = getItem(position);
        TextView teamName = (TextView) scheduleView.findViewById(R.id.textView6);

        TextView dates = (TextView) scheduleView.findViewById(R.id.textView7);
            teamName.setText(team.getTeamName());
            dates.setText(team.getAbvDate());

        ImageView logo = (ImageView) scheduleView.findViewById(R.id.imageView3);
        String mDrawableName = team.getTeamLogo();
       // Log.d("MyActivity", mDrawableName);
        int resID = getContext().getResources().getIdentifier(mDrawableName, "drawable", getContext().getPackageName());
      // int resID = Integer.parseInt(mDrawableName);

        logo.setImageResource(resID);
        return scheduleView;

    }
}