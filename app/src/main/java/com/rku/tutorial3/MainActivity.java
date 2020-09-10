package com.rku.tutorial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username , password;
    Button btnLogin;

    String correct_username = "admin@gmail.com";
    String correct_password = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.edtUsername);
        password = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnSubmit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate inputs

                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this,"Empty Data Provided", Toast.LENGTH_LONG).show();
                }
                else if(username.getText().toString().equals(correct_username)) {
                    //check password
                    if(password.getText().toString().equals(correct_password)) {
                        //Toast.makeText(MainActivity.this,"Successfully logged in", Toast.LENGTH_LONG).show();
                        openNewActivity();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();

                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }
}