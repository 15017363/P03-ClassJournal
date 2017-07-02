package com.example.a15017363.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddDailyGrade extends AppCompatActivity {

    RadioGroup rgGrades;
    Button btnSubmit;
    TextView tvWeeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily_grade);

        btnSubmit = (Button)findViewById(R.id.buttonSubmit);

        tvWeeks = (TextView)findViewById(R.id.tvWeeks);

        rgGrades = (RadioGroup)findViewById(R.id.rgGrades);

        Intent i = getIntent();
//        DailyCA newDG = (DailyCA) i.getSerializableExtra("grades");


        final String week = i.getStringExtra("weekCount");;

        tvWeeks.setText("Week "+week);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButton = rgGrades.getCheckedRadioButtonId();
                RadioButton rbSelected = (RadioButton)findViewById(selectedButton);

                final String grade = rbSelected.getText().toString();
                Intent i = new Intent();
                //Put hero object in intent
                i.putExtra("grades", grade);
                //Start activity with requestCodeForSupermanStats to
                //identify it was started by clicking on Superman
                setResult(RESULT_OK,i);
                finish();

            }
        });


    }
}
