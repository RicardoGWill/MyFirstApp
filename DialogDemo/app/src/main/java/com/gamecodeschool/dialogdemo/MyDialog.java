package com.gamecodeschool.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class MyDialog extends DialogFragment {

    @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Use the Builder class because this dialog has a simple UI
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Dialog will have "Make a selection" as the title

        builder.setMessage("Make a selection")

                //An OK button that does nothing
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //Nothing happens here
                    }
                })

                //A "Cancel" button that does nothing
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                //Nothing happening here either

            }
        });

        //Create the object and return it
        return builder.create();

    }//End onCreateDialog




}
