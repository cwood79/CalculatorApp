package com.example.chris.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MULT = '*';
    private static final char DIV = '/';
    private static final char MOD = '%';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void compute()
    {

    }
}
