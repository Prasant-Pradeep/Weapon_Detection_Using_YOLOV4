package com.example.virus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Policehome extends AppCompatActivity {
    Button b2,b3,b4,b5,b6,b7,b8,b9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policehome);

//        b2=(Button)findViewById(R.id.comp);
        b3=(Button)findViewById(R.id.Addwallet);
//        b4=(Button)findViewById(R.id.viewcycle);

        b7=(Button)findViewById(R.id.logout);


//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),Viewcomplaints.class));
//            }
//        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Viewrequest.class));
            }
        });
//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),Viewemergency.class));
//            }
//        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Ipsettings.class));
            }
        });

    }
    }
