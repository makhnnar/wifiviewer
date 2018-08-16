package com.testapplication.makhnnar.wifiviewerinit.home.wifilist.mvp;

import android.app.Activity;
import android.util.Log;

import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model.WifiListItemData;

import java.util.ArrayList;

public class WifiListInteractor {

    private WifiListContract.ListWifiResponse response;
    private ArrayList<WifiListItemData> mDataset;


    public WifiListInteractor(WifiListContract.ListWifiResponse response){
        this.response = response;

        for (int i = 0; i < 10; i++) {
            mDataset.add(new WifiListItemData(
                    "nombre " + i,
                    "id " + i,
                    "password " + i,
                    i));
        }


    }

    public void getData(){

        response.onListWifiSuccess(mDataset);

    }
}


