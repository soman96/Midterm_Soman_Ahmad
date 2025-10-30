package com.example.midterm;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class HistoryActivity2 extends AppCompatActivity {

    private ListView historyList;
    private ArrayAdapter<Integer> adapter;
    private ArrayList<Integer> history;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        history = getIntent().getIntegerArrayListExtra("history");

        historyList = findViewById(R.id.historyList);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, history);
        historyList.setAdapter(adapter);
    }
}