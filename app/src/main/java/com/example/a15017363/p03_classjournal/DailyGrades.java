package com.example.a15017363.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DailyGrades extends AppCompatActivity {

    ListView lvDailyGrades;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCA;
    Button btnInfo, btnAdd1, btnEmail;
    int requestCodeForC347 = 1;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_grades);

        lvDailyGrades = (ListView)this.findViewById(R.id.lvDailyGrades);
        btnAdd1 = (Button)findViewById(R.id.buttonAdd);
        btnInfo = (Button)findViewById(R.id.buttonInfo);
        btnEmail = (Button)findViewById(R.id.buttonEmail);

        dailyCA = new ArrayList<DailyCA>();

        aa = new DailyGradesAdaptor(this, R.layout.row, dailyCA);
        lvDailyGrades.setAdapter(aa);

        Intent i = getIntent();
        type = i.getStringExtra("type");

        final String[] emails = i.getStringArrayExtra("email");

        dailyCA.add(new DailyCA("A","C347",(dailyCA.size()+1)));
        aa.notifyDataSetChanged();


        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DailyGrades.this,AddDailyGrade.class);
                i.putExtra("weekCount",String.valueOf(dailyCA.size()+1));
                //Start activity with requestCodeForSupermanStats to
                //identify it was started by clicking on Superman
                startActivityForResult(i,requestCodeForC347);

            }
        });



        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = "Hi Faci \n\n I am .....\n Please see my remarks so far, Thank You \n\n";
                for (int i = 0; i < dailyCA.size(); i++) {
                    message += " Week : " + dailyCA.get(i).getWeek() + " DG:" + dailyCA.get(i).getDgGrade() + "\n";
                }
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_TEXT, message);
                //Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL, emails[0]);
                email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from C347");
//                email.putExtra(Intent.EXTRA_TEXT,.getText());

                //This MIME type indicates email
                email.setType("message/rfc822");

                //CreateChooser shows user a list of app that can handle
                //this MIME type, which is, email
                startActivity(Intent.createChooser(email,"Choose and Email client"));

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                //Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);

            }
        });

    }


    @Override
    protected  void onActivityResult(int requestCode, int resultcode, Intent data){
        super.onActivityResult(requestCode,resultcode,data);

        //Only handle when 2nd activity closed normally
        //and data contains something
        if(resultcode == RESULT_OK){
                //Get data passed back from 2nd activity
                String newGrade = data.getStringExtra("grades");

                //If it is activity started by clicking
                //Superman, create corresponding String
                if(requestCode == requestCodeForC347){

                    dailyCA.add(new DailyCA(newGrade,type,(dailyCA.size()+1)));
                    aa.notifyDataSetChanged();
                }

//                Toast.makeText(this, statement, Toast.LENGTH_LONG).show();

        }
    }
}
