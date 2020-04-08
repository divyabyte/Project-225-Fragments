package com.example.theme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Tab3 extends Fragment {

    EditText textmsg;
    ImageView cross;
    static final int READ_BLOCK_SIZE = 100;
    Button writebtn, readbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_tab3, container, false);

        textmsg=(EditText)v.findViewById(R.id.editText1);
        cross = v.findViewById(R.id.cross);
        writebtn = v.findViewById(R.id.button1);
        readbtn = v.findViewById(R.id.button2);

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textmsg.setText("");
            }
        });

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
            FileOutputStream fos = getActivity().openFileOutput("NewFile.txt",
                    Context.MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fos);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();


            textmsg.setText("");
            Toast.makeText(getActivity(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

            }
        });

        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
            FileInputStream fileIn= getActivity().openFileInput("NewFile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }

            }
        });

        return  v;
    }



}
