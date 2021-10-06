package com.example.class_7c_asynccalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tv_display);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsyncCalculation();
            }
        });
    }

    private void startAsyncCalculation() {
        // excute(1, 100_000_000)
        AsyncCalculateTask task = new AsyncCalculateTask();
        task.execute(1, 1_000_000_000);

    }

    class AsyncCalculateTask extends AsyncTask<Integer, Integer, Integer> {
        /**
         * 순서
         * onPreExecute(UI) -> doInBackground(TASK) -> onProgressUpdate(UI, 선택사항) -> onPostExecute(UI)
         **/

        /**
         * UI Thread
         **/
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * Async Thread Method
         **/
        @Override
        protected Integer doInBackground(Integer... integers) {

            int number = integers[0];
            int count = integers[1];
            int result = 0;

            int persentUnit = count / 100;

            for (int i = 0; i < count; i++) {
                result += number;

                if (result % persentUnit == 0) {
                    // 1%, 2%, ... 100%
                    publishProgress(result / persentUnit);
                }
            }

            return result;
        }

        /**
         * UI Thread
         **/
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvDisplay.setText(values[0] + "%");

        }


        /**
         * UI Thread
         **/
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            tvDisplay.setText("Result : " + integer);
        }
    }
}