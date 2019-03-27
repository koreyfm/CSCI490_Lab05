package com.introtoandroid.csci490_lab05;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText editText, editText2, editText3;

    Button button;

    SharedPreferences sharedPreferences;

    String Name, Password, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        button = (Button) findViewById(R.id.button);


        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPreferences.edit();

        editText.setText(sharedPreferences.getString(Name, ""));

        editText2.setText(sharedPreferences.getString(Password, ""));

        editText3.setText(sharedPreferences.getString(Email, ""));



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String N  = editText.getText().toString();
                String P  = editText2.getText().toString();
                String E = editText3.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name, N);

                editor.putString(Password, P);

                editor.putString(Email, E);

                editor.commit();

                Toast.makeText(MainActivity.this, "Thanks",Toast.LENGTH_LONG).show();
            }
        });

    }
}
