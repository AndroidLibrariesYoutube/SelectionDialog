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
    private static Context context;
    private static ArrayList<String> list;
    private static String title = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_selection_dialog);
    }

    public static void with(Context mContext) {
        context = mContext;
    }

    public static void create(ArrayList<String> dataList) {
        list = dataList;
    }

    public static void setTitle(String mTitle) {
        if (mTitle != null && !mTitle.equals("")) {
            title = mTitle;
        } else {
            title = "Select";
        }
    }


    public void show() {
        //Custom pop up dialog for selecting options
        dialog = new Dialog(context);
        LayoutInflater inflater = getLayoutInflater();
        final View convertView = inflater.inflate(R.layout.single_selection_dialog, null);
        dialog.setContentView(convertView);


        dialog.show();
    }

}
