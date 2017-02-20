package com.cs60333.mpenny2.lab2_mpenny2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

import static com.cs60333.mpenny2.lab2_mpenny2.R.id.scheduleListView;

public class MainActivity extends AppCompatActivity {
    ArrayList<String[]> info = new ArrayList<String[]>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String[] teams = {"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech","North Virginia", "Chicago State"};
        //  String[] dates = {"Feb. 11", "Feb.14" ,"Feb.18", "Feb. 26", "Mar. 1", "Mar. 4", "Mar. 7", "Mar. 16"};

        String[] osu = {Integer.toString(R.drawable.osu), "Ohio State", "Feb, 11", "Saturday, February 11", "Purcell Pavilion, Notre Dame, IN", "72-64", "21-9"};
        String[] fsu = {Integer.toString(R.drawable.fsu), "Florida State", "Feb, 14", "Tuesday, February 14", "Donald Tucker Civic Center, Tallahassee, FL", "80-69", "22-5"};
        String[] wf = {Integer.toString(R.drawable.wf), "Wake Forest", "Feb, 18", "Saturday, February 18", "Purcell Pavilion, Notre Dame, IN", "67-54", "15-12"};
        String[] bc = {Integer.toString(R.drawable.bc), "Boston College", "Feb, 26", "Sunday, February 26", "Conte Forum, Boston, MA", "58-63", "20-10"};
        String[] ncsu = {Integer.toString(R.drawable.ncsu), "North Carolina State", "Mar. 1", "Wednesday, March 1", "Purcell Pavilion, Notre Dame, IN", "62-68", "17-11"};
        String[] gt = {Integer.toString(R.drawable.gt), "Georgia Tech", "Mar. 4", "Saturday, March 4", "Purcell Pavilion, Notre Dame, IN", "70-59", "19-9"};
        String[] nv = {Integer.toString(R.drawable.nova), "North Virginia", "Mar. 7", "Tuesday, March 7", "Purcell Pavilion, Notre Dame, IN", "82-50", "9-20"};
        String[] cs = {Integer.toString(R.drawable.chicagost), "Chicago State", "Mar. 17", "Friday, March 17", "Purcell Pavilion, Notre Dame, IN", "95-51", "5-19"};

      //  ArrayList<String[]> info = new ArrayList();
        info.add(osu);
        info.add(fsu);
        info.add(wf);
        info.add(bc);
        info.add(ncsu);
        info.add(gt);
        info.add(nv);
        info.add(cs);
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

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this, info);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(scheduleAdapter);

        ListView.OnItemClickListener clickListener = new ListView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("team", info.get(position));
                startActivity(intent);
            }
        };
        scheduleListView.setOnItemClickListener(clickListener);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   /* ListView.OnItemClickListener clickListener = new ListView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("team", info.get(position));

            startActivity(intent);
        }
    };
    scheduleListView.setOnItemClickListener(clickListener);
    */
}
