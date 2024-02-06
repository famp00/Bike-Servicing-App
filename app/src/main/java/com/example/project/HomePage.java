package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class HomePage extends AppCompatActivity {


    Button bikestore, accesories, servicing, bikewash, expert, aboutus, backhomepag, logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        bikestore= findViewById(R.id.bikestore);
        accesories= findViewById(R.id.accs);
        servicing= findViewById(R.id.svc);
        bikewash= findViewById(R.id.bikewash);
        aboutus= findViewById(R.id.about);
        expert= findViewById(R.id.opinion);

        backhomepag= findViewById(R.id.backhomepage);
        logout= findViewById(R.id.logout);




        bikestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(HomePage.this, bikestore.class);
                startActivity(i);
                finish();

            }
        });



        accesories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





        servicing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(HomePage.this, servicing.class);
                startActivity(i);
                finish();

            }
        });



        bikewash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(HomePage.this, wash.class);
                startActivity(i);
                finish();

            }
        });


        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(HomePage.this, about_us.class);
                startActivity(i);
                finish();

            }
        });


        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(HomePage.this, expert.class);
                startActivity(i);
                finish();

            }
        });



        backhomepag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(HomePage.this, login.class);
                startActivity(i);
                finish();

            }
        });



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(HomePage.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });






    }
}