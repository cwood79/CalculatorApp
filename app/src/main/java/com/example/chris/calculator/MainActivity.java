package com.example.chris.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;
import android.view.*;

import com.example.chris.calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MULT = '*';
    private static final char DIV = '/';
    private static final char MOD = '%';
    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final DecimalFormat decimalFormat = new DecimalFormat("#.##########");

        binding.ZeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });
        binding.OneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });
        binding.TwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "2");
            }
        });
        binding.ThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });
        binding.FourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });

        binding.FiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });
        binding.SixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });
        binding.SevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });
        binding.EightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });
        binding.NineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "9");
            }
        });

        binding.DecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + ".");
            }
        });

        binding.AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeAns();
                CURRENT_ACTION = ADD;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "+");
                binding.editText.setText(null);
            }
        });

        binding.SubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeAns();
                CURRENT_ACTION = SUB;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "-");
                binding.editText.setText(null);
            }
        });

        binding.MultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeAns();
                CURRENT_ACTION = MULT;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "*");
                binding.editText.setText(null);
            }
        });

        binding.DivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeAns();
                CURRENT_ACTION = DIV;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
                binding.editText.setText(null);
            }
        });

        binding.ModButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeAns();
                CURRENT_ACTION = MOD;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
                binding.editText.setText(null);
            }
        });

        binding.EqualsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeAns();
                binding.infoTextView.setText(binding.infoTextView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        binding.ACButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.infoTextView.setText("");
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

    }

    private void computeAns()
    {
        if(!Double.isNaN(valueOne))
        {
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if(CURRENT_ACTION == ADD)
                valueOne = this.valueOne + this.valueTwo;
            else if(CURRENT_ACTION == SUB)
                valueOne = this.valueOne - this.valueTwo;
            else if(CURRENT_ACTION == MULT)
                valueOne = this.valueOne * this.valueTwo;
            else if(CURRENT_ACTION == DIV)
                valueOne = this.valueOne / this.valueTwo;
            else if(CURRENT_ACTION == MOD)
                valueOne = this.valueOne % this.valueTwo;
        }

        else
        {
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            }
            catch(Exception e ) {}
        }
    }
}
