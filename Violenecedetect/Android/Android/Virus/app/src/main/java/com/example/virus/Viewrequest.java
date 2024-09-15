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

public class Viewrequest extends AppCompatActivity implements JsonResponse, AdapterView.OnItemClickListener {
    ListView l1;
    SharedPreferences sh;
    String[] request, out, statu,video_audio, value, request_id, fname,latitude,longitude,ty;
    public static String audio, id, amt, rid,tlati,tlongi,types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrequest);

        l1 = (ListView) findViewById(R.id.list);
        l1.setOnItemClickListener(this);
        sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        JsonReq JR = new JsonReq();
        JR.json_response = (JsonResponse) Viewrequest.this;
        String q = "/Viewrequest?log_id=" + sh.getString("log_id", "");
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
                request = new String[ja1.length()];
                out = new String[ja1.length()];
                statu = new String[ja1.length()];
                request_id = new String[ja1.length()];
                fname = new String[ja1.length()];
                ty = new String[ja1.length()];

                value = new String[ja1.length()];
                latitude= new String[ja1.length()];

                longitude= new String[ja1.length()];
                video_audio= new String[ja1.length()];

                String[] value = new String[ja1.length()];

                for (int i = 0; i < ja1.length(); i++) {
                    request[i] = ja1.getJSONObject(i).getString("request");
                    out[i] = ja1.getJSONObject(i).getString("out");
                    statu[i] = ja1.getJSONObject(i).getString("status");
                    ty[i] = ja1.getJSONObject(i).getString("type");
                    request_id[i] = ja1.getJSONObject(i).getString("request_id");
                    fname[i] = ja1.getJSONObject(i).getString("fname");
                    latitude[i] = ja1.getJSONObject(i).getString("latitude");
                    longitude[i] = ja1.getJSONObject(i).getString("longitude");
                    video_audio[i] = ja1.getJSONObject(i).getString("video_audio");


                    value[i] = "request:" + request[i]+"\nout:" + out[i]+"\nstatus:" + statu[i]+"\nfname:" + fname[i];

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
        tlongi=longitude[i];
        rid=request_id[i];
        audio=video_audio[i];
        types=ty[i];
        if(types.equalsIgnoreCase("Audio")){

        final CharSequence[] items = {"Audio","Locations","Cancel"};
            AlertDialog.Builder builder = new AlertDialog.Builder(Viewrequest.this);
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
//                    if (items[item].equals("Video")) {
//                        startActivity(new Intent(getApplicationContext(), Videos.class));
//                    }

                      if (items[item].equals("Audio")) {


                        startActivity(new Intent(getApplicationContext(), MusicPlay.class));

                    }
                    else  if (items[item].equals("Locations")) {
                        //                    startActivity(new Intent(getApplicationContext(),UserHotelRoomBooking.class));
                        String url = "http://www.google.com/maps?saddr=" + LocationService.lati + "" + "," + LocationService.logi + "" + "&&daddr=" + tlati + "," + tlongi;

                        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(in);

                    }



                    else if (items[item].equals("Cancel")) {


                        dialog.dismiss();
                    }
                }

            });
            builder.show();
        }else{

        final CharSequence[] items = {"Image","Locations","Cancel"};
            AlertDialog.Builder builder = new AlertDialog.Builder(Viewrequest.this);
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    if (items[item].equals("Image")) {
                        startActivity(new Intent(getApplicationContext(), ImageView.class));
                    }
//
//                    else  if (items[item].equals("Audio")) {
//
//
//                        startActivity(new Intent(getApplicationContext(), MusicPlay.class));
//
//                    }
                    else  if (items[item].equals("Locations")) {
                        //                    startActivity(new Intent(getApplicationContext(),UserHotelRoomBooking.class));
                        String url = "http://www.google.com/maps?saddr=" + LocationService.lati + "" + "," + LocationService.logi + "" + "&&daddr=" + tlati + "," + tlongi;

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


    }
    public void onBackPressed()
    {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent b=new Intent(getApplicationContext(),Policehome.class);
        startActivity(b);
    }
    }
