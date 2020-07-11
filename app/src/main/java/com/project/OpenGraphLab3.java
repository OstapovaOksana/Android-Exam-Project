package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OpenGraphLab3 extends AppCompatActivity {
    String valXY[];
    Double Xval;
    Double Yval;
    GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_graph_lab3);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    openFileInput("Lab3")));
            String mline;

            ArrayList<DataPoint> arrDataPoint=new ArrayList<>();
            while ((mline = reader.readLine()) != null) {
                valXY = mline.split(",");
                Xval = Double.parseDouble(valXY[0]);
                Yval = Double.parseDouble(valXY[1]);
                DataPoint dp = new DataPoint(Xval, Yval);
                arrDataPoint.add(dp);
            }
            DataPoint[] listDp = new DataPoint[arrDataPoint.size()];
            for(int i=0;i<arrDataPoint.size();i++){
                listDp[i]=arrDataPoint.get(i);
            }
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(listDp);
            graph.addSeries(series);
        } catch (IOException e) {
            e.printStackTrace();
        }
        graph.getViewport().setXAxisBoundsManual(true);
    }

    public void Back(View v){
        Intent intent = new Intent(this, Lab3.class);
        startActivity(intent);
    }
}
