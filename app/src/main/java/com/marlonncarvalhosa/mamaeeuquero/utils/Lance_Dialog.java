package com.marlonncarvalhosa.mamaeeuquero.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.marlonncarvalhosa.mamaeeuquero.R;

import java.util.Locale;

public class Lance_Dialog extends AppCompatDialogFragment {
    private EditText valor;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.lance_layout, null);

        //Locale mLocale = new Locale("pt", "BR");
        //valor.addTextChangedListener(new MoneyTextWatcher(valor, mLocale));

        builder.setView(view)
                .setTitle("De seu Lance!")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Dar Lance", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


        valor = view.findViewById(R.id.edit_lance);

        return builder.create();
    }
}
