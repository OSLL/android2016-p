package com.example.user.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
    }
    public void onMyButtonClick(View view)
    {
        Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
    }

}
