package com.testapplication.makhnnar.wifiviewerinit.home.wifigraphics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import com.testapplication.makhnnar.wifiviewerinit.R;
import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model.WifiListItemData;



import java.util.ArrayList;
import java.util.List;

public class WifiGraphicsFragment  extends Fragment

{
    private int pos = -1;

    private ArrayList<WifiListItemData> mDataset = new ArrayList<>();

    private ArrayList<String> etiquetas = new ArrayList<>();


    List<BarEntry> entries = new ArrayList<BarEntry>();

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

        BarChart chart = (BarChart) view.findViewById(R.id.chart);

        for (int i = 0; i < 10; i++) {
            mDataset.add(new WifiListItemData("nombre " + i, "mensaje " + i, "foto " + i, i));
        }

        int i = 1;

        for(WifiListItemData data : mDataset) {
            BarEntry barEntry = new BarEntry(i,data.getIntensity());

            // turn your data into Entry objects
            entries.add(barEntry);

            etiquetas.add("etiqueta " + i);

            i++;

        }


        BarDataSet set = new BarDataSet(entries, "Signal Intensity");

        /*set.setColors(new int[] {
                R.color.colorAccent,
                R.color.colorPrimary,
                R.color.colorPrimaryDark,
                R.color.colorPrimary
        }, getContext());*/


       Legend l = chart.getLegend();



        /*l.setExtra(
                new int[]{
                        R.color.colorAccent,
                        R.color.colorPrimary,
                        R.color.colorPrimaryDark,
                        R.color.colorPrimary,
                        R.color.colorAccent,
                        R.color.colorPrimary,
                        R.color.colorPrimaryDark,
                        R.color.colorPrimary,
                        R.color.colorAccent,
                        R.color.colorPrimary
                },
                new String[]{

                        "etiqueta 1",
                        "etiqueta 2",
                        "etiqueta 3",
                        "etiqueta 4",
                        "etiqueta 5",
                        "etiqueta 6",
                        "etiqueta 7",
                        "etiqueta 8",
                        "etiqueta 9",
                        "etiqueta 10"


        });*/



        l.setFormSize(10f); // set the size of the legend forms/shapes
        l.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        l.setTextSize(12f);
        l.setTextColor(Color.BLACK);
        l.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        l.setYEntrySpace(5f); // set the space between the legend entries on the y-axis

        set.setStackLabels(new String [] {
                "etiqueta 1",
                "etiqueta 2",
                "etiqueta 3",
                "etiqueta 4",
                "etiqueta 5",
                "etiqueta 6",
                "etiqueta 7",
                "etiqueta 8",
                "etiqueta 9",
                "etiqueta 10"


        });

        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh

        /*BarDataSet dataSet = new BarDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);*/


        return view;
    }


}
