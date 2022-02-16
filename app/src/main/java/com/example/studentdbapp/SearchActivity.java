package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    
    EditText ed1,ed2,ed3,ed4;
     AppCompatButton b1,b2;
     
     String getAdmission,getName,getRoll,getCollege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
        ed1=(EditText) findViewById(R.id.admi);
        ed2=(EditText) findViewById(R.id.na);
        ed3=(EditText) findViewById(R.id.rollno);
        ed4=(EditText) findViewById(R.id.co);
        
        b1=(AppCompatButton) findViewById(R.id.se);
        b2=(AppCompatButton) findViewById(R.id.me);
        
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAdmission=ed1.getText().toString();
                getName=ed2.getText().toString();
                getRoll=ed3.getText().toString();
                getCollege= ed4.getText().toString();

                Toast.makeText(getApplicationContext(), getAdmission, Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


        
    }
}