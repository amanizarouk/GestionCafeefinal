package com.amani.gestioncafee;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class loginActivity extends Activity {

   EditText UserN,pass;
   Button signup ,signin;
    DataBAseHandler db;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserN =(EditText)findViewById(R.id.Username);
        pass = (EditText)findViewById(R.id.password);
        signin =(Button)findViewById(R.id.signin);
        signup =(Button)findViewById(R.id.signup);

        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                db=new DataBAseHandler(loginActivity.this, null, null, 2);
                String username=UserN.getText().toString();
                String password= pass.getText().toString();

                String StoredPassword =db.getsignup(username);
                if(password.equals(StoredPassword)){

                    Toast.makeText(getApplicationContext(), StoredPassword+"Login Successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),  accueil.class));

                }
                else{
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    UserN.setText("");
                    pass.setText("");
                }


            }
        });

        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                startActivity(new Intent(getApplicationContext(), signup.class));
            }
        });

    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
