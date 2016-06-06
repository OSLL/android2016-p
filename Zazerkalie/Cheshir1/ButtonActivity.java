package com.example.user.okno3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by user on 06.06.2016.
 */
public class ButtonActivity extends MainActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(android.R.layout.activity_main);

        final Button button = (Button) findViewById(android.R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "kek",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}
C:\Users\user\AndroidStudioProjects\Okno3\app\src\main\java\com\example\user\okno3\ButtonActivity.java