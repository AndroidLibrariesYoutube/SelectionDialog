package com.drapps.selectionalertdialog;

public interface SingleSelectionListener {
    // you can define any parameter as per your requirement
    public void onDialogItemSelected(String s, int position, String tag);

    public void onDialogError(String error, String tag);
}

