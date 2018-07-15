package com.example.simulatorabramskogo.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.simulatorabramskogo.R;

/**
 * Created by ${Aina} on 11.07.2018.
 */
public class DescriptionDialog extends DialogFragment {

    MyListener myListener;
    TextView textViewDesc;

    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog,null);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        textViewDesc = view.findViewById(R.id.textViewDescription);
        adb.setTitle("Описание").setView(view)
                .setPositiveButton("Понятно", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myListener.mListener();
                    }
                });
        return adb.show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof StartActivity) {
            myListener = (MyListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1DataListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myListener = null;
    }
}
