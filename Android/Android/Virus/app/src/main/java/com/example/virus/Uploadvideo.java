package com.example.virus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Uploadvideo extends AppCompatActivity implements JsonResponse {
    EditText e1, e2, e3;
    Spinner s1;
    String status;
    public static String pid;
    String[] product_name, value, prod_ic;
    SharedPreferences sh;
    Button b1;


    ImageButton i1;

    String amount, quantity, total;
    final int CAMERA_PIC_REQUEST = 0, GALLERY_CODE = 201;
    public static String encodedImage = "", path = "";
    private Uri mImageCaptureUri;
    byte[] byteArray = null;

    private static final int REQUEST_CODE_SELECT_VIDEO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadvideo);



        b1 = findViewById(R.id.buy);
        sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


        i1 = (ImageButton) findViewById(R.id.imageButton);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageOption();
            }
        });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                sendAttach();
            }
        });


    }

    private void sendAttach() {

        try {
            SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

            String q = "http://" + Ipsettings.text + "/api/upload";

            Toast.makeText(getApplicationContext(), "Byte Array:" + byteArray.length, Toast.LENGTH_LONG).show();


            Map<String, byte[]> aa = new HashMap<>();

            aa.put("image", byteArray);

//                aa.put("lid",sh.getString("log_id","").getBytes());


//                aa.put("log_id",sh.getString("log_id","").getBytes());
//            aa.put("house",house.getBytes());

            FileUploadAsync fua = new FileUploadAsync(q);
            fua.json_response = (JsonResponse) Uploadvideo.this;
            fua.execute(aa);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Exception upload : " + e, Toast.LENGTH_SHORT).show();
        }
    }


    private void selectImageOption() {
        /*Android 10+ gallery code
        android:requestLegacyExternalStorage="true"*/

        final CharSequence[] items = {"Video", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(Uploadvideo.this);
        builder.setTitle("Take Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                 if (items[item].equals("Video")) {
//                    Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(i, GALLERY_CODE);
                     // Create a new Intent to open the file picker
                     Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                     intent.setType("video/*");

// Launch the file picker activity
                     startActivityForResult(Intent.createChooser(intent, "Select Video"), REQUEST_CODE_SELECT_VIDEO);

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }




    @Override
    public void response(JSONObject jo) {
        try {

            String method = jo.getString("method");
            Log.d("pearl", method);

            if (method.equalsIgnoreCase("viewproductspinner")) {
                status = jo.getString("status");
                Log.d("pearlssssss", status);


                if (status.equalsIgnoreCase("success")) {

                    JSONArray ja1 = (JSONArray) jo.getJSONArray("data");

                    product_name = new String[ja1.length()];
                    prod_ic = new String[ja1.length()];

                    value = new String[ja1.length()];

                    for (int i = 0; i < ja1.length(); i++) {

                        product_name[i] = ja1.getJSONObject(i).getString("product_name");
                        prod_ic[i] = ja1.getJSONObject(i).getString("product_id");
                        value[i] = product_name[i];

                    }
                    ArrayAdapter<String> ar = new ArrayAdapter<String>(getApplicationContext(), R.layout.custtext, value);

                    s1.setAdapter(ar);


                } else {
                    Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_LONG).show();
                    s1.setVisibility(View.GONE);
                }
            }

            if (method.equalsIgnoreCase("buynow")) {
                status = jo.getString("status");
                Log.d("pearl", status);


                if (status.equalsIgnoreCase("success")) {


                    Toast.makeText(getApplicationContext(), "Product Added Successfully", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                    s1.setVisibility(View.GONE);
                }
            }


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == GALLERY_CODE && resultCode == RESULT_OK && null != data) {
//
//            mImageCaptureUri = data.getData();
//            System.out.println("Gallery Image URI : " + mImageCaptureUri);
//            //   CropingIMG();
//
//            Uri uri = data.getData();
//            Log.d("File Uri", "File Uri: " + uri.toString());
//            // Get the path
//            //String path = null;
//            try {
////                path = FileUtils.getPath(this, uri);
//                path=FileUtils.getPath(this,uri);
//                Toast.makeText(getApplicationContext(), "path : " + path, Toast.LENGTH_LONG).show();
//
//                File fl = new File(path);
//                int ln = (int) fl.length();
//
//                InputStream inputStream = new FileInputStream(fl);
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                byte[] b = new byte[ln];
//                int bytesRead = 0;
//
//                while ((bytesRead = inputStream.read(b)) != -1) {
//                    bos.write(b, 0, bytesRead);
//                }
//                inputStream.close();
//                byteArray = bos.toByteArray();
//
//                Bitmap bit = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//                i1.setImageBitmap(bit);
//
//                String str = Base64.encodeToString(byteArray, Base64.DEFAULT);
//                encodedImage = str;
////                sendAttach1();
//            } catch (Exception e) {
//                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
//            }
//        } else if (requestCode == CAMERA_PIC_REQUEST && resultCode == Activity.RESULT_OK) {
//
//            try {
//                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                i1.setImageBitmap(thumbnail);
//                byteArray = baos.toByteArray();
//
//                String str = Base64.encodeToString(byteArray, Base64.DEFAULT);
//                encodedImage = str;
////                sendAttach1();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            if (requestCode == REQUEST_CODE_SELECT_VIDEO && resultCode == RESULT_OK) {
                // Get the URI of the selected file
                mImageCaptureUri = data.getData();

                Uri uri = data.getData();
                Log.d("File Uri", "File Uri: " + uri.toString());
            System.out.println("Gallery Image URI : " + mImageCaptureUri);
                try {
//                path = FileUtils.getPath(this, uri);
                    path=FileUtils.getPath(this,uri);
                    Toast.makeText(getApplicationContext(), "path : " + path, Toast.LENGTH_LONG).show();

                    File fl = new File(path);
                    int ln = (int) fl.length();

                    InputStream inputStream = new FileInputStream(fl);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] b = new byte[ln];
                    int bytesRead = 0;

                    while ((bytesRead = inputStream.read(b)) != -1) {
                        bos.write(b, 0, bytesRead);
                    }
                    inputStream.close();
                    byteArray = bos.toByteArray();

                    Bitmap bit = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    i1.setImageBitmap(bit);

                    String str = Base64.encodeToString(byteArray, Base64.DEFAULT);
                    encodedImage = str;
//                sendAttach1();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

                // Do something with the file URI, such as uploading it to a server
                // ...
            }


    }
    public void onBackPressed()
    {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent b=new Intent(getApplicationContext(),Userhome.class);
        startActivity(b);
    }


    private String getFilePathFromUri(Uri uri) {
        String filePath;
        if ("file".equals(uri.getScheme())) {
            filePath = uri.getPath();
        } else {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor == null || !cursor.moveToFirst()) {
                throw new RuntimeException("Failed to get file path from Uri: " + uri.toString());
            }
            int index = cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA);
            filePath = cursor.getString(index);
            cursor.close();
        }
        return filePath;
    }






}

