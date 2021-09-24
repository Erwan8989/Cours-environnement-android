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
    int[] images ={R.drawable.loup,R.drawable.nike,R.drawable.dragon,};
    int i=0;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.mybutton1);
        b2 = (Button) findViewById(R.id.mybutton2);
        b3 = (Button) findViewById(R.id.mybutton3);
        iv=(ImageView) findViewById(R.id.FirstImage);

        // Son ambiant qui se lance au démmarage de l'application

        mp = MediaPlayer.create(this,R.raw.sh);
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

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Rejouer au début le son ambiant
                mp.start();
                mp = MediaPlayer.create(MainActivity.this, R.raw.sh);
                mp.start();

            }
        });

        // ***************** Changement de page au clic *****************

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.stop();

                // Appel à la fonction openActivity pour changer de page (activity)
                openActivity2();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

    public void music() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sh);
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.sh);
            mediaPlayer.start();
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.sh);
            mediaPlayer.start();
        }
    }
}




