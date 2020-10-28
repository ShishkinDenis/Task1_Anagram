package ru.denisshishin.task1anagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    TextView tvOutput;
    TextInputEditText editText;
    TextInputEditText editTextExceptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput = findViewById(R.id.tvOutput);
        editText = findViewById(R.id.tietInputText);
        editTextExceptions = findViewById(R.id.tietInputExceptionText);
    }

    public static void reverseString(char[] charText, HashSet<Character> setOfExceptions) {
        int r = charText.length - 1;
        int l = 0;

        while (l < r) {
            if (setOfExceptions.contains(charText[l])) {
                l++;
            } else if (setOfExceptions.contains(charText[r])) {
                r--;
            } else {
                char tmp = charText[l];
                charText[l] = charText[r];
                charText[r] = tmp;
                l++;
                r--;
            }
        }
    }

    public void onClick(View view) {
        char[] charText = editText.getEditableText().toString().toCharArray();
        char[] charExceptions = editTextExceptions.getEditableText().toString().toCharArray();

        HashSet<Character> setOfExceptions = new HashSet<>();
        for (char c : charExceptions) {
            setOfExceptions.add(c);
        }

        reverseString(charText,setOfExceptions);
        String reversedString = new String(charText);
        tvOutput.setText(reversedString);
    }
}