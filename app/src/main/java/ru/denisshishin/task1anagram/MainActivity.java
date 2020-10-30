package ru.denisshishin.task1anagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextView tvOutput;
    TextInputEditText editText;
    TextInputEditText editTextExceptions;
    Button btnReverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput = findViewById(R.id.tvOutput);
        editText = findViewById(R.id.tietInputText);
        editTextExceptions = findViewById(R.id.tietInputExceptionText);
        btnReverse = findViewById(R.id.btnReverse);

        btnReverse.setOnClickListener(v ->
                tvOutput.setText(Anagram.createAnagram(editText.getEditableText().toString(),
                        editTextExceptions.getEditableText().toString())));
    }
    }


