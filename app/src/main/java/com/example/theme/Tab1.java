package com.example.theme;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class Tab1 extends Fragment {

    private SharedViewModel viewModel;
    private RadioGroup radioGroup;
    String clr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_tab1, container, false);

        radioGroup=(RadioGroup)v.findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @SuppressLint("ResourceType")
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton1:
                        clr = "Red";
                        break;
                    case R.id.radioButton2:
                        clr = "Yellow";
                        break;
                    case R.id.radioButton3:
                        clr = "Blue";
                        break;
                    case R.id.radioButton4:
                        clr = "Violet";
                        break;
                    case R.id.radioButton5:
                        clr = "Indigo";
                        break;
                    case R.id.radioButton6:
                        clr = "Green";
                        break;
                    case R.id.radioButton7:
                        clr = "Purple";
                        break;
                    case R.id.radioButton8:
                        clr = "Pink";
                        break;
                    case R.id.radioButton9:
                        clr = "Black";
                        break;
                    case R.id.radioButton10:
                        clr = "Grey";
                        break;
                }


                viewModel.setText(clr);


            }
        });

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
            }
        });
    }



}
