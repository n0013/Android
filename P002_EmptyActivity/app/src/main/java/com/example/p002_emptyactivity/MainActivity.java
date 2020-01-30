package com.example.p002_emptyactivity;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    TextView t;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "find View-elements");

        t = (TextView) findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        View.OnClickListener onCl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        try {
                            Log.d(TAG, "Click button 1");
                            t.setText(R.string.t1);
                            Toast toast = Toast.makeText(MainActivity.this, "Нажата кнопка 1", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            RelativeLayout toastImage = (RelativeLayout) toast.getView();
                            ImageView imageView = new ImageView(MainActivity.this);
                            imageView.setImageResource(R.drawable.white_folder);
                            toastImage.addView(imageView, 0);

                            toast.show();

                            break;

                        }catch (Exception e){
                            Log.d(TAG, "err", e);
                        }
                    case R.id.button2:
                        Log.d(TAG, "Click button 2");
                        t.setText(R.string.t2);
                        break;

                }


            }
        };


        b1.setOnClickListener(onCl);
        b2.setOnClickListener(onCl);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int i=6/0;
                    b2.setText("result i: " + i);
                }catch (Exception e){
                    Log.d(TAG, "Делить на 0 нельзя!", e);
                }
            }
        });



    }




}
