package com.testapplication.makhnnar.wifiviewerinit.home.wifilist.mvp;

import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model.WifiListItemData;

import java.util.ArrayList;

public class WifiListContract {


    public interface  ListWifiResponse {

        void onListWifiSuccess(ArrayList<WifiListItemData> mDataset);
        void onListWifiFailed();


    }

    public interface DeletePass {

        void onDeletePassSuccess();
        void onDeletePassFailed();

    }

    public interface SavePass {

        void onSavePassSuccess();
        void onSavePassFailed();

    }


    public interface Presenter{

        void getListWifi();
        void getPass();

    }

    public interface View{

        void getListWifiSuccess(ArrayList<WifiListItemData> mDataset);
        void getPassSuccess();

    }

}

