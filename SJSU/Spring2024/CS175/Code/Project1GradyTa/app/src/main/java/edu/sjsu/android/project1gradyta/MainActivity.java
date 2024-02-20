package edu.sjsu.android.project1gradyta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.math.BigDecimal;

import edu.sjsu.android.project1gradyta.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.calBtn.setOnClickListener(this::calculate);
        binding.unBtn.setOnClickListener(v->uninstall());
        binding.seekBar.setOnSeekBarChangeListener((SeekChangeAdapter) this::seekBarChange);

    }

    public void calculate(View v){
        String pString = binding.pInput.getText().toString();
        if (!pString.isEmpty()){
            double P = Double.parseDouble(pString);
            if (BigDecimal.valueOf(P).scale() > 2){
                binding.result.setText("Please enter a valid number. 2 decimal digits max.\n" +
                        "Then Press CALCULATE for monthly payments");
            }
            else{
                double J = binding.seekBar.getProgress() / 10.0 / 12 / 100;
                int N = getNumOfMonth();
                double T = binding.checkBox.isChecked() ? 0.1/100 * P : 0.0;
                double result = Calculator.calculate(P,J,N,T);
                binding.result.setText("Monthly payment: $" + result);
            }
        }
        else {
            binding.result.setText("Please enter the principle.\n" +
                    "Then Press CALCULATE for monthly payments");
        }
    }

    private void seekBarChange(SeekBar seekBar, int progress, boolean fromUser){
        binding.rate.setText(getString(R.string.interest_rate, progress/10.0));
    }
    private int getNumOfMonth(){
        if (binding.r15.isChecked())
            return 15*12;
        else if (binding.r20.isChecked())
            return 20*12;
        else return 30*12;
    }

    public void uninstall(){
        Intent delete = new Intent(Intent.ACTION_DELETE,
                Uri.parse("package:"+getPackageName()));
        startActivity(delete);
    }


}