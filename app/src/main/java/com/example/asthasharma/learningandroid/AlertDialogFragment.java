package com.example.asthasharma.learningandroid;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class AlertDialogFragment extends DialogFragment {
    FragmentInteractionListener listener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener=(FragmentInteractionListener)activity;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        View v=layoutInflater.inflate(R.layout.dialog_view,null);
        final EditText nameEditText=v.findViewById(R.id.name_edit_text);
        final EditText emailEditText=v.findViewById(R.id.email_edit_text);
        final  EditText passwordEditText=v.findViewById(R.id.password_edit_text);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Register");
        builder.setView(v).setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.registerUser(nameEditText.getText().toString(),emailEditText.getText().toString(),passwordEditText.getText().toString());

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

