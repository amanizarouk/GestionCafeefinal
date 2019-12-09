package com.amani.gestioncafee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText first, last, email, pass;

    Button save, cancel;
    DataBAseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        first= (EditText)findViewById(R.id.Username);
        last =(EditText)findViewById(R.id.Surname);
        email=(EditText)findViewById(R.id.Email);

        pass=(EditText)findViewById(R.id.password);



        save=(Button)findViewById(R.id.signin);
        cancel=(Button)findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(getApplicationContext(), loginActivity.class));

            }
        });


        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String edfirst = first.getText().toString();
                String edlast = last.getText().toString();
                String edemail = email.getText().toString();
                String edpass = pass.getText().toString();




                    db = new DataBAseHandler(signup.this, null, null, 2);
                    signupdata reg = new signupdata();

                    reg.setUsername(edfirst);
                    reg.setName(edlast);
                    reg.setEmail(edemail);

                    reg.setPassword(edpass);
                    db.addsignup(reg);

                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), loginActivity.class));


            }
        });
    }

        }




