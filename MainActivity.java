package com.cs60333.mpenny2.lab2_mpenny2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;


import java.util.ArrayList;

import static com.cs60333.mpenny2.lab2_mpenny2.R.id.scheduleListView;
import static com.cs60333.mpenny2.lab2_mpenny2.R.id.toolbar;

public class MainActivity extends AppCompatActivity {
    public String gameSchedule() {
        Toolbar actionBarToolbar = (Toolbar) findViewById(toolbar);
        setSupportActionBar(actionBarToolbar);
        MyCsvFileReader reader = new MyCsvFileReader(getApplicationContext());
        final ArrayList<Team> info = reader.readCsvFile(R.raw.schedule);
        StringBuilder schedule = new StringBuilder();
        for (Team i : info) {
            schedule.append(i.getTeamName() + i.getLongDate() + i.getStadium() + "\n");
        }
        String fullSchedule = schedule.toString();
        return fullSchedule;
    }

    ArrayList<Team> info = new ArrayList<Team>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String[] teams = {"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech","North Virginia", "Chicago State"};
        //  String[] dates = {"Feb. 11", "Feb.14" ,"Feb.18", "Feb. 26", "Mar. 1", "Mar. 4", "Mar. 7", "Mar. 16"};

        /*String[] osu = {Integer.toString(R.drawable.osu), "Ohio State", "Feb, 11", "Saturday, February 11", "Purcell Pavilion, Notre Dame, IN", "72-64", "21-9"};
        String[] fsu = {Integer.toString(R.drawable.fsu), "Florida State", "Feb, 14", "Tuesday, February 14", "Donald Tucker Civic Center, Tallahassee, FL", "80-69", "22-5"};
        String[] wf = {Integer.toString(R.drawable.wf), "Wake Forest", "Feb, 18", "Saturday, February 18", "Purcell Pavilion, Notre Dame, IN", "67-54", "15-12"};
        String[] bc = {Integer.toString(R.drawable.bc), "Boston College", "Feb, 26", "Sunday, February 26", "Conte Forum, Boston, MA", "58-63", "20-10"};
        String[] ncsu = {Integer.toString(R.drawable.ncsu), "North Carolina State", "Mar. 1", "Wednesday, March 1", "Purcell Pavilion, Notre Dame, IN", "62-68", "17-11"};
        String[] gt = {Integer.toString(R.drawable.gt), "Georgia Tech", "Mar. 4", "Saturday, March 4", "Purcell Pavilion, Notre Dame, IN", "70-59", "19-9"};
        String[] nv = {Integer.toString(R.drawable.nova), "North Virginia", "Mar. 7", "Tuesday, March 7", "Purcell Pavilion, Notre Dame, IN", "82-50", "9-20"};
        String[] cs = {Integer.toString(R.drawable.chicagost), "Chicago State", "Mar. 17", "Friday, March 17", "Purcell Pavilion, Notre Dame, IN", "95-51", "5-19"};*/

        //  ArrayList<String[]> info = new ArrayList();
        /*Team osu = new Team(Integer.toString(R.drawable.osu), "Ohio State", "Feb, 11", "Saturday, February 11", "Purcell Pavilion, Notre Dame, IN", "72-64", "21-9");
        Team fsu = new Team(Integer.toString(R.drawable.fsu), "Florida State", "Feb, 14", "Tuesday, February 14", "Donald Tucker Civic Center, Tallahassee, FL", "80-69", "22-5");
        Team wf = new Team(Integer.toString(R.drawable.wf), "Wake Forest", "Feb, 18", "Saturday, February 18", "Purcell Pavilion, Notre Dame, IN", "67-54", "15-12");
        Team bc = new Team(Integer.toString(R.drawable.bc), "Boston College", "Feb, 26", "Sunday, February 26", "Conte Forum, Boston, MA", "58-63", "20-10");
        Team ncsu = new Team(Integer.toString(R.drawable.ncsu), "North Carolina State", "Mar. 1", "Wednesday, March 1", "Purcell Pavilion, Notre Dame, IN", "62-68", "17-11");
        Team gt = new Team(Integer.toString(R.drawable.gt), "Georgia Tech", "Mar. 4", "Saturday, March 4", "Purcell Pavilion, Notre Dame, IN", "70-59", "19-9");
        Team nv = new Team(Integer.toString(R.drawable.nova), "North Virginia", "Mar. 7", "Tuesday, March 7", "Purcell Pavilion, Notre Dame, IN", "82-50", "9-20");
        Team cs = new Team(Integer.toString(R.drawable.chicagost), "Chicago State", "Mar. 17", "Friday, March 17", "Purcell Pavilion, Notre Dame, IN", "95-51", "5-19");*/

      /*  info.add(osu);
        info.add(fsu);
        info.add(wf);
        info.add(bc);
        info.add(ncsu);
        info.add(gt);
        info.add(nv);
        info.add(cs);*/
        /*ArrayList info = new ArrayList();
        info.add(teams);
        info.add(dates);*/
       /* dates.add("Feb. 11");
        dates.add("Feb. 14");
        dates.add("Feb. 18");
        dates.add("Feb. 26");
        dates.add("Mar. 1");
        dates.add("Mar. 4");
        dates.add("Mar. 7");
        dates.add("Mar. 16");*/
        Toolbar actionBarToolbar = (Toolbar) findViewById(toolbar);
        setSupportActionBar(actionBarToolbar);
        MyCsvFileReader reader = new MyCsvFileReader(getApplicationContext());
        final ArrayList<Team> info = reader.readCsvFile(R.raw.schedule);
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this, info);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(scheduleAdapter);

        ListView.OnItemClickListener clickListener = new ListView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                Team team = info.get(position);
                bundle.putSerializable("info", team);
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        };
        scheduleListView.setOnItemClickListener(clickListener);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id == R.id.share) {
// code for sharing the schedule
            Intent shareIntent = new Intent();
            shareIntent.setAction(android.content.Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra("android.content.Intent.EXTRA_SUBJECT", "BasketBall Matches");
            shareIntent.putExtra("android.content.Intent.EXTRA_TEXT", gameSchedule());
         //   startActivity(Intent.createChooser(shareIntent), "Share via");
        } else if (res_id == R.id.sync) {
            final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Sync is not yet implemented", Snackbar.LENGTH_LONG);
            snackbar.setAction("Try Again", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(coordinatorLayout, "Wait for the next few labs. Thank you for your patience", Snackbar.LENGTH_LONG).show();
                }
            });
            snackbar.show();
        } else if (res_id == R.id.settings) {
            registerForContextMenu((View) findViewById(R.id.settings));
            openContextMenu((View) findViewById(R.id.settings));
            unregisterForContextMenu((View) findViewById(R.id.settings));
// Floating Contextual Menu with options

        }

        return true;
    }

    // @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floating_contextual_menu, menu);
// here write code to inflate floating_contextual_menu xml file
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int item_id = item.getItemId();
       // if (item_id == R.id.women) {
// to be implemented later
      //  }
        return false;
    }
}   /* ListView.OnItemClickListener clickListener = new ListView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("team", info.get(position));

            startActivity(intent);
        }
    };
    scheduleListView.setOnItemClickListener(clickListener);
    */

