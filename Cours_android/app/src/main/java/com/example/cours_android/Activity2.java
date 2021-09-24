package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Activity2 extends AppCompatActivity {

  Button b4, b5, b6, b7;
  TextView text;
  EditText input;

    EditText mEditText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_2);



    // ***************** Sauvegarder en mémoire ce qui a été écrit *****************

    b5 = (Button) findViewById(R.id.bouton5);
    input = findViewById(R.id.text);
    b6 = findViewById(R.id.bouton6);
    text = (TextView)findViewById(R.id.textview);
    text.setVisibility(View.GONE);










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

  public void writeMessage(View view){

    String message = input.getText().toString();
    String file_name = "hello_file";
    try {
      FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
      fileOutputStream.write(message.getBytes());
      fileOutputStream.close();
      Toast.makeText(getApplicationContext(), "Message sauvegardé", Toast.LENGTH_LONG).show();
      input.setText("");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void readMessage(View view){
    try {
      String message;
      FileInputStream fileInputStream = openFileInput("hello_file");
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      StringBuffer stringBuffer = new StringBuffer();
      while ((message=bufferedReader.readLine())!=null){
        stringBuffer.append(message +"\n");
      }
      text.setText(stringBuffer.toString());
      text.setVisibility(View.VISIBLE);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

