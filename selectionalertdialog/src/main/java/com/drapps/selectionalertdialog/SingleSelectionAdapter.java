package com.drapps.selectionalertdialog;

import android.content.Context;
import android.content.res.ColorStateList;
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
    int color;

    public class SingleSelectionHolder extends RecyclerView.ViewHolder {

        public RadioButton radioButton;
        public View line;

        SingleSelectionHolder(View view) {
            super(view);
            radioButton = view.findViewById(R.id.radio_btn_single_selection);
            line = view.findViewById(R.id.view_single_selection);
        }
    }


    public SingleSelectionAdapter(ArrayList<String> contentList, Context context, String currentField, int radioColor) {
        this.context = context;
        this.dataList = contentList;
        this.currentField = currentField;
        this.color = radioColor;
    }

    @Override
    public SingleSelectionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_single_selection, parent, false);

        return new SingleSelectionHolder(itemView);
    }

    public void onBindViewHolder(SingleSelectionHolder holder, int position) {

        if (color != 0) {
            try {
                holder.radioButton.setButtonTintList(ColorStateList.valueOf(color));
                holder.line.setBackgroundColor(color);
            } catch (Exception e) {

            }
        }
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