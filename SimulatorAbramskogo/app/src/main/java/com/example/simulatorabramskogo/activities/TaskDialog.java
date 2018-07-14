package com.example.simulatorabramskogo.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;

/**
 * Created by ${Aina} on 14.07.2018.
 */
public class TaskDialog extends DialogFragment {
    MyListener myListenerTask;
    TextView textViewConfirmation;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_task,null);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        textViewConfirmation = view.findViewById(R.id.textViewConfirmation);
        adb.setView(view)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myListenerTask.mListener();
                    }
                }).setNegativeButton("Выберу другое", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return adb.show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof StartActivity) {
            myListenerTask = (MyListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1DataListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myListenerTask = null;
    }
}
