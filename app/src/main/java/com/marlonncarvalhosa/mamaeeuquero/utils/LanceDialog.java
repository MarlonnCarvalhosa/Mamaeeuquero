package com.marlonncarvalhosa.mamaeeuquero.utils;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.marlonncarvalhosa.mamaeeuquero.R;
import com.marlonncarvalhosa.mamaeeuquero.Views.MainActivity;
import com.marlonncarvalhosa.mamaeeuquero.Views.SplashScreenActivity;
import com.marlonncarvalhosa.mamaeeuquero.fragments.DescricaoFragment;
import com.marlonncarvalhosa.mamaeeuquero.fragments.InicioFragment;
import com.marlonncarvalhosa.mamaeeuquero.model.Produto;

import java.util.Locale;

public class LanceDialog extends AppCompatDialogFragment {

    private EditText valor;
    private Produto produto;
    FirebaseAuth auth;
    String lancedocomprador;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.lance_layout, null);
        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


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

                        produto.recebeLance(valor.getText().toString(),lancedocomprador, user.getUid() );
                        ConfiguraçõesFirebase.getProdutos().getRef().child(produto.getId()).setValue(produto);

                        Toast.makeText(getActivity(), "Lance efetuado com sucesso!", Toast.LENGTH_SHORT).show();

                    }
                });

        valor = view.findViewById(R.id.edit_lance);

        Locale mLocale = new Locale("pt", "BR");
        valor.addTextChangedListener(new MoneyTextWatcher(valor, mLocale));

        return builder.create();
    }



    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}