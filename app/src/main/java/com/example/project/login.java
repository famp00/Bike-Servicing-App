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

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup_database signupDatabase = new signup_database(this);

        Button back = findViewById(R.id.back);
        Button go = findViewById(R.id.go);
        EditText pas,uname;

        pas=findViewById(R.id.passlogin);
        uname=findViewById(R.id.usernamelogin);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(login.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String username = uname.getText().toString();
                String pass = pas.getText().toString();

                if (username.equals("") && pass.equals("")) {

                    Toast.makeText(getApplicationContext(), "Please enter some data", Toast.LENGTH_SHORT).show();

                } else if (username.equals("") || pass.equals("")) {

                    Toast.makeText(getApplicationContext(), "Please enter all data", Toast.LENGTH_SHORT).show();

                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("Contact Info", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Username", username);
                    editor.putString("Pass", pass);
                    editor.commit();
                    //Toast.makeText(getApplicationContext(), "Data is stored succesfully", Toast.LENGTH_SHORT).show();

                    boolean result = signupDatabase.findPassword(username, pass);

                    if(result==true){
                        Intent i = new Intent(login.this, HomePage.class);
                        startActivity(i);
                        finish();

                    }
                    else{

                        Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();

                    }






                }
            }



        });


}
}
