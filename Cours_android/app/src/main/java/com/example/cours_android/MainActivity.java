package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.*;
import java.lang.Thread;

public class MainActivity extends AppCompatActivity {
  Button b1, b2, b3, b8;
  ImageView iv;
  int[] images ={R.drawable.img,R.drawable.img2};
  int i=0;
  MediaPlayer mp;
  int a = 5;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    b1 = (Button) findViewById(R.id.bouton1);
    b2 = (Button) findViewById(R.id.bouton2);
    b3 = (Button) findViewById(R.id.bouton3);
    b8 = (Button) findViewById(R.id.bouton8);
    iv=(ImageView) findViewById(R.id.img1);

    // ***************** Son ambiant qui se lance au démmarage de l'application *****************

    mp = MediaPlayer.create(this, R.raw.son1);
    mp.start();

    // ***************** Changement de couleur du bouton 1, 2 et 3 et avec changement de l'image au clic *****************

    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        //Changement de couleur des boutons
        b1.setBackgroundColor(Color.RED);
        b2.setBackgroundColor(Color.BLUE);
        b3.setBackgroundColor(Color.YELLOW);

        //Changement de l'image
        iv.setImageResource(images[i]);
        i++;
        if(i==2)
          i=0;
      }
    });
    // ***************** Rejouer le son ambiant au clic *****************

    b2 = (Button) findViewById(R.id.bouton2);
    iv=(ImageView) findViewById(R.id.img1);

    b2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        //Rejouer au début le son ambiant

        mp.stop();
        mp = MediaPlayer.create(MainActivity.this, R.raw.son1);
        mp.start();

      }
    });

    // ***************** Changement de page au clic *****************

    b3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // Stop la bande son en cours, afin d'éviter que plusieurs soit lancé en même temps lors du retour sur cette activité
        mp.stop();

        // Appel à la fonction openActivity pour changer de page (activity)
        openActivity2();
      }
    });


    // ***************** Ajouter un thread *****************

    b8.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Thread background = new Thread(new Runnable() {
          public void run() {
              Log.d("Thread test.", "Ceci est une erreur !");

              try {

                Thread.sleep(3000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
        });
        new Thread(background).start();
      }
    });


  }

  public void openActivity2(){
    Intent intent = new Intent(this, Activity2.class);
    startActivity(intent);
  }
}

