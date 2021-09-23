package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
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

    // Son ambiant qui se lance au démmarage de l'application
    MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.son1);
    mediaPlayer.start();

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

    // ***************** Changement de couleur du bouton 2 et avec changement de l'image au clic, et rejouer le son ambiant *****************
    b2 = (Button) findViewById(R.id.bouton2);
    iv=(ImageView) findViewById(R.id.img1);

    b2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // Changement de couleur du bouton et de l'image
        b2.setBackgroundColor(Color.BLUE);;
        iv.setImageResource(images[i]);
        i++;
        if(i==2)
          i=0;

        //Rejouer au début le son ambiant
        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.son1);
        mp.stop();
        mp = MediaPlayer.create(MainActivity.this, R.raw.son1);
        mp.start();
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

        // Appel à la fonction openActivity pour changer de page
        openActivity2();
      }
    });
  }

  public void openActivity2(){
    Intent intent = new Intent(this, Activity2.class);
    startActivity(intent);
  }

}

