package com.example.divyasingh.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View v) {
        final ProgressBar pbar = (ProgressBar) findViewById(R.id.loading_spinner);
        pbar.getProgress();

        new Thread(new Runnable() {
            public void run() {
            int i =0;
                for(i=0;i<=100;i++)
                {
                    try{
                    Thread.sleep(50);}
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    pbar.setProgress(i);

                }


            }
        }
        ).start();
        }


    }







