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

public class MultiSelectionDialog extends AppCompatActivity {

    Dialog dialog;
    private Context context;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<MultiSelection> multiList = new ArrayList<>();
    private ArrayList<MultiSelection> temp_data_list = new ArrayList<>();
    private String headerTitle = "Select";
    private Boolean isSearchEnabled = false;
    SingleSelectionAdapter dialogAdapter;
    private String currentField = "", currentValue = "", currentPosition = "", tag = "", hintText = "Search here";
    private int headerColor;
    MultiSelectionListener multiSelectionListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_selection_dialog);
    }

    public MultiSelectionDialog(MultiSelectionListener mMultiSelectionListener, Context mContext, String mTag) {
        this.multiSelectionListener = mMultiSelectionListener;
        this.context = mContext;
        this.tag = mTag;
    }


    public void setContent(ArrayList<String> contentProvide) {
        list = contentProvide;
        temp_data_list.clear();

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                multiList.get(i).setTitle(list.get(i));
                temp_data_list.get(i).setTitle(list.get(i));
            }
        }

    }

    public void setTitle(String mTitle) {
        if (mTitle != null && !mTitle.equals("")) {
            this.headerTitle = mTitle;
        } else {
            this.headerTitle = "Select";
        }
    }

    public void enableSearch(Boolean value, String hint) {
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
            final View convertView = LayoutInflater.from(context).inflate(R.layout.multi_selection_dialog, null);
            dialog.setContentView(convertView);
            TextView tvTitle = convertView.findViewById(R.id.tv_title_multi_dialog);
            ImageView imgDone = convertView.findViewById(R.id.img_done_multi_dialog);
            final RecyclerView recyclerView = convertView.findViewById(R.id.recycler_multi_dialog);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(layoutManager);
            LinearLayout header = convertView.findViewById(R.id.linear_multi_dialog);
//            final EditText etSearch = convertView.findViewById(R.id.et_search_single_selection);
            tvTitle.setText(headerTitle);
//
//            if (isSearchEnabled) {
//                etSearch.setVisibility(View.VISIBLE);
//            } else {
//                etSearch.setVisibility(View.GONE);
//            }
            if (headerColor != 0) {
                try {
                    header.setBackgroundColor(headerColor);
                    ColorStateList colorStateList = ColorStateList.valueOf(headerColor);
//                    ViewCompat.setBackgroundTintList(etSearch, colorStateList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//
//            if (hintText != null && !hintText.equals("")) {
//                etSearch.setHint(hintText);
//            }


            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(context, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {


                                }

                                @Override
                                public void onItemLongClick(View view, int position) {
                                    dialog.dismiss();
                                }

                            })
            );
            imgDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String getAssetsValue = "";
                    String assetValue = "";
                    if (multiList != null && multiList.size() > 0) {
                        for (int i = 0; i < multiList.size(); i++) {
                            if (multiList.get(i).getCheck()) {
                                getAssetsValue += multiList.get(i).getTitle() + ",";
                                assetValue = getAssetsValue.substring(0, getAssetsValue.length() - 1);
                            }
                        }
                        multiSelectionListener.onMultiDialogItemsSelected(assetValue, tag);
                    }

                    dialog.dismiss();

                }
            });
//
//            etSearch.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                    if (etSearch.getText().toString().equals("")) {
//                        if (list != null && list.size() > 0) {
//                            dialogAdapter = new SingleSelectionAdapter(list, context, currentField, headerColor);
//                            dialogAdapter.notifyDataSetChanged();
//                            recyclerView.setAdapter(dialogAdapter);
//                        } else {
//                            singleSelectionListener.onDialogError("List is empty or null", tag);
//                        }
//
//
//                    } else {
//                        getSearch(etSearch.getText().toString(), recyclerView);
//                    }
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//
//                }
////            });
//
//            if (list != null && list.size() > 0) {
//                dialogAdapter = new SingleSelectionAdapter(list, context, currentField, headerColor);
//                recyclerView.setAdapter(dialogAdapter);
//                dialog.show();
//            } else {
//                Toast.makeText(context, "List is empty", Toast.LENGTH_SHORT).show();
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    private void getSearch(String search, RecyclerView recyclerView) {
//        ArrayList<String> temp_list = new ArrayList<>();
//        if (list != null && list.size() > 0) {
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).toLowerCase().contains(search.toLowerCase())) {
//                    temp_list.add(list.get(i));
//
//                }
//            }
//        } else {
//            singleSelectionListener.onDialogError("List is empty or null", tag);
//
//        }
//
//        temp_data_list = new ArrayList<>();
//        temp_data_list.addAll(temp_list);
//        dialogAdapter = new SingleSelectionAdapter(temp_data_list, context, currentField, headerColor);
//
//        dialogAdapter.notifyDataSetChanged();
//        recyclerView.setAdapter(dialogAdapter);
//
//
//    }


}
