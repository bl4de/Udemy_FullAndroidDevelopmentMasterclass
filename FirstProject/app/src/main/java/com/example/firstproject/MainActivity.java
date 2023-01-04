package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textMain;
    Button btnOne;
    EditText editText;
    ImageView neuromancer;
    CheckBox audiCheckBox;
    CheckBox bmwCheckBox;
    RadioGroup radioGroup;
    RadioButton radioButtonAudiRS5;
    RadioButton radioButtonAudiS5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        neuromancer = findViewById(R.id.neuromancer);
        audiCheckBox = findViewById(R.id.audiCheckBox);
        bmwCheckBox = findViewById(R.id.bmwCheckBox);
        textMain = findViewById(R.id.textMain);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonAudiRS5 = findViewById(R.id.radioButtonAudiRS5);
        radioButtonAudiS5 = findViewById(R.id.radioButtonAudiS5);

        textMain.setText("Hello First App!");

        btnOne = findViewById(R.id.btnOne);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prefix = "";
                if (radioButtonAudiRS5.isChecked()) {
                    prefix = "Audi RS5 ::: ";
                }
                if (radioButtonAudiS5.isChecked()) {
                    prefix = "Audi S5 ::: ";
                }
                textMain.setText(prefix + editText.getText().toString());
            }
        });

        audiCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (audiCheckBox.isChecked()) {
                    textMain.setText("You choose Audi!");
                } else {
                    textMain.setText("Select Audi!");
                }
            }
        });

        bmwCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bmwCheckBox.isChecked()) {
                    textMain.setText("Wrong choice!!!");
                } else {
                    textMain.setText("Select Audi!");
                }
            }
        });
    }
}