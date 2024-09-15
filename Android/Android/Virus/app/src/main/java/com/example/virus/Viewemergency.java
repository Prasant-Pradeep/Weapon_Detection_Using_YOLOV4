package com.example.virus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class Viewemergency extends AppCompatActivity implements JsonResponse, AdapterView.OnItemClickListener {
    ListView l1;
    SharedPreferences sh;
    String[] emergency, value, emergency_id, fname,latitude,longitude;
    public static String stat, id, amt, brid,tlati,tlong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewemergency);

        l1 = (ListView) findViewById(R.id.list);
        l1.setOnItemClickListener(this);
        sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        JsonReq JR = new JsonReq();
        JR.json_response = (JsonResponse) Viewemergency.this;
        String q = "/Viewemergency?log_id=" + sh.getString("log_id", "");
        q = q.replace(" ", "%20");
        JR.execute(q);
    }

    @Override
    public void response(JSONObject jo) {
        try {

            String status = jo.getString("status");
            Log.d("pearl", status);


            if (status.equalsIgnoreCase("success")) {
                JSONArray ja1 = (JSONArray) jo.getJSONArray("data");
                emergency = new String[ja1.length()];

                emergency_id = new String[ja1.length()];
                fname = new String[ja1.length()];

                value = new String[ja1.length()];

                latitude= new String[ja1.length()];
                latitude= new String[ja1.length()];

                longitude= new String[ja1.length()];
                String[] value = new String[ja1.length()];

                for (int i = 0; i < ja1.length(); i++) {
                    emergency[i] = ja1.getJSONObject(i).getString("emergency");

                    emergency_id[i] = ja1.getJSONObject(i).getString("emergency_id");
                    fname[i] = ja1.getJSONObject(i).getString("branch_name");
                    latitude[i] = ja1.getJSONObject(i).getString("latitude");
                    longitude[i] = ja1.getJSONObject(i).getString("longitude");

                    value[i] = "emergency:" + emergency[i]+"\nBranch Name:" + fname[i];

                }
                ArrayAdapter<String> ar = new ArrayAdapter<String>(getApplicationContext(), R.layout.custtext, value);

                l1.setAdapter(ar);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tlati=latitude[i];
        tlong=longitude[i];

        final CharSequence[] items = {"Locations","Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(Viewemergency.this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Locations")) {
                    //                    startActivity(new Intent(getApplicationContext(),UserHotelRoomBooking.class));
                    String url = "http://www.google.com/maps?saddr=" + LocationService.lati + "" + "," + LocationService.logi + "" + "&&daddr=" + tlati + "," + tlong;

                    Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(in);

                }

                else if (items[item].equals("Cancel")) {


                    dialog.dismiss();
                }
            }

        });
        builder.show();
    }
    public void onBackPressed()
    {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent b=new Intent(getApplicationContext(),Policehome.class);
        startActivity(b);
    }
    }
