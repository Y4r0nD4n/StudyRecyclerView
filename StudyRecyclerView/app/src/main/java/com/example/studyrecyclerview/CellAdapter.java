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

    public CellAdapter(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    @NonNull
    @Override
    public CellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cellView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleritem_alarm, parent, false);

        return new CellViewHolder(cellView);
    }

    public CellAdapter() {
        super();
    }

    public void onBindViewHolder(@NonNull CellViewHolder holder, int position) {

        Cell currentCell = cells.get(position);
        holder.TV_AlarmName.setText(currentCell.getName());
        holder.BtnTime.setText(currentCell.getTime());
        holder.BtnSwitch.setChecked(true);

    }

    @Override
    public int getItemCount() {
        return cells.size();
    }

    public static class CellViewHolder extends RecyclerView.ViewHolder{

        public Button BtnTime;
        public TextView TV_AlarmName;
        public Switch BtnSwitch;

        public CellViewHolder(@NonNull View itemView) {
            super(itemView);

            BtnTime = itemView.findViewById(R.id.btnTime);
            TV_AlarmName = itemView.findViewById(R.id.AlarmName);
            BtnSwitch = itemView.findViewById(R.id.btnSwitch);

        }
    }

}
