package com.example.a15017363.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017363 on 4/5/2017.
 */

public class DailyGradesAdaptor extends ArrayAdapter<DailyCA> {
    private Context context;
    private ArrayList<DailyCA> dailyCA;
    private TextView tvDg;
    private TextView tvGrade;
    private TextView tvWeek;
    public DailyGradesAdaptor(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource, objects);
        dailyCA= objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvDg = (TextView)rowView.findViewById(R.id.tvDG);
        tvGrade = (TextView)rowView.findViewById(R.id.tvGrade);
        tvWeek = (TextView)rowView.findViewById(R.id.tvWeek);

        DailyCA currentGrade = dailyCA.get(position);


        tvWeek.setText("Week "+currentGrade.getWeek());
        tvGrade.setText(currentGrade.getDgGrade());
        tvDg.setText("DG");
        return rowView;
    }


}
