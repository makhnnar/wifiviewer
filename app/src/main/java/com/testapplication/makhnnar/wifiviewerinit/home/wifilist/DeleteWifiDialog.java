package com.testapplication.makhnnar.wifiviewerinit.home.wifilist;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.testapplication.makhnnar.wifiviewerinit.R;
import com.testapplication.makhnnar.wifiviewerinit.home.wifilist.model.WifiListItemData;

public class DeleteWifiDialog extends DialogFragment implements View.OnClickListener{

    private OnWifiDialogClickListener listener;
    private Button btn_drd_delete_red_yes;
    private Button btn_drd_delete_red_no;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.delete_red_dialog, container, false);

        btn_drd_delete_red_yes = v.findViewById(R.id.btn_drd_delete_red_yes);
        btn_drd_delete_red_no = v.findViewById(R.id.btn_drd_delete_red_no);

        btn_drd_delete_red_yes.setOnClickListener(this);
        btn_drd_delete_red_no.setOnClickListener(this);


        return v;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    public void setListener(OnWifiDialogClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btn_drd_delete_red_yes)){
            Log.i("pos", "---"+(listener != null));
            if (listener != null){
                Log.i("pos", "--- entro");
                listener.onDeletePass();
                this.dismiss();
            }
        }
        if (view.equals(btn_drd_delete_red_no)){
            this.dismiss();
        }

    }

    public interface OnWifiDialogClickListener {

        void onDeletePass();
    }
}
