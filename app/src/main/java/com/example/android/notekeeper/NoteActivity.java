package com.example.android.notekeeper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinnerCourses = (Spinner) findViewById(R.id.spinner_courses);

        // Creating a List i.e. 'courses' of type 'CourseInfo'
        // that will hold the list of courses returned from 'DataManager' class.
        List<CourseInfo> courses = DataManager.getInstance().getCourses();

        // Creating an Instance of an ArrayAdapter i.e. 'adapterCourses',
        // where in we will define the 'display layout' for a 'single resource' and also will
        // pass the above created List i.e. 'courses' as a data source to the 'adapterCourses'
        ArrayAdapter<CourseInfo> adapterCourses =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);

        // Setting the "Type of Resource" to be used for 'adapterCourses' and
        // what Layout to be used for 'Resource Type'
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Associating the above created Adapter i.e. 'adapterCourses' to the Layout Resource
        spinnerCourses.setAdapter(adapterCourses);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note, menu);
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
}
