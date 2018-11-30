package com.drapps.selectionalertdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MulitpleSelectionAdapter extends RecyclerView.Adapter<MulitpleSelectionAdapter.MulitpleSelectionHolder> {
    private List<MultiSelection> dataList;
    Context context;
    List<MultiSelection> currentField;
    String assetsTitle = "";

    public class MulitpleSelectionHolder extends RecyclerView.ViewHolder {

        public CheckBox checkBox;

        MulitpleSelectionHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.checkbox_dialog);

        }
    }


    public MulitpleSelectionAdapter(List<MultiSelection> contentList, String title, Context context) {
        this.context = context;
        this.dataList = contentList;
        this.assetsTitle = title;
        checkExist(assetsTitle);

    }

    @Override
    public MulitpleSelectionAdapter.MulitpleSelectionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_multi_selection, parent, false);

        return new MulitpleSelectionAdapter.MulitpleSelectionHolder(itemView);
    }

    public void onBindViewHolder(final MulitpleSelectionAdapter.MulitpleSelectionHolder holder, final int position) {
        holder.checkBox.setText(dataList.get(position).getTitle());


        holder.setIsRecyclable(false);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.checkBox.isChecked()) {
                    dataList.get(position).setCheck(true);
                } else {
                    dataList.get(position).setCheck(false);

                }
            }
        });

        holder.checkBox.setChecked(dataList.get(position).getCheck());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public boolean checkExist(String dataString) {
        if (dataList != null && dataList.size() > 0) {
            for (int i = 0; i < dataList.size(); i++) {
                List<String> assets = new ArrayList<String>(Arrays.asList(assetsTitle.split(",")));
                if (assets != null && assets.size() > 0 && !assetsTitle.equals("")) {
                    for (int j = 0; j < assets.size(); j++) {
                        if (dataList.get(i).getTitle().equals(assets.get(j))) {
                            dataList.get(i).setCheck(true);
                        }
                    }
                }
            }
        }


        return false;
    }

}