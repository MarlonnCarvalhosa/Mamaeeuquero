package com.marlonncarvalhosa.mamaeeuquero.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marlonncarvalhosa.mamaeeuquero.R;

public class DescricaoFragment extends Fragment {


    public DescricaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teste, container, false);
    }

}
