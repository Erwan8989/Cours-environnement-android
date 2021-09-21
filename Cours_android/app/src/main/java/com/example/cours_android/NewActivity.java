package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NewActivity extends AppCompatActivity {
    Button buttonClick1;
    ImageView firstImage;
    boolean flag;
    int images[] = {R.drawable.dragon, R.drawable.nike, R.drawable.loup};
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstImage = (ImageView) findViewById(R.id.FirstImage);
        buttonClick1 = (Button) findViewById(R.id.mybutton1);

        flag = true;

        buttonClick1.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View v){
                firstImage.setImageResource(images[i]);
                i++;
                if (i == 3)
                    i = 0;
            }
        });
    }
}