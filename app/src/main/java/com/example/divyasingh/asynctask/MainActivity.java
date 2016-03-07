package com.example.divyasingh.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgress;
    ProgressBar mAsyncProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (ProgressBar) findViewById(R.id.loading_spinner);
        mAsyncProgress = (ProgressBar) findViewById(R.id.progress_async);
        mProgress.setProgress(0);
    }

    public void click(View v) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mProgress.setProgress(i);
                }
            }
        }).start();
    }

    public void clickAsync(View v) {
        new Asynctask().execute();
    }

    private class Asynctask extends AsyncTask<String, Integer, String> {

        protected String doInBackground(String... args) {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return "Done";
        }

        @Override
        protected void onPreExecute() {
            Log.v("MainActivity", "onPreExecute is called");
        }

        @Override
        protected void onProgressUpdate(Integer... integer) {
            mAsyncProgress.setProgress(integer[0]);
            Log.v("MainActivity", "onProgressUpdate is called");
        }

        @Override
        protected void onPostExecute(String result) {
            Log.v("MainActivity", result);
        }
    }
}










