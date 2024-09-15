package com.example.virus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;

public class Addemergency extends AppCompatActivity implements JsonResponse {
    EditText e1,e2,e3,e4,e5;
    Button b1;
SharedPreferences sh;
    ListView l1;
    String emergency,date;
    String[] emergencys,latitude,longitude,fname,value ;
    public static String product_id,pname,q,c,d,sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemergency);
        sh=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        e1 =(EditText) findViewById(R.id.emg);
        l1=(ListView) findViewById(R.id.list);
        b1=(Button) findViewById(R.id.button1);

        JsonReq JR = new JsonReq();
        JR.json_response = (JsonResponse) Addemergency.this;
        String q = "/viewemergencyss";
        q = q.replace(" ", "%20");
        JR.execute(q);

        startService(new Intent(getApplicationContext(),LocationService.class));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emergency=e1.getText().toString();


                JsonReq JR = new JsonReq();
                JR.json_response = (JsonResponse) Addemergency.this;
                String q = "/Addemergency?emergency=" + emergency+"&latitude="+LocationService.lati+"&longitude="+LocationService.logi +  "&log_id=" + sh.getString("log_id", "")  ;
                q = q.replace(" ", "%20");
                JR.execute(q);

            }
        });
    }

    @Override
    public void response(JSONObject jo) {
        try {

            String method=jo.getString("method");
            if(method.equalsIgnoreCase("Addemergency")) {

                String status = jo.getString("status");
                Log.d("pearl", status);


                if (status.equalsIgnoreCase("success")) {
                    Toast.makeText(getApplicationContext(), "ADDED SUCCESSFULLY", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Addemergency.class));

                } else {

                    Toast.makeText(getApplicationContext(), " failed.TRY AGAIN!!", Toast.LENGTH_LONG).show();
                }
            }
            else if(method.equalsIgnoreCase("viewemergencyss"))
            {
                String status=jo.getString("status");
                Log.d("pearl",status);


                if(status.equalsIgnoreCase("success")){
                    JSONArray ja1=(JSONArray)jo.getJSONArray("data");

                    emergencys=new String[ja1.length()];
                    latitude=new String[ja1.length()];
                    longitude=new String[ja1.length()];
                    fname=new String[ja1.length()];
                    value=new String[ja1.length()];


                    for(int i = 0;i<ja1.length();i++)
                    {
                        emergencys[i]=ja1.getJSONObject(i).getString("emergency");
                        latitude[i]=ja1.getJSONObject(i).getString("latitude");
                        longitude[i]=ja1.getJSONObject(i).getString("longitude");
                        fname[i]=ja1.getJSONObject(i).getString("branch_name");



                        value[i]="emergencys: "+emergencys[i]+"\nfname: "+fname[i];

                    }
                    ArrayAdapter<String> ar=new ArrayAdapter<String>(getApplicationContext(),R.layout.custtext,value);
                    l1.setAdapter(ar);
                }
            }



        }

        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}