package com.example.asthasharma.learningandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by admin on 8/23/2016.
 */
public class AlertDialogFragment extends DialogFragment {

    FragmentInteractionListener listener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (FragmentInteractionListener)activity;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View v =  layoutInflater.inflate(R.layout.dialog_view,null);
        final EditText nameEditText= (EditText) v.findViewById(R.id.name_edit_ext);
        final EditText emailEditText= (EditText) v.findViewById(R.id.email_edit_ext);
        final EditText numberEditText= (EditText) v.findViewById(R.id.number_edit_ext);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Register");
        builder.setView(v).setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.registerUser(nameEditText.getText().toString(),emailEditText.getText().toString(),numberEditText.getText().toString());
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
