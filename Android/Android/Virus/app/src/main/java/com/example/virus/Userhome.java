package com.example.virus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Userhome extends AppCompatActivity {
    Button b2,b3,b4,b5,b6,b7,b8,b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);

     b6=(Button)findViewById(R.id.request);
     b8=(Button)findViewById(R.id.complaints);

//        b3=(Button)findViewById(R.id.viewbook);
//        b4=(Button)findViewById(R.id.viewcycle);
        b5=(Button)findViewById(R.id.cycle);

        b7=(Button)findViewById(R.id.logout);


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Userviewrequest.class));
            }
        });
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),Parentaddimageorvideo.class));
//            }
//        });
//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),Audio_upload.class));
//            }
//        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Addemergency.class));
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Usersendcomplaint.class));
            }
        });



        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Ipsettings.class));
            }
        });

    }
    }
