package com.example.wordcounterdovydo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    TextView tvResults;
    Spinner spSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spSelection = (Spinner) findViewById(R.id.spSelection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.multiple_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSelection.setAdapter(adapter);

        this.edUserInput = findViewById(R.id.edUserInput);
        this.tvResults = findViewById(R.id.tvResults);

    }

    public void btnCountClick(View view) {
        String phrase = edUserInput.getText().toString();

        Toast.makeText(this,phrase , Toast.LENGTH_SHORT).show();

        String selectedOption = this.spSelection.getSelectedItem(). toString();
        if(selectedOption.equalsIgnoreCase("Chars")){
            int charsCount = TextCounter.getCharsCount(phrase);
            this.tvResults.setText(String.valueOf("Character count: " + charsCount));
        }
        else if(TextUtils.isEmpty(phrase)) {
                edUserInput.setError("0");
                return;
        }

        else {
            String[] words = phrase.split("\\s+");
            int wordCount = words.length;
            tvResults.setText("Word count: " + wordCount);
            Log.i("wordcount", "Word count: " + wordCount);
        }
    }
}

