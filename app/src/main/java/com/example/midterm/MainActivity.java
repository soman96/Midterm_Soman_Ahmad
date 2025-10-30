package com.example.midterm;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText number;
    private Button tableBtn;
    private ListView tableList;
    private Button historyBtn;
    private ArrayList<Integer> numberHistory;
    private ArrayAdapter<Integer> adapter;



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

        number = findViewById(R.id.etNumber);
        tableBtn = findViewById(R.id.btnTable);
        tableList = findViewById(R.id.listView);
        historyBtn = findViewById(R.id.btnHistory);

        tableBtn.setOnClickListener(this);
        historyBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnTable) {
            generateTable();
        }
    }

    private void generateTable() {
        String numberText = number.getText().toString();

        int number;

        try {
            number = Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<Integer> table = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            table.add(number * i);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, table);
        tableList.setAdapter(adapter);
        numberHistory.add(number);
    }
}