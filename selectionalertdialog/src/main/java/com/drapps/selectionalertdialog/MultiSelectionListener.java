package com.drapps.selectionalertdialog;


import java.util.ArrayList;

public interface MultiSelectionListener {
    // you can define any parameter as per your requirement
    public void onMultiDialogItemsSelected(String s, String tag, ArrayList<String> selectedItemList);

    public void onMultiDialogError(String error, String tag);
}

