package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class bikestore extends AppCompatActivity {

    private ListView listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bikestore);

        listView2=findViewById(R.id.lv1);

        String[] bikenames = getResources().getStringArray(R.array.Bike_Name);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(bikestore.this,R.layout.activity_sample_bike,R.id.lvtv,bikenames);
        listView2.setAdapter(adapter);


    }
}