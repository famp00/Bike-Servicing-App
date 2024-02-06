package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class wash extends AppCompatActivity {

    Button backwash, washgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash);

        EditText wname, wreg, wprob, wdat, wpick;

        wname=findViewById(R.id.w_name);
        wreg=findViewById(R.id.w_reg);
        wprob=findViewById(R.id.w_prob);
        wdat=findViewById(R.id.w_dat);
        wpick=findViewById(R.id.w_point);

        backwash= findViewById(R.id.backwash);
        washgo= findViewById(R.id.washgo);

        backwash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(wash.this, HomePage.class);
                startActivity(i);
                finish();

            }
        });


        washgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String bike= wname.getText().toString();
                String reg= wreg.getText().toString();
                String problem= wprob.getText().toString();
                String dandt= wdat.getText().toString();
                String pickup= wpick.getText().toString();

                if(bike.equals("") && reg.equals("")&& problem.equals("")&& dandt.equals("")&& pickup.equals("")){

                    Toast.makeText(getApplicationContext(),"Please enter some data", Toast.LENGTH_SHORT).show();

                }

                else if(bike.equals("") || reg.equals("")|| problem.equals("")|| dandt.equals("")|| pickup.equals("")){

                    Toast.makeText(getApplicationContext(),"Please enter all data", Toast.LENGTH_SHORT).show();

                }

                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("Contact Info", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Bike Name", bike);
                    editor.putString("Registration", reg);
                    editor.putString("Problem", problem);
                    editor.putString("Date and Time", dandt);
                    editor.putString("Pick Up Point", pickup);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Thanks for your concern. We will come to your place.", Toast.LENGTH_SHORT).show();
                }









            }
        });


    }
}