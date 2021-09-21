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
  Button b1, b2, b3;
  ImageView iv;
  int[] images ={R.drawable.img,R.drawable.img2,};
  int i=0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // ***************** Changement de couleur du bouton 1 et avec changement de l'image au clic *****************
    b1 = (Button) findViewById(R.id.bouton1);
    iv=(ImageView) findViewById(R.id.img1);


    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b1.setBackgroundColor(Color.RED);
        iv.setImageResource(images[i]);
        i++;
        if(i==2)
          i=0;
      }
    });

    // ***************** Changement de couleur du bouton 2 et avec changement de l'image au clic *****************
    b2 = (Button) findViewById(R.id.bouton2);
    iv=(ImageView) findViewById(R.id.img1);

    b2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b2.setBackgroundColor(Color.BLUE);;
        iv.setImageResource(images[i]);
        i++;
        if(i==2)
          i=0;
      }
    });

    // ***************** Changement de couleur du bouton 3 et avec changement de l'image au clic *****************
    b3 = (Button) findViewById(R.id.bouton3);
    iv=(ImageView) findViewById(R.id.img1);

    b3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b3.setBackgroundColor(Color.YELLOW);;
        iv.setImageResource(images[i]);
        i++;
        if(i==2)
          i=0;
      }
    });
  }

}

