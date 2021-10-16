package com.example.rotatetranslatezoomimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.easystudio.rotateimageview.RotateZoomImageView;
import com.impulsive.zoomimageview.ZoomImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
public class MainActivity extends AppCompatActivity {
    int RESULT_LOAD_IMG=1;

    RotateZoomImageView iv;
    RelativeLayout playground;
   // SubsamplingScaleImageView imageView1;
  //  ZoomImageView imageView;                               // geeta kumar code



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv = new RotateZoomImageView(getApplicationContext());
        iv.setImageDrawable(getDrawable(R.drawable.sample1));
        playground=findViewById(R.id.playground);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(250, 250);
        lp.addRule(RelativeLayout.BELOW);
        iv.setLayoutParams(lp);
        playground.addView(iv);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return iv.onTouch(v,event);
            }
        });


    //    imageView1=(SubsamplingScaleImageView) findViewById(R.id.imageV1);
    //    imageView=(ZoomImageView) findViewById(R.id.imageV1);


   //   imageView1.setImage(ImageSource.resource(R.drawable.sample));

//        imageView=findViewById(R.id.collageBgView);
//        imageView1=findViewById(R.id.collageVeiw1);
//        imageView1.setOnTouchListener(new View.OnTouchListener() {
//           @Override
//           public boolean onTouch(View view, MotionEvent motionEvent) {
//                return imageView1.onTouchEvent(motionEvent);
//           }
//       });
//
  }
/*
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
    //    ImageView imageView = findViewById(R.id.collageVeiw1);

        if (resultCode == RESULT_OK && reqCode == RESULT_LOAD_IMG) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(MainActivity.this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }

        ///    new code added


        if (resultCode == RESULT_OK && reqCode==5) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (reqCode == 5) {
                // Get the url of the image from data
                Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                // update the preview image in the layout
                imageView.setImageBitmap(selectedImage);
            }
            if (reqCode == 1) {
                Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                // update the preview image in the layout
                imageView.setImageBitmap(selectedImage);
                // Get the url of the image from data
            }
        }

    }
    void imageCamerachooser(){
        Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 5);
    }
    private void takeScreenshot() {
        Date now=new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            //  String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";
            File path=new File(Environment.getExternalStorageDirectory()+"/Android"+Environment.getDataDirectory(),BuildConfig.APPLICATION_ID);
            if(!path.exists()){
                path.mkdir();
            }
            String mPath=Environment.getExternalStorageDirectory()+ "/Android" + Environment.getDataDirectory()+"/"+BuildConfig.APPLICATION_ID;
            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(path,System.currentTimeMillis()+".jpg");

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();


        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }

 */
    /*
    public void SaveToGallery(){
        ImageView imageView=findViewById(R.id.collageVeiw1);
        BitmapDrawable bitmapDrawable=(BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap=bitmapDrawable.getBitmap();

        File file=Environment.getExternalStorageDirectory();
        File dir=new File(file.getAbsolutePath()+ "/MyPics");
        dir.mkdir();
        String filename=String.format("%d.png",System.currentTimeMillis());
        File outfile= new File(dir,filename);
        FileOutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(outfile);


        }catch (Exception e){
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        try {
            outputStream.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

     */
}