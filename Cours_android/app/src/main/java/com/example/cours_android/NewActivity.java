package com.example.cours_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread;


public class NewActivity extends AppCompatActivity {

    Button b4, b5, b7, b8;

    // Définition du nom de fichier du texte

    private static final String FILE_NAME ="example.txt";
    EditText TextEdit;

    @SuppressLint({"WrongViewCast", "CutPasteId"})


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // ***************** Revenir à l'activity main *****************

        b7 = findViewById(R.id.bouton7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }

            private void openMainActivity() {
            }
        });

        b8 = findViewById(R.id.bouton8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread background = new Thread(new Runnable() {
                    public void run(){
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


        // Input du text //
        TextEdit = findViewById(R.id.TextEdit);

        // Set background color of the text field in Green

           // final RelativeLayout relativeLayout;

            // set button 1 with its id
            b5 = findViewById(R.id.bouton5);
            // set relative layout with its id
        View relativeLayout = findViewById(R.id.TextEdit);
            // onClick function for button 1
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // set the color to relative layout
                    relativeLayout.setBackgroundResource(R.color.cool);
                }
            });
         }

        // Définition des méthodes Saves & Load

    public void Save(View v) {
        String text = TextEdit.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            TextEdit.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
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

    public void Load(View v) {
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

            TextEdit.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    ((FileInputStream) fis).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }





