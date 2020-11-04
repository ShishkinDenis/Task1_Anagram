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
    // String anagram;
    final static String KEY_EDIT_TEXT = "EDIT_TEXT";
    final static String KEY_EDIT_TEXT_EXCEPTIONS = "EDIT_TEXT_EXCEPTIONS";
    final static String KEY_TV_OTPUT = "TV_OTPUT";

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
            if (!editText.getText().toString().isEmpty()) {
                tvOutput.setText(anagram);
            }
            else {
                tvOutput.setText("");
                Toast toast = Toast.makeText(getApplicationContext(),"Вы ничего не ввели",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });*/

        btnReverse.setOnClickListener(v -> {
              if (!editText.getText().toString().isEmpty()) {
                  tvOutput.setText(
                          Anagram.createAnagram(editText.getText().toString(),
                          editTextExceptions.getText().toString()));
              }
              else {
                  tvOutput.setText("");
                  Toast toast = Toast.makeText(getApplicationContext(),"Вы ничего не ввели",
                          Toast.LENGTH_SHORT);
                  toast.show();
              }
          });
    }

     @Override
   protected void onSaveInstanceState(@NonNull Bundle outState) {

         outState.putString(KEY_EDIT_TEXT,editText.getText().toString());
         outState.putString(KEY_EDIT_TEXT_EXCEPTIONS,editTextExceptions.getText().toString());
         outState.putString(KEY_TV_OTPUT,tvOutput.getText().toString());
         super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        editText.setText(savedInstanceState.getString(KEY_EDIT_TEXT));
        editTextExceptions.setText(savedInstanceState.getString(KEY_EDIT_TEXT_EXCEPTIONS));
        tvOutput.setText(savedInstanceState.getString(KEY_TV_OTPUT));


    }
}


