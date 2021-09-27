package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

  Button b4, b5, b6, b7;
  TextView textview;
  EditText input;

  private static final String FILE_NAME = "hello_file.txt";

  // Instantiate the RequestQueue.
  //RequestQueue queue = Volley.newRequestQueue(this);
  String url ="https://api.github.com/zen";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_2);





    b5 = (Button) findViewById(R.id.bouton5);
    input = findViewById(R.id.text);
    b6 = findViewById(R.id.bouton6);
    textview = (TextView)findViewById(R.id.textview);



    // ***************** Revenir à l'activity main *****************

    b7 = (Button) findViewById(R.id.bouton7);

    b7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openActivity1();
      }
    });





    b4 = (Button) findViewById(R.id.bouton4);

    b4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        httpCall("https://api.github.com/zen");
      }
    });

  }

  public void httpCall(String url) {

    RequestQueue queue = Volley.newRequestQueue(this);

    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
      new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
          textview.setText("Response is: "+ response.substring(0,500));
          Log.e(this.getClass().toString(), "Request successful!");
        }
      }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        textview.setText("That didn't work!");
        Log.e(this.getClass().toString(), "Erreur!");
      }
    });

    queue.add(stringRequest);

  }

  // ***************** Changement de page au clic *****************

  public void openActivity1() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }


  // ***************** Ecrire un message dans zone de texte, et l'enregistrer *****************

  public void writeMessage(View v){
    String text = input.getText().toString();
    FileOutputStream fos = null;
    try {
      fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
      fos.write(text.getBytes());
      input.getText().clear();
      //Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
        //Toast.LENGTH_LONG).show();
      Toast.makeText(this, "Texte enregistré",
          Toast.LENGTH_LONG).show();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }


  // ***************** Lire et afficher le texte enregistré en mémoire *****************

  public void readMessage(View v){

  FileInputStream fis = null;
        try {
    fis = openFileInput(FILE_NAME);
    InputStreamReader isr = new InputStreamReader(fis);
    BufferedReader br = new BufferedReader(isr);
    StringBuilder sb = new StringBuilder();
    String text;
    while ((text = br.readLine()) != null) {
      sb.append(text).append("\n");
    }
    input.setText(sb.toString());
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    if (fis != null) {
      try {
        fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
}

