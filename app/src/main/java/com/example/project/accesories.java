package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class accesories extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accesories);

        listView =findViewById(R.id.lv2);

        String[] accessories = getResources().getStringArray(R.array.accessories);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(accesories.this,R.layout.activity_sample2,R.id.lvtv2,accessories);
        listView.setAdapter(adapter);
    }
}