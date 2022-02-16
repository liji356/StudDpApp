package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1,b2;

    String getName,getRoll,getAdmission,getCollege;

    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();

        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.roll);
        ed3=(EditText) findViewById(R.id.admission);
        ed4=(EditText) findViewById(R.id.college);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b2=(AppCompatButton) findViewById(R.id.menu);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getName=ed1.getText().toString();
                getRoll=ed2.getText() .toString();
                getAdmission=ed3.getText().toString();
                getCollege=ed4.getText().toString();

                boolean result=dbhelper.insertData(getName,getRoll,getAdmission,getCollege);

                if(result==true)
                {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Failed To Insert", Toast.LENGTH_SHORT).show();
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