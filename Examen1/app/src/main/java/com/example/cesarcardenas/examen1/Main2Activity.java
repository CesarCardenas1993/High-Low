package com.example.cesarcardenas.examen1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class Main2Activity extends AppCompatActivity {
    Spinner F;
    Spinner T;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        F=(Spinner)findViewById(R.id.spinner);
        String[] spfrom = getResources().getStringArray(R.array.Value);
        ArrayAdapter<String> Adap=new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item,spfrom);
        Adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        F.setAdapter(Adap);

        T=(Spinner)findViewById(R.id.spinner2);
        String[] spto = getResources().getStringArray(R.array.Value);
        ArrayAdapter<String> Adapter=new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item,spfrom);
        Adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        T.setAdapter(Adapter);
    }

    public void onClick (View view){
        String spinnerSelectedF=F.getSelectedItem().toString();
        String spinnerSelectedT=T.getSelectedItem().toString();
        SharedPreferences settings= getSharedPreferences("DataBase",0);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString("FString",spinnerSelectedF);
        editor.putString("TString",spinnerSelectedT);
        editor.commit();
        finish();
    }

    }

