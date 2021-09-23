package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    // Création d'un tag pour le login
    private static final String TAG;

    static {
        TAG = "MainActivity";
    }


    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Button buttonClick1;
        ImageView firstImage;
        boolean flag;
        int images[] = {R.drawable.dragon, R.drawable.nike, R.drawable.loup};
        final int[] i = {0};

        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: started"); // Log pour vérifier si le MainActivity a bien pu démarrer
        ImageView FirstImage = (ImageView) findViewById(R.id.FirstImage);  // Création de l'imageVue Object : fait le liens avec ActivityMain.xml

        //  Récupération de l'image puis définition dans la vue
        int imageResource = getResources().getIdentifier("@drawable/cat", null, this.getPackageName());
        FirstImage.setImageResource(imageResource);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstImage = (ImageView) findViewById(R.id.FirstImage);
        buttonClick1 = (Button) findViewById(R.id.mybutton1);

        flag = true;

        buttonClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstImage.setImageResource(images[i[0]]);
                i[0]++;
                if (i[0] == 3)
                    i[0] = 0;
            }
        });
    }


    public void buttonClick1(View view) {

        // Change color of button 1
        Button thisButton1 = (Button) findViewById(R.id.mybutton1);
        thisButton1.setBackgroundColor(Color.GREEN);

        //Change color of button 2
        Button thisButton2 = (Button) view;
        thisButton2.setBackgroundColor(Color.BLUE);

        Button thisButton3 = (Button) view;
        thisButton2.setBackgroundColor(Color.RED);
    }





    }


