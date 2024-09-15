package com.example.virus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Parentaddimageorvideo extends AppCompatActivity implements JsonResponse{

    ImageButton i1;
    Button b1;
    SharedPreferences sh;
    final int CAMERA_PIC_REQUEST = 0, GALLERY_CODE = 201;
    public static String encodedImage = "", path = "",newval="";
    private Uri mImageCaptureUri;
    byte[] byteArray = null;
    String reason;
    private final int REQUEST_TAKE_GALLERY_VIDEO = 305;
    private static final int CAMERA_CODE = 101,  CROPING_CODE = 301,READ_EXTERNAL_STORAGE_PERMISSION=1,CAMERA=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parentaddimageorvideo);

        sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        i1=(ImageButton)findViewById(R.id.imageButton);
        b1=(Button)findViewById(R.id.button);

        EditText e88 = findViewById(R.id.editTextTextPersonName);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reason = e88.getText().toString();
                selectImageOption();

            }

        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAttach();
            }
        });
    }
    private void sendAttach() {
        try {
            SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//	            String uid = sh.getString("uid", "");


//        	latitude=LocationService.lati;
//        	longitude=LocationService.logi;


            String q = "http://" + Ipsettings.text + "/api/user_upload_file";
//            String q = "http://" +IpSetting.ip+"/api/user_upload_file";
//	            String q = "/user_upload_file/?image="+imagename+"&desc="+des+"&yts="+yt;
//	        	String q = "http://" +IPSetting.ip+"/TeachersHelper/api.php?action=teacher_upload_notes";
//	        	String q= "api.php?action=teacher_upload_notes&sh_id="+Teacher_view_timetable.s_id+"&desc="+des;

            Toast.makeText(getApplicationContext(), "Byte Array:" + byteArray.length, Toast.LENGTH_LONG).show();


            Map<String, byte[]> aa = new HashMap<>();
            if(newval.equalsIgnoreCase("image")) {
                aa.put("image", byteArray);
            }
            if(newval.equalsIgnoreCase("video")) {
                aa.put("video", byteArray);
            }
            aa.put("lid",sh.getString("log_id","").getBytes());
            aa.put("reason",reason.getBytes());
//            aa.put("sid",Parentmanagestudent.sids.getBytes());
//            aa.put("latitude",LocationService.lati.getBytes());
//            aa.put("longitude",LocationService.logi.getBytes());

         //   aa.put("logid", sh.getString("log_id", "").getBytes());
//            aa.put("link",link.getBytes());
//            aa.put("description",description.getBytes());
//            aa.put("house",house.getBytes());
//            aa.put("phone",phone.getBytes());
//            aa.put("email",email.getBytes());
//            aa.put("gender",gender.getBytes());
//            aa.put("dob",dob.getBytes());
//            aa.put("username",user.getBytes());
//            aa.put("password",pass.getBytes());

            FileUploadAsync fua = new FileUploadAsync(q);
            fua.json_response = (JsonResponse) Parentaddimageorvideo.this;
            fua.execute(aa);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Exception upload : " + e, Toast.LENGTH_SHORT).show();
        }
    }

    private void selectImageOption() {

        /*Android 10+ gallery code
        android:requestLegacyExternalStorage="true"*/

        final CharSequence[] items = {"Capture Photo", "Choose from Gallery" ,"Choose From Video", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(Parentaddimageorvideo.this);
        builder.setTitle("Take Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                 if (items[item].equals("Choose From Video")) {
                    //  ftype = "video";
                    newval="video";
                    Intent intent = new Intent();
                    intent.setType("video/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent,"Select Video"),REQUEST_TAKE_GALLERY_VIDEO);


                }
                else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_CODE && resultCode == RESULT_OK && null != data) {

            mImageCaptureUri = data.getData();
            System.out.println("Gallery Image URI : " + mImageCaptureUri);
            //   CropingIMG();

            Uri uri = data.getData();
            Log.d("File Uri", "File Uri: " + uri.toString());
            // Get the path
            //String path = null;
            try {
                path = FileUtils.getPath(this, uri);
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
        } else if (requestCode == CAMERA_PIC_REQUEST && resultCode == Activity.RESULT_OK) {

            try {
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                i1.setImageBitmap(thumbnail);
                byteArray = baos.toByteArray();

                String str = Base64.encodeToString(byteArray, Base64.DEFAULT);
                encodedImage = str;
//                sendAttach1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_TAKE_GALLERY_VIDEO) {
                Uri selectedImageUri = data.getData();

                // OI FILE Manager
                String filemanagerstring = selectedImageUri.getPath();

                // MEDIA GALLERY
//	                selectedImagePath = getPaths(selectedImageUri);
//	                if (selectedImagePath != null) {
//
//	                	Toast.makeText(getApplicationContext(), "Helloo Files", Toast.LENGTH_LONG).show();
//	                    Intent intent = new Intent(User_upload_files.this,
//	                            User_upload_files.class);
//	                    intent.putExtra("path", selectedImagePath);
//	                    startActivity(intent);
//	                }
//	                image = decodeFile(selectedImagePath);
                try {
                    InputStream iStream =   getContentResolver().openInputStream(selectedImageUri);
                    byte[] inputData = getBytes(iStream);
                    Toast.makeText(getApplicationContext(), "Len : " + inputData.length, Toast.LENGTH_LONG).show();
                    byteArray = inputData;
                } catch(Exception e) {}
            }


        }
    }
    public byte[] getBytes(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    @Override
    public void response(JSONObject jo) {

        try {
            String status = jo.getString("status");
            Log.d("pearl", status);


            if (status.equalsIgnoreCase("success")) {
                Toast.makeText(getApplicationContext(), "UPLOAD SUCCESSFULLY", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), Parentaddimageorvideo.class));

            } else {
                // startActivity(new Intent(getApplicationContext(), Useraddcusdet.class));

                Toast.makeText(getApplicationContext(), " failed.TRY AGAIN!!", Toast.LENGTH_LONG).show();
            }
        }

        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
    @Override

    public void onBackPressed()
    {


        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent b=new Intent(getApplicationContext(),Policehome.class);
        startActivity(b);

    }
}
