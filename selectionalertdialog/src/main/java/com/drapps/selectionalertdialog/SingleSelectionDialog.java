package com.drapps.selectionalertdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SingleSelectionDialog extends AppCompatActivity {

    Dialog dialog;
    private Context context;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> temp_data_list = new ArrayList<>();
    private String headerTitle = "Select";
    private Boolean isSearchEnabled = false;
    SingleSelectionAdapter dialogAdapter;
    private String currentField = "", currentValue = "", currentPosition = "", tag = "",hintText="Search here";
    private int headerColor,textColor;
    SingleSelectionListener singleSelectionListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_selection_dialog);
    }

    public SingleSelectionDialog(SingleSelectionListener singleSelectionListener, Context mContext,String mTag) {
        this.singleSelectionListener = singleSelectionListener;
        this.context = mContext;
        this.tag = mTag;
    }


    public void setContent(ArrayList<String> contentProvide) {
        list = contentProvide;
        temp_data_list.clear();
        temp_data_list = contentProvide;
    }

    public void setTitle(String mTitle) {
        if (mTitle != null && !mTitle.equals("")) {
            this.headerTitle = mTitle;
        } else {
            this.headerTitle = "Select";
        }
    }

    public void setTextColor(int color){
        this.textColor = color;
    }

    public void enableSearch(Boolean value,String hint) {
        isSearchEnabled = value;
        hintText = hint;
    }

    public void setColor(int color) {
        headerColor = color;
    }

    public void setSelectedField(String selectedField) {
        currentField = selectedField;
    }

    public void show() {
        //Custom pop up dialog for selecting options
        try {
            dialog = new Dialog(context);
            final View convertView = LayoutInflater.from(context).inflate(R.layout.single_selection_dialog, null);
            dialog.setContentView(convertView);
            TextView tvTitle = convertView.findViewById(R.id.tv_title);
            ImageView imgCancel = convertView.findViewById(R.id.img_cancel_single_dialog);
            final RecyclerView recyclerView = convertView.findViewById(R.id.recycler_single_selection);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(layoutManager);
            LinearLayout header = convertView.findViewById(R.id.linear_single_dialog);
            final EditText etSearch = convertView.findViewById(R.id.et_search_single_selection);
            tvTitle.setText(headerTitle);

            if (isSearchEnabled){
                etSearch.setVisibility(View.VISIBLE);
            }else{
                etSearch.setVisibility(View.GONE);
            }
            if (headerColor != 0) {
                try {
                    header.setBackgroundColor(headerColor);
                    ColorStateList colorStateList = ColorStateList.valueOf(headerColor);
                    ViewCompat.setBackgroundTintList(etSearch, colorStateList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(hintText!=null && !hintText.equals("")){
                etSearch.setHint(hintText);
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
                                    currentValue = temp_data_list.get(position);
                                    currentField = getCurrentField(list.get(position));
                                    currentPosition = getCurrentPosition(currentValue);
                                    singleSelectionListener.onDialogItemSelected(currentValue, Integer.parseInt(currentPosition),tag);
                                }

                                @Override
                                public void onItemLongClick(View view, int position) {
                                    dialog.dismiss();
                                }

                            })
            );

            etSearch.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (etSearch.getText().toString().equals("")) {
                        if (list != null && list.size() > 0) {
                            dialogAdapter = new SingleSelectionAdapter(singleSelectionListener,list, context,tag, currentField,headerColor,textColor);
                            dialogAdapter.notifyDataSetChanged();
                            recyclerView.setAdapter(dialogAdapter);
                        } else {
                            singleSelectionListener.onDialogError("List is empty or null",tag);
                        }


                    } else {
                        getSearch(etSearch.getText().toString(), recyclerView);
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            if (list != null && list.size() > 0) {
                dialogAdapter = new SingleSelectionAdapter(singleSelectionListener,list, context,tag, currentField,headerColor,textColor);
                recyclerView.setAdapter(dialogAdapter);
                dialog.show();
            } else {
                Toast.makeText(context, "List is empty", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getSearch(String search, RecyclerView recyclerView) {
        ArrayList<String> temp_list = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).toLowerCase().contains(search.toLowerCase())) {
                    temp_list.add(list.get(i));

                }
            }
        } else {
            singleSelectionListener.onDialogError("List is empty or null",tag);

        }

        temp_data_list = new ArrayList<>();
        temp_data_list.addAll(temp_list);
        dialogAdapter = new SingleSelectionAdapter(singleSelectionListener,temp_data_list, context, tag,currentField,headerColor,textColor);

        dialogAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(dialogAdapter);


    }

    public String getCurrentField(String field) {
        if (list != null && list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {
                if (field.equals(list.get(i))) {
                    return list.get(i);
                }
            }
        }
        return "";
    }

    public String getCurrentPosition(String field) {
        if (list != null && list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {
                if (field.equals(list.get(i))) {
                    return String.valueOf(i);
                }
            }
        }
        return "";
    }


}
