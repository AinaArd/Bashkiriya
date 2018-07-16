package com.example.simulatorabramskogo.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;

/**
 * Created by ${Aina} on 15.07.2018.
 */
public class InfoDialog extends DialogFragment {

//    MyListener listener;
    TextView textView;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_info,null);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        textView = view.findViewById(R.id.textViewResources);
        adb.setTitle("Подробнее").setMessage("here should be resources").setView(view)
                .setPositiveButton("ОК", (dialog, which) -> {

                        }
//                        listener.mListener()
                );
        return adb.create();

    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof StartActivity) {
//            listener = (MyListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragment1DataListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener = null;
//    }
//
//    public void show(FragmentManager fragmentManager, String dialog) {
//    }
}
