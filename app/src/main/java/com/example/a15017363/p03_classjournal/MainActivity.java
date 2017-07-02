package com.example.a15017363.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayList<String> al;
    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = (ListView)findViewById(R.id.lvModule);

        al = new ArrayList<String>();
        al.add("C347");

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
        lvModule.setAdapter(aa);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = al.get(position);
                Intent intent = new Intent(getBaseContext(), DailyGrades.class);
                intent.putExtra("type",selectedType.toString());
                intent.putExtra("email",new String[]{"jason_lim@rp.edu.sg"});


                startActivity(intent);
            }
        });




    }
}
