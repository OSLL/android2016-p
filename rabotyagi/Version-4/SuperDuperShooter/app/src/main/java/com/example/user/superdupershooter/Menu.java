package com.example.user.superdupershooter;

import android.app.Activity;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.menu);
        Bitmap sound = BitmapFactory.decodeResource(getResources(), R.drawable.sound);
        Bitmap records = BitmapFactory.decodeResource(getResources(), R.drawable.records);
        Bitmap info = BitmapFactory.decodeResource(getResources(), R.drawable.info);

        setContentView(new MenuView(this, pic, sound, records, info,this));

        //setContentView(R.layout.activity_menu);
      //  ImageView myImg= (ImageView)findViewById(R.id.imageView);
       // myImg.setImageResource(R.drawable.menu);

    }

   /* public void oClickLevels(View view) {
        startActivity(new
                Intent(Menu.this, Levels.class));
    }

    public void oClickSurvival (View view) {

    } */

    public void startgame(){
        startActivity(new
                Intent(Menu.this, Survival.class));
    }

    public void showinfo()
    {
        startActivity(new
                Intent(Menu.this, InfoClass.class));
    }
}
