package com.example.cesarcardenas.examen1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        String F;
        String T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences settings = getSharedPreferences("DataBase",0);
        F=settings.getString("FString","Usd");
        T=settings.getString("TString","Mxn");
        ((TextView)findViewById(R.id.textView4)).setText(F);
        ((TextView)findViewById(R.id.textView5)).setText(T);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences settings= getSharedPreferences("DataBase",0);
        F=settings.getString("FString","Usd");
        T=settings.getString("TString","Mxn");
        ((TextView)findViewById(R.id.textView4)).setText(F);
        ((TextView)findViewById(R.id.textView5)).setText(T);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Change(View view) {
        startActivity(new Intent("com.example.cesarcardenas.Activity2"));
    }
    public void scbtn(View view) {
        double multiple=0.0;
    EditText et=(EditText)findViewById(R.id.editText);
    if(et.getText().toString().equals("")){
        Toast.makeText(this, "Put Value",Toast.LENGTH_LONG).show();
    }
    else {
        String From= ((TextView)findViewById(R.id.textView4)).getText().toString();
        String To= ((TextView)findViewById(R.id.textView5)).getText().toString();
        if(From.equals("Usd")){
            if(To.equals("Usd")){
                multiple=1;
            }
            if(To.equals("Mex")){
                multiple=18.81;
            }
            if(To.equals("Eur")){
                multiple=.8851;
            }
        }
        if(From.equals("Mex")){
            if(To.equals("Usd")){
                multiple=.05317;
            }
            if(To.equals("Mex")){
                multiple=1;
            }
            if(To.equals("Eur")){
                multiple=.04708;
            }
        }
        if(From.equals("Eur")){
            if(To.equals("Usd")){
                multiple=1.129;
            }
            if(To.equals("Mex")){
                multiple=21.23;
            }
            if(To.equals("Eur")){
                multiple=1;
            }
        }
        double res= Double.parseDouble(((EditText) findViewById(R.id.editText)).getText().toString());
    Toast.makeText(this, String.valueOf((res * multiple)),Toast.LENGTH_LONG).show();
    }
    }
}
