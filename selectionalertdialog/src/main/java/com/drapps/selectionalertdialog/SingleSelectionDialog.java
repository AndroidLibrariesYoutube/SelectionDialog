package com.drapps.selectionalertdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SingleSelectionDialog extends AppCompatActivity {

    Dialog dialog;
    private Context context;
    private ArrayList<String> list;
    private String headerTitle = "Select";
    private Boolean isSearchEnabled = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_selection_dialog);
    }

    public void with(Context mContext) {
        this.context = mContext;
    }

    public void setList(ArrayList<String> dataList) {
        this.list = dataList;
    }

    public void setTitle(String mTitle) {
        if (mTitle != null && !mTitle.equals("")) {
            this.headerTitle = mTitle;
        } else {
            this.headerTitle = "Select";
        }
    }

    public void enableSearch(Boolean value) {
        isSearchEnabled = value;
    }

    public void show() {
        //Custom pop up dialog for selecting options
        try {
            dialog = new Dialog(context);
            final View convertView = LayoutInflater.from(context).inflate(R.layout.single_selection_dialog, null);
            dialog.setContentView(convertView);
            TextView tvTitle = convertView.findViewById(R.id.tv_title);
            ImageView imgCancel = convertView.findViewById(R.id.img_cancel_single_dialog);
            tvTitle.setText(headerTitle);
            imgCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
