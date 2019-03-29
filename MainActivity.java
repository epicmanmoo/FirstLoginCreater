package com.example.nasir.logintest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1, e2, e3;
    Button b1, b2;

    private static final String TAG= "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.cpass);
        b1=(Button)findViewById(R.id.register);
        b2=(Button)findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this, Login.class);
                startActivity(i);
                finish();


            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1= e1.getText().toString();
                String s2= e2.getText().toString();
                String s3= e3.getText().toString();
                if(s1.length()<2){
                    Toast.makeText(getApplicationContext(), "Make username longer",  Toast.LENGTH_SHORT).show();
                }
                if(s2.length()<2){
                    Toast.makeText(getApplicationContext(), "Make password longer", Toast.LENGTH_SHORT).show();
                }
                    if(s1.equals("")||s2.equals("")||s3.equals("")) {
                        Toast.makeText(getApplicationContext(), "One or more fields are empty", Toast.LENGTH_SHORT).show();
                    }
                    else if(s1.equals(s3)){
                        Toast.makeText(getApplicationContext(), "Username and passwords match", Toast.LENGTH_SHORT).show();
                    }

                else if (!s2.equals(s3)){
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                    else if (s2.equals(s3) && s2.length() > 1 && s3.length() > 1 && s1.length() > 1){
                        Boolean chkemail = db.chkemail(s1);


                        if (chkemail==true){
                            Boolean insert= db.insert(s1, s2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(), "Registered!", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(MainActivity.this, Login.class);
                                startActivity(intent);
                            }

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Username already exists", Toast.LENGTH_SHORT).show();
                        }
                }



            }
        });



    }
}
