package com.example.simulatorabramskogo.activities;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.simulatorabramskogo.R;
/**
 * Created by ${Aina} on 17.07.2018.
 */
public class NotEnoughResourcesDialog extends DialogFragment {

    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_resources, null);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());

        adb.setTitle("Упс!").
                setView(view)
                .setNegativeButton("Ok", (dialog, which) -> dismiss());
        return adb.show();
    }
}
