package com.example.theme;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Tab2 extends Fragment {

    LinearLayout linearLayout;
    private SharedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);


        linearLayout = v.findViewById(R.id.layoutTab);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
                if(charSequence=="Red")
                {
                    linearLayout.setBackgroundColor(Color.RED);
                }
                else if(charSequence == "Yellow")
                {
                    linearLayout.setBackgroundColor(Color.YELLOW);
                }
                else if(charSequence == "Blue")
                {
                    linearLayout.setBackgroundColor(Color.BLUE);
                }
                else if(charSequence == "Violet")
                {
                    linearLayout.setBackgroundColor(Color.rgb(238,130,238));
                }
                else if(charSequence == "Indigo")
                {
                    linearLayout.setBackgroundColor(Color.rgb(75,0,130));
                }
                else if(charSequence == "Green")
                {
                    linearLayout.setBackgroundColor(Color.GREEN);
                }
                else if(charSequence == "Purple")
                {
                    linearLayout.setBackgroundColor(Color.rgb(128,0,128));
                }
                else if(charSequence == "Pink")
                {
                    linearLayout.setBackgroundColor(Color.rgb(255,192,203));
                }
                else if(charSequence == "Black")
                {
                    linearLayout.setBackgroundColor(Color.BLACK);
                }
                else if(charSequence == "Grey")
                {
                    linearLayout.setBackgroundColor(Color.rgb(128,128,128));
                }

            }
        });
    }

}
