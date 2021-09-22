package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity2 extends AppCompatActivity {

  Button b4, b5, b6, b7;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_2);


    // ***************** Revenir à l'activity main *****************
    b7 = (Button) findViewById(R.id.bouton7);

    b7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openActivity1();
      }
    });

  }

  public void openActivity1() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

}

