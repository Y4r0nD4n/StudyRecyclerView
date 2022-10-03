package com.example.studyrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CellAdapter extends RecyclerView.Adapter<CellAdapter.CellViewHolder>{
    private ArrayList <Cell> cells;

    private RecyclerViewInterface recyclerViewInterface;

    public CellAdapter(ArrayList<Cell> cells, RecyclerViewInterface recyclerViewInterface) {
        this.cells = cells;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public CellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where you inflate the layout (Giving a look to our rows)
        View cellView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleritem_alarm, parent, false);

        return new CellViewHolder(cellView, recyclerViewInterface);
    }

    public CellAdapter() {
        super();
    }

    public void onBindViewHolder(@NonNull CellViewHolder holder, int position) {
        // assigning values to the views we created in the recycler_view row layout file
        // based on the position of the recycler view
        //שינוי של הערכים
        Cell currentCell = cells.get(position);
        holder.TV_AlarmName.setText(currentCell.getName());
        holder.BtnTime.setText(currentCell.getTime());
        holder.BtnSwitch.setChecked(true);

    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want displayed
        return cells.size();
    }

    public static class CellViewHolder extends RecyclerView.ViewHolder{
        // grabbing the views from our Cell layout file
        // Kinda like in the onCreate method
        public Button BtnTime;
        public TextView TV_AlarmName;
        public Switch BtnSwitch;

        public CellViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            BtnTime = itemView.findViewById(R.id.btnTime);
            TV_AlarmName = itemView.findViewById(R.id.AlarmName);
            BtnSwitch = itemView.findViewById(R.id.btnSwitch);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }

}
