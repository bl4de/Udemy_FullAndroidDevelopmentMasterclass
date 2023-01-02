package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textMain;
    Button btnOne;
    EditText editText;
    ImageView neuromancer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        neuromancer = findViewById(R.id.neuromancer);
        textMain = findViewById(R.id.textMain);
        textMain.setText("Hello First App!");

        btnOne = findViewById(R.id.btnOne);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textMain.setText(editText.getText().toString());
                neuromancer.setVisibility(View.INVISIBLE);
            }
        });
    }
}