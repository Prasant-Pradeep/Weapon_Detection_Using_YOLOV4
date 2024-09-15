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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class Viewcomplaints extends AppCompatActivity implements JsonResponse, AdapterView.OnItemClickListener {
    EditText e1;
    Button b1;
    ListView l1;
    String complaint,login_id;
    String[] complaints,complaint_id,reply,date,value,fname;
    SharedPreferences sh;
    public static String cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcomplaints);

        sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        e1=(EditText) findViewById(R.id.complaint);
        l1=(ListView)findViewById(R.id.list) ;
        b1=(Button)findViewById(R.id.button4);
        l1.setOnItemClickListener(this);
        JsonReq JR = new JsonReq();
        JR.json_response = (JsonResponse) Viewcomplaints.this;
        String q ="/policeview_complaint?login_id="+Login.logid;
        q = q.replace(" ","%20");
        JR.execute(q);



    }

    @Override
    public void response(JSONObject jo) {
        try {

            String method=jo.getString("method");
            if(method.equalsIgnoreCase("send_complaint")) {

                String status = jo.getString("status");
                Log.d("pearl", status);


                if (status.equalsIgnoreCase("success")) {
                    Toast.makeText(getApplicationContext(), "ADDED SUCCESSFULLY", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Usersendcomplaint.class));

                } else {

                    Toast.makeText(getApplicationContext(), " failed.TRY AGAIN!!", Toast.LENGTH_LONG).show();
                }
            }
            else if(method.equalsIgnoreCase("policeview_complaint"))
            {
                String status=jo.getString("status");
                Log.d("pearl",status);


                if(status.equalsIgnoreCase("success")){
                    JSONArray ja1=(JSONArray)jo.getJSONArray("data");
                    //feedback_id=new String[ja1.length()];
                    complaints=new String[ja1.length()];
                    reply=new String[ja1.length()];
                    date=new String[ja1.length()];
                    value=new String[ja1.length()];
                    fname=new String[ja1.length()];
                    complaint_id=new String[ja1.length()];
                    for(int i = 0;i<ja1.length();i++)
                    {
                        complaints[i]=ja1.getJSONObject(i).getString("complaint_details");
                        reply[i]=ja1.getJSONObject(i).getString("reply");
                        date[i]=ja1.getJSONObject(i).getString("date");
                        fname[i]=ja1.getJSONObject(i).getString("branch_name");
                        complaint_id[i]=ja1.getJSONObject(i).getString("compliant_id");
                        value[i]="Branch name: "+fname[i]+"\ncomplaints: "+complaints[i]+"\nreply: "+reply[i]+"\ndate: "+date[i];

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


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        cid=complaint_id[i];
        final CharSequence[] items = {"Send reply","Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(Viewcomplaints.this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Send reply")) {
                   startActivity(new Intent(getApplicationContext(),SendReply.class));

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

