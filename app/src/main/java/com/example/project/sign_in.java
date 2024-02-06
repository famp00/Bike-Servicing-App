package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class sign_in extends AppCompatActivity {

    signup_database signupDatabase= new signup_database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userdetails userdetails= new userdetails();


        Button back, go;

        EditText nme, uname, emal, pas, rpass;



        back=findViewById(R.id.back);
        go=findViewById(R.id.go);


        nme=findViewById(R.id.name);
        uname=findViewById(R.id.username);
        emal=findViewById(R.id.email);
        pas=findViewById(R.id.pass);
        rpass=findViewById(R.id.repass);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(sign_in.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });



        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String name= nme.getText().toString();
                String email= emal.getText().toString();
                String username= uname.getText().toString();
                String pass= pas.getText().toString();
                String repass= rpass.getText().toString();

                if(name.equals("") && email.equals("")&& username.equals("")&& pass.equals("")&& repass.equals("")){

                    Toast.makeText(getApplicationContext(),"Please enter some data", Toast.LENGTH_SHORT).show();

                }

                else if(name.equals("") || email.equals("")|| username.equals("")|| pass.equals("")|| repass.equals("")){

                    Toast.makeText(getApplicationContext(),"Please enter all data", Toast.LENGTH_SHORT).show();

                }

                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("Contact Info", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("Name",name);
                    editor.putString("Username",username);
                    editor.putString("Email",email);
                    editor.putString("Pass",pass);
                    editor.putString("Re Pass",repass);
                    editor.commit();
                    //Toast.makeText(getApplicationContext(),"Data is stored succesfully", Toast.LENGTH_SHORT).show();


                    Intent i= new Intent(sign_in.this, login.class);
                    startActivity(i);
                    finish();


                    userdetails.setName1(name);
                    userdetails.setUsername1(username);
                    userdetails.setEmail1(email);
                    userdetails.setPass1(pass);
                    userdetails.setRepass1(repass);
                    long rowid= signupDatabase.insertData(userdetails);


                }

            }
        });


        //Database

        signupDatabase = new signup_database(this);
        SQLiteDatabase sqLiteDatabase = signupDatabase.getWritableDatabase();





    }



}