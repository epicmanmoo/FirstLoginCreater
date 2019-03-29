package com.example.nasir.logintest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1, e2;
    TextView a;
    Button b1, b2;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.returnb);
        a= (TextView)findViewById(R.id.email);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnb = new Intent(Login.this, MainActivity.class);
                startActivity(returnb);
                finish();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email, password);
                Boolean Chkemail= db.chkemail(email);

                if (email.equals("") && password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();

                }
                else if(email.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter username", Toast.LENGTH_SHORT).show();

                }
                else if(password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();

                }

                else if (!Chkemailpass){
                    Toast.makeText(getApplicationContext(), "Wrong password and/or username", Toast.LENGTH_SHORT).show();
                }

                else {

                    Intent ii = new Intent(Login.this, accountinfo.class);
                    ii.putExtra("name", email);
                    startActivity(ii);

                }
            }
        });
    }



}





