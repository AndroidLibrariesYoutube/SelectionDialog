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
    private  ArrayList<String> list;
    private  String headerTitle = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_selection_dialog);
    }

    public void with(Context mContext) {
        this.context = mContext;
    }

    public void create(ArrayList<String> dataList) {
        this.list = dataList;
    }

    public void setTitle(String mTitle) {
        if (mTitle != null && !mTitle.equals("")) {
            this.headerTitle = mTitle;
        } else {
            this.headerTitle = "Select";
        }
    }


    public void show() {
        //Custom pop up dialog for selecting options
        dialog = new Dialog(context);
        LayoutInflater inflater = this.getLayoutInflater();
        final View convertView = inflater.inflate(R.layout.single_selection_dialog, null);
        dialog.setContentView(convertView);


        dialog.show();
    }

}
