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

public class AddWifiDialog extends DialogFragment implements View.OnClickListener{

    private OnWifiDialogClickListener listener;
    private Button btn_awd_accept;
    private Button btn_awd_cancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_wifi_dialog, container, false);

        btn_awd_accept = v.findViewById(R.id.btn_awd_accept);
        btn_awd_cancel = v.findViewById(R.id.btn_awd_cancel);

        btn_awd_accept.setOnClickListener(this);
        btn_awd_cancel.setOnClickListener(this);


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
        if (view.equals(btn_awd_accept)){
            Log.i("pos", "---"+(listener != null));
            if (listener != null){
                Log.i("pos", "--- entro");
                listener.onPassAcept();
                this.dismiss();
            }
        }
        if (view.equals(btn_awd_cancel)){
            this.dismiss();
        }

    }

    public interface OnWifiDialogClickListener {

        void onPassAcept();
    }
}
