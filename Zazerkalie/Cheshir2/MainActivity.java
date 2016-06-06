package com.example.user.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.my_button);

    }

    public void onMyButtonClick(View view) {


        Intent intent = new Intent(this, NameActivity.class);
        startActivity(intent);
    }

}
C:\Users\user\AndroidStudioProjects\App\app\src\main\java\com\example\user\app\MainActivity.java