package com.example.studyrecyclerview;

public class Cell {

    private String time;
    private String name;
    private boolean onORoff;

    public Cell(String time, String name, boolean onORoff) {
        this.time = time;
        this.name = name;
        this.onORoff = onORoff;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public boolean isOnORoff() {
        return onORoff;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOnORoff(boolean onORoff) {
        this.onORoff = onORoff;
    }
}
