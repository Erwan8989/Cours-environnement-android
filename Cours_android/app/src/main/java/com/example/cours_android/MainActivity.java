package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

  public void over(View view) {
    // Change color of button 1
    Button thisButton1 = (Button) findViewById(R.id.bouton1);
    thisButton1.setBackgroundColor(Color.RED);

    // Change color of button 2
    Button thisButton2 = (Button) findViewById(R.id.bouton2);
    thisButton2.setBackgroundColor(Color.BLUE);

    // Change color of button 3
    Button thisButton3 = (Button) findViewById(R.id.bouton3);
    thisButton3.setBackgroundColor(Color.YELLOW);

    Button thisImage1 = (Image) findViewById(R.id.img2);
    thisImage1.setBackgroundColor(Color.RED);
  }
  public void onClick(View v) {
    button.setBackgroundResource(R.drawable.ic_launcher);

  }
}

