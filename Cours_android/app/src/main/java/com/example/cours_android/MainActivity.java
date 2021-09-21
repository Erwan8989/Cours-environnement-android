package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  Button b1;
  ImageView iv;
  boolean flag;
  int[] images ={R.drawable.img,R.drawable.img2,};
  int i=0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    iv=(ImageView) findViewById(R.id.img1);
    b1=(Button) findViewById(R.id.button);

    // flag=true;


    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv.setImageResource(images[i]);
        i++;
        if(i==2)
          i=0;
      }
    });
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
  }







}

