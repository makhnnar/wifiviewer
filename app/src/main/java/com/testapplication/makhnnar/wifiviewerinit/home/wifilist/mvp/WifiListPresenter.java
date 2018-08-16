package com.testapplication.makhnnar.wifiviewerinit.home.wifilist.mvp;

import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model.WifiListItemData;

import java.util.ArrayList;

public class WifiListPresenter implements
        WifiListContract.Presenter,
        WifiListContract.ListWifiResponse
        {

        private WifiListContract.View view;

        private WifiListInteractor interactor;

        private ArrayList<WifiListItemData> mDataset = new ArrayList<>();


    public WifiListPresenter (WifiListContract.View view){
        this.view = view;
        this.interactor = new WifiListInteractor(this);



    }


    @Override
    public void onListWifiSuccess(ArrayList<WifiListItemData> mDataset) {
        if (mDataset != null) {
            //for (int i = 0; i < mDataset.size(); i++)Log.i("cualquiera", "getListaAmigosSuccess:  "+ " "+ mDataset.get(i).getId());
            this.mDataset = mDataset;
            view.getListWifiSuccess(mDataset);

        }
    }

                @Override
    public void onListWifiFailed() {

    }

    @Override
    public void getListWifi() {


    }

    @Override
    public void getPass() {

    }

    public void getListData(){
        interactor.getData();
    }
}



