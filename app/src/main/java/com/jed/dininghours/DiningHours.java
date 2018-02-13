package com.jed.dininghours;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Joseph on 3/31/2017.
 */

public final class DiningHours extends Activity {
    private String Name;
    private TextView Hours;
    private ImageView Status;
    //private ImageView View;
    private int[] minuteOpen;
    private int[] minuteClosed;

    // constructor
    public DiningHours(String Name,TextView Hours, ImageView Status, int[] minuteOpen, int[] minuteClosed) {
        this.Name = Name;
        this.Hours = Hours;
        this.Status = Status;
        //this.View = View;
        this.minuteOpen = minuteOpen;
        this.minuteClosed = minuteClosed;
    }

    // accessors
    public String getName() {
        return Name;
    }

    public TextView getHours() {
        return Hours;
    }

    public ImageView getStatus() {
        return Status;
    }

    public int getMinuteOpen(int day) {
        return minuteOpen[day];
    }

    public int getMinuteClosed(int day) {
        return minuteClosed[day];
    }
}
