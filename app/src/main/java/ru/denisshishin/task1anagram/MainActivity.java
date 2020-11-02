package ru.denisshishin.task1anagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.security.Key;

public class MainActivity extends AppCompatActivity {
    TextView tvOutput;
    EditText editText, editTextExceptions;
    Button btnReverse;
    //String anagram;
    final static String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput = findViewById(R.id.tvOutput);
        editText = findViewById(R.id.tietInputText);
        editTextExceptions = findViewById(R.id.tietInputExceptionText);
        btnReverse = findViewById(R.id.btnReverse);

        /*anagram = Anagram.createAnagram(editText.getText().toString(),
        editTextExceptions.getText().toString());

        btnReverse.setOnClickListener(v -> {
            tvOutput.setText(anagram);
        });*/

          btnReverse.setOnClickListener(v -> {
              if (!editText.getText().toString().isEmpty()) {
                  tvOutput.setText(
                          Anagram.createAnagram(editText.getText().toString(),
                          editTextExceptions.getText().toString()));
              }
              else {
                  Toast toast = Toast.makeText(getApplicationContext(),"Вы ничего не ввели",
                          Toast.LENGTH_SHORT);
                  toast.show();
              }
          });
    }

     @Override
   protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY,Anagram.createAnagram(editText.getEditableText().toString(),
                editTextExceptions.getEditableText().toString()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvOutput.setText(Anagram.createAnagram(editText.getEditableText().toString(),
                editTextExceptions.getEditableText().toString()));
    }
}


