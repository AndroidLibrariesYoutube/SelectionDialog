package com.drapps.selectionalertdialog;

public interface MultiSelectionListener {
    // you can define any parameter as per your requirement
    public void onMultiDialogItemsSelected(String s, String tag);

    public void onMultiDialogError(String error, String tag);
}

