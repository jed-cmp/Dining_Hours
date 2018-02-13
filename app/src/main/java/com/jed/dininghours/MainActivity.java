package com.jed.dininghours;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimerTask;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // declare constants
        final int TIME_MULT = 30;
        final int NUM_LOCATIONS = 44;


        // define class objects
        final DiningHours[] DINING_HOURS = new DiningHours[NUM_LOCATIONS];


        // south campus -------------------------------------------------------------------


        // Commons Breakfast and Lunch
        DINING_HOURS[0] = new DiningHours(
                getString(R.string.commons),
                (TextView) findViewById(R.id.hrsCommons),
                (ImageView) findViewById(R.id.statusCommons),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{420, 420, 540, 600},
                new int[]{900, 900, 900, 900});


        // Commons Dinner
        DINING_HOURS[1] = new DiningHours(
                getString(R.string.commons),
                (TextView) findViewById(R.id.hrsCommons),
                (ImageView) findViewById(R.id.statusCommons),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{1020, 1020, 1020, 1020},
                new int[]{1260, 1200, 1200, 1200});


        // Southside Market Lunch
        DINING_HOURS[2] = new DiningHours(
                getString(R.string.southside_market),
                (TextView) findViewById(R.id.hrsSouthsideMarket),
                (ImageView) findViewById(R.id.statusSouthsideMarket),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 0},
                new int[]{900, 900, 0, 0});


        // Southside Market Dinner
        DINING_HOURS[3] = new DiningHours(
                getString(R.string.southside_market),
                (TextView) findViewById(R.id.hrsSouthsideMarket),
                (ImageView) findViewById(R.id.statusSouthsideMarket),
                new int[]{960, 960, 0, 1020},
                // Mon-Thur, Fri, Sat, Sun
                new int[]{1320, 1320, 0, 1260});


        // Duncan Lunch
        DINING_HOURS[4] = new DiningHours(
                getString(R.string.duncan),
                (TextView) findViewById(R.id.hrsDuncan),
                (ImageView) findViewById(R.id.statusDuncan),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{660, 660, 0, 0},
                new int[]{780, 780, 0, 0});


        // Duncan Dinner
        DINING_HOURS[5] = new DiningHours(
                getString(R.string.duncan),
                (TextView) findViewById(R.id.hrsDuncan),
                (ImageView) findViewById(R.id.statusDuncan),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{1020, 0, 0, 1020},
                new int[]{1140, 0, 0, 1140});


        // StarbucksCorps
        DINING_HOURS[6] = new DiningHours(
                getString(R.string.starbucks_corps),
                (TextView) findViewById(R.id.hrsStarbucksCorps),
                (ImageView) findViewById(R.id.statusStarbucksCorps),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{420, 420, 540, 720},
                new int[]{1320, 1140, 960, 1320});


        // Aggie Express at Commons
        DINING_HOURS[7] = new DiningHours(
                getString(R.string.aggie_express_commons),
                (TextView) findViewById(R.id.hrsAggieExpressCommons),
                (ImageView) findViewById(R.id.statusAggieExpressCommons),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{420, 420, 540, 600},
                new int[]{1440, 1440, 1440, 1440});


        // Grill
        DINING_HOURS[8] = new DiningHours(
                getString(R.string.grill),
                (TextView) findViewById(R.id.hrsGrill),
                (ImageView) findViewById(R.id.statusGrill),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{480, 480, 0, 0},
                new int[]{1200, 900, 0, 0});


        // StarbucksEvans
        DINING_HOURS[9] = new DiningHours(
                getString(R.string.starbucks_evans),
                (TextView) findViewById(R.id.hrsStarbucksEvans),
                (ImageView) findViewById(R.id.statusStarbucksEvans),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 540, 600},
                new int[]{1440, 1020, 1020, 1440});


        // White Creek Food Truck
        DINING_HOURS[10] = new DiningHours(
                getString(R.string.white_creek),
                (TextView) findViewById(R.id.hrsWhiteCreek),
                (ImageView) findViewById(R.id.statusWhiteCreek),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{1020, 1020, 0, 0},
                new int[]{1200, 1200, 0, 0});


        // central campus --------------------------------------------------------


        // Aggie Express at Pavilion
        DINING_HOURS[11] = new DiningHours(
                getString(R.string.aggie_express_pavillion),
                (TextView) findViewById(R.id.hrsAggieExpressPavilion),
                (ImageView) findViewById(R.id.statusAggieExpressPavilion),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 600, 600},
                new int[]{300, 1140, 1080, 1440});


        // BrazosValley
        DINING_HOURS[12] = new DiningHours(
                getString(R.string.brazos_valley),
                (TextView) findViewById(R.id.hrsBrazosValley),
                (ImageView) findViewById(R.id.statusBrazosValley),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 0},
                new int[]{960, 960, 0, 0});


        // M2O
        DINING_HOURS[13] = new DiningHours(
                getString(R.string.m2o),
                (TextView) findViewById(R.id.hrsM2O),
                (ImageView) findViewById(R.id.statusM2O),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 0},
                new int[]{960, 960, 0, 0});


        // Cabo
        DINING_HOURS[14] = new DiningHours(
                getString(R.string.cabo),
                (TextView) findViewById(R.id.hrsCabo),
                (ImageView) findViewById(R.id.statusCabo),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 0},
                new int[]{960, 960, 0, 0});


        // Zatar
        DINING_HOURS[15] = new DiningHours(
                getString(R.string.zatar),
                (TextView) findViewById(R.id.hrsZatar),
                (ImageView) findViewById(R.id.statusZatar),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 0},
                new int[]{960, 960, 0, 0});


        // BeeCreek
        DINING_HOURS[16] = new DiningHours(
                getString(R.string.bee_creek),
                (TextView) findViewById(R.id.hrsBeeCreek),
                (ImageView) findViewById(R.id.statusBeeCreek),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 0},
                new int[]{960, 960, 0, 0});


        // Revs
        DINING_HOURS[17] = new DiningHours(
                getString(R.string.revs),
                (TextView) findViewById(R.id.hrsRevs),
                (ImageView) findViewById(R.id.statusRevs),
                // Mon-Thur, Fri, Sat, Sun
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 720, 720},
                new int[]{1440, 1320, 1200, 1440});


        // ChickenGrill
        DINING_HOURS[18] = new DiningHours(
                getString(R.string.chicken_grill),
                (TextView) findViewById(R.id.hrsChickenGrill),
                (ImageView) findViewById(R.id.statusChickenGrill),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{660, 660, 0, 0},
                new int[]{1260, 960, 0, 0});


        // PandaExpress
        DINING_HOURS[19] = new DiningHours(
                getString(R.string.panda_express),
                (TextView) findViewById(R.id.hrsPandaExpress),
                (ImageView) findViewById(R.id.statusPandaExpress),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{660, 660, 660, 660},
                new int[]{1320, 1320, 1320, 1320});


        // SmoothieKingMSC
        DINING_HOURS[20] = new DiningHours(
                getString(R.string.smoothie_king_msc),
                (TextView) findViewById(R.id.hrsSmoothieKingMSC),
                (ImageView) findViewById(R.id.statusSmoothieKingMSC),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 720, 720},
                new int[]{1320, 1200, 1200, 1320});


        // UniversityClub
        DINING_HOURS[21] = new DiningHours(
                getString(R.string.university_club),
                (TextView) findViewById(R.id.hrsUniversityClub),
                (ImageView) findViewById(R.id.statusUniversityClub),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{660, 660, 0, 0},
                new int[]{870, 870, 0, 0});


        // west campus ----------------------------------------------------------


        // Which Wich
        DINING_HOURS[22] = new DiningHours(
                getString(R.string.which_wich),
                (TextView) findViewById(R.id.hrsWhichWich),
                (ImageView) findViewById(R.id.statusWhichWich),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 0},
                new int[]{1020, 900, 0, 0});


        // Chick-fil-A
        DINING_HOURS[23] = new DiningHours(
                getString(R.string.chickfila_agcafe),
                (TextView) findViewById(R.id.hrsChickfilaAgcafe),
                (ImageView) findViewById(R.id.statusChickfilaAgcafe),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 0, 0},
                new int[]{1140, 960, 0, 0});


        // Rev's Express
        DINING_HOURS[24] = new DiningHours(
                getString(R.string.revs_express),
                (TextView) findViewById(R.id.hrsRevsExpress),
                (ImageView) findViewById(R.id.statusRevsExpress),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 0},
                new int[]{840, 840, 0, 0});


        // 41st Club
        DINING_HOURS[25] = new DiningHours(
                getString(R.string.st_club),
                (TextView) findViewById(R.id.hrs41stClub),
                (ImageView) findViewById(R.id.status41stClub),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 0, 0},
                new int[]{1020, 840, 0, 0});


        // Westside Exchange
        DINING_HOURS[26] = new DiningHours(
                getString(R.string.westside_exchange),
                (TextView) findViewById(R.id.hrsWestsideExchange),
                (ImageView) findViewById(R.id.statusWestsideExchange),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 0, 1020},
                new int[]{1380, 840, 0, 1380});


        // Smoothie King at the Rec
        DINING_HOURS[27] = new DiningHours(
                getString(R.string.smoothie_king_rec),
                (TextView) findViewById(R.id.hrsSmoothieKingRec),
                (ImageView) findViewById(R.id.statusSmoothieKingRec),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{420, 420, 540, 780},
                new int[]{1380, 1320, 1320, 1320});


        // Vet Med Cafe
        DINING_HOURS[28] = new DiningHours(
                getString(R.string.vet_med),
                (TextView) findViewById(R.id.hrsVetMed),
                (ImageView) findViewById(R.id.statusVetMed),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 0, 0},
                new int[]{900, 900, 0, 0});


        // north campus ----------------------------------------------------------------------


        // ETED Sidewalk at ETB
        DINING_HOURS[29] = new DiningHours(
                getString(R.string.eted_sidewalk),
                (TextView) findViewById(R.id.hrsETEDSidewalk),
                (ImageView) findViewById(R.id.statusETEDSidewalk),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 0, 0},
                new int[]{870, 870, 0, 0});


        // Papa John's
        DINING_HOURS[30] = new DiningHours(
                getString(R.string.pap_johns),
                (TextView) findViewById(R.id.hrsPapaJohns),
                (ImageView) findViewById(R.id.statusPapaJohns),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 0, 840},
                new int[]{1440, 1200, 0, 1380});


        // Chick-fil-A at Underground
        DINING_HOURS[31] = new DiningHours(
                getString(R.string.chickfila_ufc),
                (TextView) findViewById(R.id.hrsChickfilAUFC),
                (ImageView) findViewById(R.id.statusChickfilAUFC),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 600, 0},
                new int[]{1320, 1200, 1200, 0});


        // Houston Street Subs
        DINING_HOURS[32] = new DiningHours(
                getString(R.string.houston_subs),
                (TextView) findViewById(R.id.hrsHoustonSubs),
                (ImageView) findViewById(R.id.statusHoustonSubs),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{600, 600, 600, 0},
                new int[]{960, 960, 960, 0});


        // Smoothie King at Underground
        DINING_HOURS[33] = new DiningHours(
                getString(R.string.smoothie_king_ufc),
                (TextView) findViewById(R.id.hrsSmoothieKingUFC),
                (ImageView) findViewById(R.id.statusSmoothieKingUFC),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{480, 480, 720, 840},
                new int[]{1320, 1200, 1080, 1200});


        // Lime Fresh Mexican
        DINING_HOURS[34] = new DiningHours(
                getString(R.string.lime),
                (TextView) findViewById(R.id.hrsLime),
                (ImageView) findViewById(R.id.statusLime),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{660, 660, 0, 0},
                new int[]{1200, 1140, 0, 0});


        // Smashburger
        DINING_HOURS[35] = new DiningHours(
                getString(R.string.smashburger),
                (TextView) findViewById(R.id.hrsSmashburger),
                (ImageView) findViewById(R.id.statusSmashburger),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{660, 660, 0, 720},
                new int[]{1320, 1200, 0, 1260});


        // Sbisa Dining Hall Breakfast and Lunch
        DINING_HOURS[36] = new DiningHours(
                getString(R.string.sbisa),
                (TextView) findViewById(R.id.hrsSbisa),
                (ImageView) findViewById(R.id.statusSbisa),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{420, 420, 600, 630},
                new int[]{840, 840, 840, 870});


        // Sbisa Dining Hall Dinner
        DINING_HOURS[37] = new DiningHours(
                getString(R.string.sbisa),
                (TextView) findViewById(R.id.hrsSbisa),
                (ImageView) findViewById(R.id.statusSbisa),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{1020, 1020, 1020, 1020},
                new int[]{1200, 1200, 1200, 1200});


        // Aggie Express in the Underground
        DINING_HOURS[38] = new DiningHours(
                getString(R.string.aggie_express_ufc),
                (TextView) findViewById(R.id.hrsAggieExpressUFC),
                (ImageView) findViewById(R.id.statusAggieExpressUFC),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 0, 0},
                new int[]{1260, 1140, 0, 0});


        // Aggie Express at Hullabaloo
        DINING_HOURS[39] = new DiningHours(
                getString(R.string.aggie_express_hullabaloo),
                (TextView) findViewById(R.id.hrsAggieExpressHullabaloo),
                (ImageView) findViewById(R.id.statusAggieExpressHullabaloo),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 480, 540},
                new int[]{1440, 1440, 1440, 1440});


        // Outtakes at Blocker
        DINING_HOURS[40] = new DiningHours(
                getString(R.string.outtakes),
                (TextView) findViewById(R.id.hrsOuttakes),
                (ImageView) findViewById(R.id.statusOuttakes),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{420, 420, 0, 0},
                new int[]{1200, 900, 0, 0});


        // Azimuth
        DINING_HOURS[41] = new DiningHours(
                getString(R.string.azimuth),
                (TextView) findViewById(R.id.hrsAzimuth),
                (ImageView) findViewById(R.id.statusAzimuth),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{450, 450, 0, 0},
                new int[]{1020, 900, 0, 0});


        // Einsteins Brother's Bagels
        DINING_HOURS[42] = new DiningHours(
                getString(R.string.einsteins),
                (TextView) findViewById(R.id.hrsEinsteins),
                (ImageView) findViewById(R.id.statusEinsteins),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{420, 420, 480, 0},
                new int[]{900, 900, 840, 0});


        // Starbucks at Hullabaloo
        DINING_HOURS[43] = new DiningHours(
                getString(R.string.starbucks_hullabaloo),
                (TextView) findViewById(R.id.hrsStarbucksHullabaloo),
                (ImageView) findViewById(R.id.statusStarbucksHullabaloo),
                // Mon-Thur, Fri, Sat, Sun
                new int[]{420, 420, 540, 540},
                new int[]{1320, 1140, 960, 1320});





        // define TextView variables
        final TextView txtClock = (TextView) findViewById(R.id.txtClock);
        final TextView txtDayOfWeek = (TextView) findViewById(R.id.txtDayOfWeek);

        final String closingSoon = " - Closing Soon!";

        // define ImageView variables
        final ImageView statusDuncan = (ImageView) findViewById(R.id.statusDuncan);

        // get current time
        Calendar rightNow = Calendar.getInstance();  // make Calendar object
        String day = rightNow.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int minute = rightNow.get(Calendar.MINUTE);
        int total_min = minute + hour * 60;

        // initialize Clock
        txtClock.setText(String.format(Locale.US, "%d", hour) + ":" + String.format(Locale.US, "%02d", minute));


        // initialize Date
        txtDayOfWeek.setText(day);


        // initialize open locations
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                getStatus(NUM_LOCATIONS, total_min, DINING_HOURS, 0, closingSoon);
                break;

            case "Friday":
                getStatus(NUM_LOCATIONS, total_min, DINING_HOURS, 1, closingSoon);
                break;

            case "Saturday":
                getStatus(NUM_LOCATIONS, total_min, DINING_HOURS, 2, closingSoon);
                break;

            case "Sunday":
                getStatus(NUM_LOCATIONS, total_min, DINING_HOURS, 3, closingSoon);
                break;

        }



        TabHost host = (TabHost) findViewById(R.id.Tabs);  // make TabHost object
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Central");
        spec.setContent(R.id.Central);
        spec.setIndicator("Central");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("North");
        spec.setContent(R.id.North);
        spec.setIndicator("North");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("South");
        spec.setContent(R.id.South);
        spec.setIndicator("South");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("West");
        spec.setContent(R.id.West);
        spec.setIndicator("West");
        host.addTab(spec);






        SeekBar mySeekBar = (SeekBar)findViewById(R.id.seekbarHours);  // make SeekBar object
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // Get current time
                Calendar rightNow = Calendar.getInstance();
                rightNow.add(Calendar.MINUTE, progress * TIME_MULT);
                String day = rightNow.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
                int hour = rightNow.get(Calendar.HOUR_OF_DAY);
                int minute = rightNow.get(Calendar.MINUTE);
                int total_min = minute + hour * 60;

                // set Clock
                txtClock.setText(String.format(Locale.US, "%d", hour) + ":" + String.format(Locale.US, "%02d", minute));

                // set Date
                txtDayOfWeek.setText(day);


                // determine open locations
                switch (day) {
                    case "Monday":
                    case "Tuesday":
                    case "Wednesday":
                    case "Thursday":
                        getStatus(NUM_LOCATIONS, total_min, DINING_HOURS, 0, closingSoon);
                        break;

                    case "Friday":
                        getStatus(NUM_LOCATIONS, total_min, DINING_HOURS, 1, closingSoon);
                        break;

                    case "Saturday":
                        getStatus(NUM_LOCATIONS, total_min, DINING_HOURS, 2, closingSoon);
                        break;

                    case "Sunday":
                        getStatus(NUM_LOCATIONS, total_min, DINING_HOURS, 3, closingSoon);
                        break;

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }




    // Calculate Location Statuses
    public void getStatus(int NUM_LOCATIONS, int total_min, DiningHours DINING_HOURS[],int index, String closingSoon) {
        for(int i = 0; i < NUM_LOCATIONS; i++) {
            // update hours TextView
            DINING_HOURS[i].getHours().setText(String.format(Locale.US, "%02d", DINING_HOURS[i].getMinuteOpen(index) / 60) + " - " + String.format(Locale.US, "%02d", DINING_HOURS[i].getMinuteClosed(index) / 60) + "  hrs");

            // check if open
            if (total_min >= DINING_HOURS[i].getMinuteOpen(index) && total_min < DINING_HOURS[i].getMinuteClosed(index)) {

                // check if closing soon
                if (DINING_HOURS[i].getMinuteClosed(index) - total_min >= 30) {
                    DINING_HOURS[i].getStatus().setImageResource(R.drawable.ic_local_dining_open_36dp);
                } else {
                    DINING_HOURS[i].getStatus().setImageResource(R.drawable.ic_local_dining_closing_36dp);
                }

                // skip past the copies if already found one open
                if (NUM_LOCATIONS - i >= 3) {
                    if (DINING_HOURS[i].getName().equals(DINING_HOURS[i+1].getName())) {
                        if (DINING_HOURS[i].getName().equals(DINING_HOURS[i+2].getName()))
                            i += 3;
                        else i += 2;
                    }
                }
            } else {
                DINING_HOURS[i].getStatus().setImageResource(R.drawable.ic_local_dining_closed_36dp);
            }
        }










    }
}
