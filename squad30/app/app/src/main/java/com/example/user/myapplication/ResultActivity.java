package com.example.user.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity {
    ResultActivity m;
    TextView tex2, tex3;
    ImageView img;
    ImageView[] imgcolors = new ImageView[6];
    ImageView[] suggcolors = new ImageView[6];
    String res = "";
    int kk=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Colors");
        setContentView(R.layout.activity_result);
        tex2 = (TextView)findViewById(R.id.textView2);
        tex3 = (TextView)findViewById(R.id.textView3);
        img = (ImageView)findViewById(R.id.imageView);

        imgcolors[0] = (ImageView)findViewById(R.id.imageView2);
        imgcolors[1] = (ImageView)findViewById(R.id.imageView3);
        imgcolors[2] = (ImageView)findViewById(R.id.imageView4);
        imgcolors[3] = (ImageView)findViewById(R.id.imageView5);
        imgcolors[4] = (ImageView)findViewById(R.id.imageView6);
        imgcolors[5] = (ImageView)findViewById(R.id.imageView7);

        suggcolors[0] = (ImageView)findViewById(R.id.imageView8);
        suggcolors[1] = (ImageView)findViewById(R.id.imageView9);
        suggcolors[2] = (ImageView)findViewById(R.id.imageView10);
        suggcolors[3] = (ImageView)findViewById(R.id.imageView11);
        suggcolors[4] = (ImageView)findViewById(R.id.imageView12);
        suggcolors[5] = (ImageView)findViewById(R.id.imageView13);

       /* suggcolors[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                JSONObject obj = new JSONObject(res);
                String tmp = obj.getJSONArray("cl_themes").getJSONObject(kk).getString("colors");
                String[] arr = tmp.replaceAll("\"", "").replaceAll("\\]", "").replaceAll("\\[", "").split(",");
                for(int i = 0; i < arr.length; i++)
                    m.suggcolors[i].setBackgroundColor((int)Long.parseLong("FF" + arr[i], 16));
            } catch (JSONException exc) {
                System.out.println("JSON Exc");
            }


            }
        }); */

        Intent intent = getIntent();
        m = this;
        String path = intent.getStringExtra("path");
        String imageName = intent.getStringExtra("imageName");

        Bitmap myBitmap = BitmapFactory.decodeFile(path);
        img.setImageBitmap(myBitmap);


        AsyncUploadPhoto asyncUploadPhoto = new AsyncUploadPhoto();
        asyncUploadPhoto.setResultActivity(m);
        asyncUploadPhoto.execute("http://62.213.86.130/api-s/api.php", imageName, path);
    }
}
