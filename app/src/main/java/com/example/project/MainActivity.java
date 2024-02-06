package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FIrst Page Video
        VideoView videoView1;
        videoView1=findViewById(R.id.video1);
        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.firstpagevideo);
        videoView1.setVideoURI(uri);
        videoView1.start();
        MediaController mediaController= new MediaController(this);


        Button login, signup, back;

        login= findViewById(R.id.login);
        signup= findViewById(R.id.signin);
        back= findViewById(R.id.back);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainActivity.this, login.class);
                startActivity(i);
                finish();

            }
        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainActivity.this, sign_in.class);
                startActivity(i);
                finish();

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();


            }
        });








    }
}