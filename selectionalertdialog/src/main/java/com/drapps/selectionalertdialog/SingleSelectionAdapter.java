package com.drapps.selectionalertdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SingleSelectionAdapter extends RecyclerView.Adapter<SingleSelectionAdapter.SingleSelectionHolder> {
    private List<String> dataList = new ArrayList<>();
    Context context;
    String currentField;

    public class SingleSelectionHolder extends RecyclerView.ViewHolder {

        public RadioButton radioButton;


        SingleSelectionHolder(View view) {
            super(view);
            radioButton = view.findViewById(R.id.radio_btn_single_selection);

        }
    }


    public SingleSelectionAdapter(ArrayList<String> contentList, Context context, String currentField) {
        this.context = context;
        this.dataList = contentList;
        this.currentField = currentField;

    }

    @Override
    public SingleSelectionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_single_selection, parent, false);

        return new SingleSelectionHolder(itemView);
    }

    public void onBindViewHolder(SingleSelectionHolder holder, int position) {
        if (dataList.get(position).equals(currentField)) {
            holder.setIsRecyclable(false);
            holder.radioButton.setChecked(true);

        } else {
            holder.radioButton.setChecked(false);
        }

        holder.radioButton.setText(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}