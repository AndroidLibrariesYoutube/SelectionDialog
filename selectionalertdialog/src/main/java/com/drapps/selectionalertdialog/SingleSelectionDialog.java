package com.drapps.selectionalertdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SingleSelectionDialog extends AppCompatActivity {

    Dialog dialog;
    private Context context;
    private ArrayList<String> list;
    private String headerTitle = "Select";
    private Boolean isSearchEnabled = false;
    SingleSelectionAdapter dialogAdapter;
    private String currentField = "";
    private int headerColor;


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

    public void setColor(int color) {
        headerColor = color;
    }

    public void show() {
        //Custom pop up dialog for selecting options
        try {
            dialog = new Dialog(context);
            final View convertView = LayoutInflater.from(context).inflate(R.layout.single_selection_dialog, null);
            dialog.setContentView(convertView);
            TextView tvTitle = convertView.findViewById(R.id.tv_title);
            ImageView imgCancel = convertView.findViewById(R.id.img_cancel_single_dialog);
            RecyclerView recyclerView = convertView.findViewById(R.id.recycler_single_selection);
            LinearLayout header = convertView.findViewById(R.id.linear_single_dialog);
            tvTitle.setText(headerTitle);

            if (headerColor != 0) {
                try {
                    header.setBackgroundColor(headerColor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            imgCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(context, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    dialog.dismiss();
                                    currentField = list.get(position);

                                }

                                @Override
                                public void onItemLongClick(View view, int position) {
                                    dialog.dismiss();
                                }

                            })
            );

            if (list != null && list.size() > 0) {
                dialogAdapter = new SingleSelectionAdapter(list, context, currentField);
                recyclerView.setAdapter(dialogAdapter);
                dialog.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
