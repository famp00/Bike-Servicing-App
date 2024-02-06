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

public class servicing extends AppCompatActivity {

    servicing_database servicingDatabase= new servicing_database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicing);


        EditText bname, breg, prob, dat, pick;

        bname=findViewById(R.id.b_name);
        breg=findViewById(R.id.b_reg);
        prob=findViewById(R.id.b_prob);
        dat=findViewById(R.id.b_dat);
        pick=findViewById(R.id.p_point);




        Button backser, sergo;

        backser= findViewById(R.id.backservicing);
        sergo= findViewById(R.id.servicinggo);

        backser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(servicing.this, HomePage.class);
                startActivity(i);
                finish();

            }
        });


        sergo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String bike= bname.getText().toString();
                String reg= breg.getText().toString();
                String problem= prob.getText().toString();
                String dandt= dat.getText().toString();
                String pickup= pick.getText().toString();

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

        servicing_database servicingDatabase = new servicing_database(this);
        SQLiteDatabase sqLiteDatabase = servicingDatabase.getWritableDatabase();


    }
}