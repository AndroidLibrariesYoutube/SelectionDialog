package com.drapps.selectionalertdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MultiSelectionDialog extends AppCompatActivity {

    Dialog dialog;
    private Context context;
    private ArrayList<MultiSelection> list = new ArrayList<>();
    private ArrayList<String> temp_data_list = new ArrayList<>();
    private String headerTitle = "Select";
    private Boolean isSearchEnabled = false;
    SingleSelectionAdapter dialogAdapter;
    private String currentField = "";
    private int headerColor;
    SingleSelectionListener singleSelectionListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_selection_dialog);
    }

    public MultiSelectionDialog(SingleSelectionListener singleSelectionListener) {
        this.singleSelectionListener = singleSelectionListener;
    }

    public void with(Context mContext) {
        this.context = mContext;
    }

    public void setList(ArrayList<String> dataList) {

        temp_data_list.clear();
        this.temp_data_list = dataList;
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


//    public void show() {
//        //Custom pop up dialog for selecting options
//        try {
//            dialog = new Dialog(context);
//            final View convertView = LayoutInflater.from(context).inflate(R.layout.multi_selection_dialog, null);
//            dialog.setContentView(convertView);
//            TextView tvTitle = convertView.findViewById(R.id.tv_title);
//            ImageView imgDone = convertView.findViewById(R.id.img_done_multi_dialog);
//            final RecyclerView recyclerView = convertView.findViewById(R.id.recycler_multi_dialog);
//            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
//            recyclerView.setLayoutManager(layoutManager);
//            LinearLayout header = convertView.findViewById(R.id.linear_multi_dialog);
//            final EditText etSearch = convertView.findViewById(R.id.et_search_single_selection);
//            tvTitle.setText(headerTitle);
//
//            if (headerColor != 0) {
//                try {
//                    header.setBackgroundColor(headerColor);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            imgDone.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String getAssetsValue = "";
//                    String assetValue = "";
//                    if (list != null && list.size() > 0) {
//                        for (int i = 0; i < list.size(); i++) {
//                            if (list.get(i).getCheck()) {
//                                getAssetsValue += list.get(i).getTitle() + ",";
//                                assetValue = getAssetsValue.substring(0, getAssetsValue.length() - 1);
//                            }
//                        }
//                    }
//                    if (getAssetsValue.equals("")) {
//
//
//                    } else {
//
//                    }
//                    dialog.dismiss();
//
//                }
//            });
//            recyclerView.addOnItemTouchListener(
//                    new RecyclerItemClickListener(context, recyclerView,
//                            new RecyclerItemClickListener.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(View view, int position) {
//                                    dialog.dismiss();
//                                    singleSelectionListener.onDialogItemSelected(currentField, position,tag);
//                                }
//
//                                @Override
//                                public void onItemLongClick(View view, int position) {
//                                    dialog.dismiss();
//                                }
//
//                            })
//            );
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
////                            dialogAdapter = new SingleSelectionAdapter(list, context, currentField);
//                            dialogAdapter.notifyDataSetChanged();
//                            recyclerView.setAdapter(dialogAdapter);
//                        } else {
//                            singleSelectionListener.onDialogError("List is empty or null");
//                        }
//
//
//                    } else {
////                        getSearchCountryList(etSearch.getText().toString(), recyclerView);
//                    }
//
//
//                }
//
//
//                @Override
//                public void afterTextChanged(Editable s) {
//
//                }
//            });
//
//            if (list != null && list.size() > 0) {
////                dialogAdapter = new SingleSelectionAdapter(list, context, currentField);
//                recyclerView.setAdapter(dialogAdapter);
//                dialog.show();
//            } else {
//                Toast.makeText(context, "List is empty", Toast.LENGTH_SHORT).show();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

//    private void getSearchCountryList(String search, RecyclerView recyclerView) {
//        ArrayList<String> temp_list = new ArrayList<>();
//        if (list != null && list.size() > 0) {
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).toLowerCase().contains(search.toLowerCase())) {
//                    temp_list.add(list.get(i));
//
//                }
//            }
//        } else {
//            singleSelectionListener.onError("List is empty or null");
//
//        }
//
//        tempCountryList.clear();
//        tempCountryList.addAll(temp_list);
//
//        dialogAdapter = new RadioDialogAdapter(tempCountryList, context, currentField);
//        dialogAdapter.notifyDataSetChanged();
//        recyclerView.setAdapter(dialogAdapter);
//
//
//    }


}
