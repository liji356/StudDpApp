package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    
    EditText ed1,ed2,ed3,ed4;
     AppCompatButton b1,b2;
     
     String getAdmission,getName,getRoll,getCollege;

     DatabaseHelper help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        help=new DatabaseHelper(this);

        help.getWritableDatabase();
        
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


                Cursor c= help.searchData(getAdmission);

                if(c.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (c.moveToNext())
                    {
                        getName=c.getString(1);
                        getRoll=c.getString(2);
                        getCollege=c.getString(4);
                    }
                    ed2.setText(getName);
                    ed3.setText(getRoll);
                    ed4.setText(getCollege);
                }

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