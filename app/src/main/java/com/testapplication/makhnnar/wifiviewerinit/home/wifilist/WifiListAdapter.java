package com.testapplication.makhnnar.wifiviewerinit.home.wifilist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.testapplication.makhnnar.wifiviewerinit.R;
import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model.WifiListItemData;

import java.util.ArrayList;

public class WifiListAdapter extends RecyclerView.Adapter<WifiListAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<WifiListItemData> mDataset;
    private OnItemClickListener listener;


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_wli_nombre_wifi;
        TextView tv_wli_pass;
        ImageView iv_wli_foto_signal;
        ImageView iv_wli_add;
        ImageView iv_wli_delete;
        ImageView iv_wli_ver_pass;


        ViewHolder(View v) {
            super(v);

            tv_wli_nombre_wifi = v.findViewById(R.id.tv_wli_nombre_wifi);
            tv_wli_pass = v.findViewById(R.id.tv_wli_pass);
            iv_wli_foto_signal = v.findViewById(R.id.iv_wli_foto_signal);
            iv_wli_add = v.findViewById(R.id.iv_wli_add);
            iv_wli_delete = v.findViewById(R.id.iv_wli_delete);
            iv_wli_ver_pass = v.findViewById(R.id.iv_wli_ver_pass);

        }
    }


    public WifiListAdapter(Context context, ArrayList<WifiListItemData> myDataset) {
        mDataset = myDataset;
        mContext = context;

        Log.i("cualquiera", "WifiListAdapter: " + mDataset.size());
    }

    @NonNull
    @Override
    public WifiListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wifi_list_item, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.i("cualquiera", "onBindViewHolder: " + mDataset.get(position).toString());

        holder.tv_wli_nombre_wifi.setText(mDataset.get(position).getNombre());
        holder.tv_wli_pass.setText(mDataset.get(position).getPassword());


        holder.tv_wli_nombre_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnConnect(mDataset.get(position));
                }
            }
        });

        holder.iv_wli_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnAddRedWifi((position));
                }
            }
        });

        holder.iv_wli_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnDeleteRedWifi((position));
                }
            }
        });

        holder.iv_wli_ver_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnSeePass((position));
                }
            }
        });

    }

    public void deleteRedWifi(int position) {
        if (position > -1) {
            mDataset.remove(position);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void OnAddRedWifi(int pos);

        void OnDeleteRedWifi(int pos);

        void OnSeePass(int pos);

        void OnConnect(WifiListItemData wifiListItemData);

    }











}
