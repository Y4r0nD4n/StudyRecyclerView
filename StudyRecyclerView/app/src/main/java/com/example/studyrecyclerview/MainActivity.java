package com.example.studyrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList <Cell> cells = new ArrayList<>();

        cells.add(new Cell("00:01", "My Alarm",true));

        RecyclerView recyclerview = findViewById(R.id.RecyclerViewAlerts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerview.setLayoutManager (layoutManager);

        CellAdapter cellAdapter  = new CellAdapter(cells);
        recyclerview.setAdapter(cellAdapter);
    }

}