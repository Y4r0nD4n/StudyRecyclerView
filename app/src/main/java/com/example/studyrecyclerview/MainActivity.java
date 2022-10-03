package com.example.studyrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface, View.OnClickListener {


    ArrayList <Cell> cells = new ArrayList<>();
    RecyclerView recyclerview;
    CellAdapter cellAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < 10; i++) {
            cells.add(new Cell("00:0"+i, "My Alarm"+i,false));
        }




        recyclerview = findViewById(R.id.RecyclerViewAlerts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerview.setLayoutManager (layoutManager);

        cellAdapter  = new CellAdapter(cells, this);
        recyclerview.setAdapter(cellAdapter);

        ItemTouchHelper helper = new ItemTouchHelper(simpleCallback);
        helper.attachToRecyclerView(recyclerview);

    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(MainActivity.this,SetAlarmActivity.class);

        //intent.putExtra("AlarmName",)

        startActivity(intent);

    }


//    public void onChildDraw (Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,float dX, float dY,int actionState, boolean isCurrentlyActive){
//        onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//    }


    Context context = this;
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public void onChildDraw (Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive){
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                final ColorDrawable background = new ColorDrawable(Color.RED);
                View itemView =  viewHolder.itemView;


                background.setBounds(0, itemView.getTop(), (int) (itemView.getLeft() + dX), itemView.getBottom());
                background.draw(c);

//                Drawable icon = ContextCompat.getDrawable(context, R.drawable.garbage_bin);
//                icon.setBounds(1, itemView.getTop(), (int) (itemView.getLeft() + dX), itemView.getBottom());
//                icon.draw(c);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                cells.remove(viewHolder.getAdapterPosition());
                cellAdapter.notifyDataSetChanged();








            }
    };

    @Override
    public void onClick(View v) {

//        Intent intent = new Intent(MainActivity.this,SetAlarmActivity.class);
//
//
//        startActivity(intent);

    }
}