package com.testapplication.makhnnar.wifiviewerinit.home.wifigraphics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.testapplication.makhnnar.wifiviewerinit.R;
import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model.WifiListItemData;



import java.util.ArrayList;
import java.util.List;

public class WifiGraphicsFragment  extends Fragment

{
    private int pos = -1;

    private ArrayList<WifiListItemData> mDataset = new ArrayList<>();

    List<Entry> entries = new ArrayList<Entry>();

    public static WifiGraphicsFragment newInstance() {

        WifiGraphicsFragment fragment = new WifiGraphicsFragment();

    return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wifi_graphics, container, false);

        //presenter = new ListaAmigosPresenter(this, getActivity());

        LineChart chart = (LineChart) view.findViewById(R.id.chart);

        for (int i = 0; i < 10; i++) {
            mDataset.add(new WifiListItemData("nombre " + i, "mensaje " + i, "foto " + i, i));
        }

        int i = 1;

        for(WifiListItemData data : mDataset) {

            // turn your data into Entry objects
            entries.add(new Entry(i,data.getIntensity()));

            i++;

        }

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh

        return view;
    }


}
