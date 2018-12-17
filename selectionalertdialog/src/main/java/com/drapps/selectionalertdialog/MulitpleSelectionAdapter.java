package com.drapps.selectionalertdialog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.drapps.selectionalertdialog.MultiSelection;
import com.drapps.selectionalertdialog.MultiSelectionListener;
import com.drapps.selectionalertdialog.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MulitpleSelectionAdapter extends RecyclerView.Adapter<MulitpleSelectionAdapter.MulitpleSelectionHolder> {
    private List<MultiSelection> dataList;
    private Context context;
    private List<MultiSelection> currentField;
    private String selectedItems = "";
    private int color, textColor;
    private MultiSelectionListener multiSelectionListener;
    private String tag = "";

    public class MulitpleSelectionHolder extends RecyclerView.ViewHolder {

        public CheckBox checkBox;
        View line;

        MulitpleSelectionHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.checkbox_dialog);
            line = view.findViewById(R.id.linear_multi_dialog);
        }
    }


    public MulitpleSelectionAdapter(MultiSelectionListener listener, List<MultiSelection> contentList, String title, String dialogTAG, Context context, int checkBoxColor, int textcolor) {
        this.context = context;
        this.dataList = contentList;
        this.color = checkBoxColor;
        this.selectedItems = title;
        this.textColor = textcolor;
        checkExist(selectedItems);
        multiSelectionListener = listener;
        this.tag = dialogTAG;

    }

    @Override
    public MulitpleSelectionAdapter.MulitpleSelectionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_multi_selection, parent, false);

        return new MulitpleSelectionAdapter.MulitpleSelectionHolder(itemView);
    }

    public void onBindViewHolder(final MulitpleSelectionHolder holder, final int position) {
        holder.checkBox.setText(dataList.get(position).getTitle());
        if (color != 0) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.checkBox.setButtonTintList(ColorStateList.valueOf(color));
                }
                holder.line.setBackgroundColor(color);
            } catch (Exception e) {
                if (multiSelectionListener != null) {

                    multiSelectionListener.onMultiDialogError(e.toString(), tag);
                }
            }
        }
        if (textColor != 0) {
            try {
                holder.checkBox.setTextColor(ColorStateList.valueOf(textColor));
            } catch (Exception e) {
                if (multiSelectionListener != null) {

                    multiSelectionListener.onMultiDialogError(e.toString(), tag);
                }
            }
        }


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
                List<String> assets = new ArrayList<String>(Arrays.asList(selectedItems.split(",")));
                if (assets != null && assets.size() > 0 && !selectedItems.equals("")) {
                    for (int j = 0; j < assets.size(); j++) {
                        if (dataList.get(i).getTitle().equals(assets.get(j))) {
                            dataList.get(i).setCheck(true);
                        }
                    }
                }
            }
        } else {
            if (multiSelectionListener != null) {

                multiSelectionListener.onMultiDialogError("List is null or empty", tag);
            }
        }


        return false;
    }

}