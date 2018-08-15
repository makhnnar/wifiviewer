package com.testapplication.makhnnar.wifiviewerinit.home.wifilist;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testapplication.makhnnar.wifiviewerinit.R;
import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model.WifiListItemData;

import java.util.ArrayList;

public class WifiListFragment extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener,
        WifiListAdapter.OnItemClickListener,
        AddWifiDialog.OnWifiDialogClickListener

{

    private RecyclerView rv_fwl_list_wifi;

    private LinearLayoutManager mLayoutManager;

    private WifiListAdapter wifiListAdapter;

    private int pos = -1;

    private ArrayList<WifiListItemData> mDataset = new ArrayList<>();

    private SwipeRefreshLayout wrl_fwl_reload;

    public static WifiListFragment newInstance() {
        WifiListFragment fragment = new WifiListFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wifi_list, container, false);

        //presenter = new ListaAmigosPresenter(this, getActivity());

        rv_fwl_list_wifi = view.findViewById(R.id.rv_fwl_list_wifi);
        wrl_fwl_reload = view.findViewById(R.id.wrl_fwl_reload);
        wrl_fwl_reload.setOnRefreshListener(this);


        mLayoutManager = new LinearLayoutManager(getContext());

        rv_fwl_list_wifi.setLayoutManager(mLayoutManager);

        for (int i = 0; i < 10; i++) {
            mDataset.add(new WifiListItemData(
                    "nombre " + i,
                    "mensaje " + i,
                    "foto " + i,
                    i));
        }

        wifiListAdapter = new WifiListAdapter(getContext(), mDataset);
        wifiListAdapter.setListener(this);


        rv_fwl_list_wifi.setAdapter(wifiListAdapter);


        return view;
    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void OnAddRedWifi(int pos) {
        this.pos = pos;
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        ft.addToBackStack(null);
        AddWifiDialog dialogFragment = new AddWifiDialog();
        dialogFragment.setListener(this);
        dialogFragment.show(ft, "dialog");

    }

    @Override
    public void OnDeleteRedWifi(int pos) {
        wifiListAdapter.deleteRedWifi(pos);
        pos = -1;

    }

    @Override
    public void OnSeePass(int pos) {

    }

    @Override
    public void OnConnect(WifiListItemData wifiListItemData) {


    }

    @Override
    public void onPassAcept() {

    }
}
