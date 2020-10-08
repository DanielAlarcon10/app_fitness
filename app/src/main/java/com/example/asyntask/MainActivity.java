package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    public Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProgressBar)findViewById(R.id.pb);
        progress.setVisibility(View.INVISIBLE);
        boton = (Button)findViewById(R.id.btn);
        boton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                new task().execute();
            }
        });
    }

    class task extends AsyncTask<String, Void, String>{

        @Override
        public void onPreExecute()
        {
             progress.setVisibility(View.VISIBLE);
        }

        @Override //tarea pesada
        protected String doInBackground(String... strings) {

            for(int i = 0; i <=10; i++)
            {
               try
               {
                    Thread.sleep(1000);
               }
               catch (Exception e)
               {
                    e.printStackTrace();
               }
            }
            return null;
        }

        @Override
        public void onPostExecute(String s)
        {
            progress.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);
        }

    }


}