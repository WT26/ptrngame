package wt.ptrngame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class thirdWorld extends AppCompatActivity {

    public static final String totalstatics = "MyPrefsFile";
    //int orangelevel_completed;
    int sounds_toggle;
    int total_completed;
    //int note_combination;
    //int note_solved;
    //int bulb_completed;

    public static final String levelsaves = "MyPrefsFile";
    int level_twentyone_completed;
    int level_twentyone_starred;

    int level_twentytwo_completed;
    int level_twentytwo_starred;

    int level_twentythree_completed;
    int level_twentythree_starred;

    int level_twentyfour_completed;
    int level_twentyfour_starred;

    int level_twentyfive_completed;
    int level_twentyfive_starred;

    int level_twentysix_completed;
    int level_twentysix_starred;

    int level_twentyseven_completed;
    int level_twentyseven_starred;

    int level_twentyeight_completed;
    int level_twentyeight_starred;

    int level_twentynine_completed;
    int level_twnetynine_starred;

    int level_thirty_completed;
    int level_thirty_starred;


    Intent intent = getIntent();
    //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    Button back;
    Button leveltwentyone_button;
    Button leveltwentytwo_button;
    Button leveltwentythree_button;
    Button leveltwentyfour_button;
    Button leveltwentyfive_button;
    Button leveltwentysix_button;
    Button leveltwentyseven_button;
    Button leveltwentyeight_button;
    Button leveltwentynine_button;
    Button levelthirty_button;

    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        //orangelevel_completed = totalstatics.getInt("OrangeLevelCompleted", 0);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 0);
        total_completed = totalstatics.getInt("TotalCompleted", 0);
        //note_combination = totalstatics.getInt("NoteCombination", 0);
        //note_solved = totalstatics.getInt("NoteSolved", 0);
        //bulb_completed = totalstatics.getInt("BulbCompleted", 0);


        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        level_twentyone_completed = levelsaves.getInt("LevelTwentyoneCompleted", 0);
        level_twentyone_starred = levelsaves.getInt("LevelTwentyoneStarred", 0);

        level_twentytwo_completed = levelsaves.getInt("LevelTwentytwoCompleted", 0);
        level_twentytwo_starred = levelsaves.getInt("LevelTwentytwoStarred", 0);

        level_twentythree_completed = levelsaves.getInt("LevelTwentythreeCompleted", 0);
        level_twentythree_starred = levelsaves.getInt("LevelTwentythreeStarred", 0);

        level_twentyfour_completed = levelsaves.getInt("LevelTwentyfourCompleted", 0);
        level_twentyfour_starred = levelsaves.getInt("LevelTwentyfourStarred", 0);

        level_twentyfive_completed = levelsaves.getInt("LevelTwentyfiveCompleted", 0);
        level_twentyfive_starred = levelsaves.getInt("LevelTwentyfiveStarred", 0);

        level_twentysix_completed = levelsaves.getInt("LevelTwentysixCompleted", 0);
        level_twentysix_starred = levelsaves.getInt("LevelTwentysixStarred", 0);

        level_twentyseven_completed = levelsaves.getInt("LevelTwentysevenCompleted", 0);
        level_twentyseven_starred = levelsaves.getInt("LevelTwentysevenStarred", 0);

        level_twentyeight_completed = levelsaves.getInt("LevelTwentyeightCompleted", 0);
        level_twentyeight_starred = levelsaves.getInt("LevelTwentyeightStarred", 0);

        level_twentynine_completed = levelsaves.getInt("LevelTwentynineCompleted", 0);
        level_twnetynine_starred = levelsaves.getInt("LevelTwentynineStarred", 0);

        level_thirty_completed = levelsaves.getInt("LevelThirtyCompleted", 0);
        level_thirty_starred = levelsaves.getInt("LevelThirtyStarred", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_world);

        back = (Button) findViewById(R.id.angry_btn);
        leveltwentyone_button = (Button) findViewById(R.id.level1);
        leveltwentytwo_button = (Button) findViewById(R.id.level2);
        leveltwentythree_button = (Button) findViewById(R.id.level3);
        leveltwentyfour_button = (Button) findViewById(R.id.level4);
        leveltwentyfive_button = (Button) findViewById(R.id.level5);
        leveltwentysix_button = (Button) findViewById(R.id.level6);
        leveltwentyseven_button = (Button) findViewById(R.id.level7);
        leveltwentyeight_button = (Button) findViewById(R.id.level8);
        leveltwentynine_button = (Button) findViewById(R.id.level9);
        levelthirty_button = (Button) findViewById(R.id.level10);

        next = (Button) findViewById(R.id.button12);

        //note = (ImageView) findViewById(R.id.imageView5);
        //lightbulb = (ImageView) findViewById(R.id.imageView6);
        //lock_button = (Button) findViewById(R.id.button6);
        //orangeworld_button = (Button) findViewById(R.id.button7);


        //lock_counter = 0;

        //level1
        if(level_twentyone_completed == 1 && level_twentyone_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyone_button.setBackground(drawable);
        }
        else if(level_twentyone_starred == 1 && level_twentyone_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyone_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyone_button.setBackground(drawable);
        }

        //level2
        if(level_twentytwo_completed == 1 && level_twentytwo_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentytwo_button.setBackground(drawable);
        }
        else if(level_twentytwo_starred == 1 && level_twentytwo_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentytwo_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentytwo_button.setBackground(drawable);
        }

        //level3
        if(level_twentythree_completed == 1 && level_twentythree_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentythree_button.setBackground(drawable);
        }
        else if(level_twentythree_starred == 1 && level_twentythree_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentythree_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentythree_button.setBackground(drawable);
        }

        //level4
        if(level_twentyfour_completed == 1 && level_twentyfour_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyfour_button.setBackground(drawable);
        }
        else if(level_twentyfour_starred == 1 && level_twentyfour_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyfour_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyfour_button.setBackground(drawable);
        }

        //level5
        if(level_twentyfive_completed == 1 && level_twentyfive_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyfive_button.setBackground(drawable);
        }
        else if(level_twentyfive_starred == 1 && level_twentyfive_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyfive_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyfive_button.setBackground(drawable);
        }

        //level6
        if(level_twentysix_completed == 1 && level_twentysix_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentysix_button.setBackground(drawable);
        }
        else if(level_twentysix_starred == 1 && level_twentysix_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentysix_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentysix_button.setBackground(drawable);
        }

        //level7
        if(level_twentyseven_completed == 1 && level_twentyseven_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyseven_button.setBackground(drawable);
        }
        else if(level_twentyseven_starred == 1 && level_twentyseven_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyseven_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyseven_button.setBackground(drawable);
        }

        //level8
        if(level_twentyeight_completed == 1 && level_twentyeight_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyeight_button.setBackground(drawable);
        }
        else if(level_twentyeight_starred == 1 && level_twentyeight_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyeight_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyeight_button.setBackground(drawable);
        }

        //level9
        if(level_twentynine_completed == 1 && level_twnetynine_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentynine_button.setBackground(drawable);
        }
        else if(level_twnetynine_starred == 1 && level_twentynine_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentynine_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentynine_button.setBackground(drawable);
        }

        //level10
        if(level_thirty_completed == 1 && level_thirty_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            levelthirty_button.setBackground(drawable);
        }
        else if(level_thirty_starred == 1 && level_thirty_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            levelthirty_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            levelthirty_button.setBackground(drawable);
        }

        ////10Completed->orangeButton
        //if(total_completed >= 20){
        //    note.setVisibility(View.VISIBLE);
        //}
        //else{
        //    note.setVisibility(View.GONE);
        //}
//
        //if(note_solved == 1){
        //    lightbulb.setVisibility(View.VISIBLE);
        //}
        //else{
        //    lightbulb.setVisibility(View.GONE);
        //}
        //Log.d("VV", Integer.toString(bulb_completed));
        //if(bulb_completed == 1){
        //    next.setVisibility(View.VISIBLE);
        //}
        //else{
        //    next.setVisibility(View.GONE);
        //}




        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                    mp.start();
                }
                MainMenu(view);
            }
        });

        leveltwentyone_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwentyOne(view);
            }
        });
        leveltwentytwo_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwentyTwo(view);
            }
        });
        leveltwentythree_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwentyThree(view);
            }
        });
        leveltwentyfour_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwentyFour(view);
            }
        });

        leveltwentyfive_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwentyFive(view);
            }
        });

        leveltwentysix_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelSixteen(view);
            }
        });

        leveltwentyseven_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelSeventeen(view);
            }
        });

        leveltwentyeight_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelEighteen(view);
            }
        });

        leveltwentynine_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelNineteen(view);
            }
        });

        levelthirty_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwenty(view);
            }
        });

        //note.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View view) {
        //        if (sounds_toggle == 0) {
        //            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
        //            mp.start();
        //        }
        //        lookNote(view);
        //    }
        //});
//
        //lightbulb.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View view) {
        //        if (sounds_toggle == 0) {
        //            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
        //            mp.start();
        //        }
        //        bulbLevel(view);
        //    }
        //});

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                fourthWorld(view);
            }
        });

        //lock_button.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(final View view) {
        //        if(sounds_toggle == 0){
        //            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.clicklock);
        //            mp.start();
        //        }
        //        if(lock_counter > 5){
        //            Resources res = getResources();
        //            Drawable drawable = res.getDrawable(R.drawable.lockopenorange);
        //            lock_button.setBackground(drawable);
        //            lock_button.setClickable(false);
//
        //            if(sounds_toggle == 0){
        //                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.clicklock);
        //                mp.start();
        //            }
        //            Handler handler = new Handler();
        //            handler.postDelayed(new Runnable() {
        //                public void run() {
        //                    lockLevel(view);
        //                }
        //            }, 1500);
        //        }
        //        lock_counter += 1;
        //    }
        //});

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    protected void onResume() {
        super.onResume();

        //lock_counter = 0;


        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        //orangelevel_completed = preferences97.getInt("OrangeLevelCompleted", 0);
        total_completed = totalstatics.getInt("TotalCompleted", 0);
        //bulb_completed = totalstatics.getInt("BulbCompleted", 0);


        // Level one completed?
        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        level_twentyone_completed = levelsaves.getInt("LevelTwentyoneCompleted", 0);
        level_twentyone_starred = levelsaves.getInt("LevelTwentyoneStarred", 0);

        level_twentytwo_completed = levelsaves.getInt("LevelTwentytwoCompleted", 0);
        level_twentytwo_starred = levelsaves.getInt("LevelTwentytwoStarred", 0);

        level_twentythree_completed = levelsaves.getInt("LevelTwentythreeCompleted", 0);
        level_twentythree_starred = levelsaves.getInt("LevelTwentythreeStarred", 0);

        level_twentyfour_completed = levelsaves.getInt("LevelTwentyfourCompleted", 0);
        level_twentyfour_starred = levelsaves.getInt("LevelTwentyfourStarred", 0);

        level_twentyfive_completed = levelsaves.getInt("LevelTwentyfiveCompleted", 0);
        level_twentyfive_starred = levelsaves.getInt("LevelTwentyfiveStarred", 0);

        level_twentysix_completed = levelsaves.getInt("LevelTwentysixCompleted", 0);
        level_twentysix_starred = levelsaves.getInt("LevelTwentysixStarred", 0);

        level_twentyseven_completed = levelsaves.getInt("LevelTwentysevenCompleted", 0);
        level_twentyseven_starred = levelsaves.getInt("LevelTwentysevenStarred", 0);

        level_twentyeight_completed = levelsaves.getInt("LevelTwentyeightCompleted", 0);
        level_twentyeight_starred = levelsaves.getInt("LevelTwentyeightStarred", 0);

        level_twentynine_completed = levelsaves.getInt("LevelTwentynineCompleted", 0);
        level_twnetynine_starred = levelsaves.getInt("LevelTwentynineStarred", 0);

        level_thirty_completed = levelsaves.getInt("LevelThirtyCompleted", 0);
        level_thirty_starred = levelsaves.getInt("LevelThirtyStarred", 0);

        leveltwentyone_button = (Button) findViewById(R.id.level1);
        if(level_twentyone_completed == 1 && level_twentyone_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyone_button.setBackground(drawable);
        }
        else if(level_twentyone_starred == 1 && level_twentyone_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyone_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyone_button.setBackground(drawable);
        }


        // Level two completed?
        leveltwentytwo_button = (Button) findViewById(R.id.level2);
        if(level_twentytwo_completed == 1 && level_twentytwo_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentytwo_button.setBackground(drawable);
        }
        else if(level_twentytwo_starred == 1 && level_twentytwo_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentytwo_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentytwo_button.setBackground(drawable);
        }

        // Level three completed?
        leveltwentythree_button = (Button) findViewById(R.id.level3);
        if(level_twentythree_completed == 1 && level_twentythree_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentythree_button.setBackground(drawable);
        }
        else if(level_twentythree_starred == 1 && level_twentythree_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentythree_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentythree_button.setBackground(drawable);
        }

        // Level four completed?
        leveltwentyfour_button = (Button) findViewById(R.id.level4);
        if(level_twentyfour_completed == 1 && level_twentyfour_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyfour_button.setBackground(drawable);
        }
        else if(level_twentyfour_starred == 1 && level_twentyfour_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyfour_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyfour_button.setBackground(drawable);
        }

        // Level five completed?
        leveltwentyfive_button = (Button) findViewById(R.id.level5);
        if(level_twentyfive_completed == 1 && level_twentyfive_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyfive_button.setBackground(drawable);
        }
        else if(level_twentyfive_starred == 1 && level_twentyfive_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyfive_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyfive_button.setBackground(drawable);
        }

        // Level six completed?
        leveltwentysix_button = (Button) findViewById(R.id.level6);
        if(level_twentysix_completed == 1 && level_twentysix_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentysix_button.setBackground(drawable);
        }
        else if(level_twentysix_starred == 1 && level_twentysix_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentysix_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentysix_button.setBackground(drawable);
        }

        // Level seven completed?
        leveltwentyseven_button = (Button) findViewById(R.id.level7);
        if(level_twentyseven_completed == 1 && level_twentyseven_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyseven_button.setBackground(drawable);
        }
        else if(level_twentyseven_starred == 1 && level_twentyseven_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyseven_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyseven_button.setBackground(drawable);
        }

        // Level eight completed?
        leveltwentyeight_button = (Button) findViewById(R.id.level8);
        if(level_twentyeight_completed == 1 && level_twentyeight_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentyeight_button.setBackground(drawable);
        }
        else if(level_twentyeight_starred == 1 && level_twentyeight_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentyeight_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentyeight_button.setBackground(drawable);
        }

        // Level nine completed?
        leveltwentynine_button = (Button) findViewById(R.id.level9);
        if(level_twentynine_completed == 1 && level_twnetynine_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            leveltwentynine_button.setBackground(drawable);
        }
        else if(level_twnetynine_starred == 1 && level_twentynine_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            leveltwentynine_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            leveltwentynine_button.setBackground(drawable);
        }

        // Level ten completed?
        levelthirty_button = (Button) findViewById(R.id.level10);
        if(level_thirty_completed == 1 && level_thirty_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedgreen);
            levelthirty_button.setBackground(drawable);
        }
        else if(level_thirty_starred == 1 && level_thirty_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredgreen);
            levelthirty_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedgreen);
            levelthirty_button.setBackground(drawable);
        }

        //if(total_completed >= 20){
        //    note.setVisibility(View.VISIBLE);
        //}
        //else{
        //    note.setVisibility(View.GONE);
        //}
        //if(note_solved == 1){
        //    lightbulb.setVisibility(View.VISIBLE);
        //}
        //else{
        //    lightbulb.setVisibility(View.GONE);
        //}
//
        //if(bulb_completed == 1){
        //    next.setVisibility(View.VISIBLE);
        //}
        //else{
        //    next.setVisibility(View.GONE);
        //}

        //lock_button = (Button) findViewById(R.id.button6);
        ////10Completed->orangeButton
        //if(total_completed >= 10){
        //    lock_button.setVisibility(View.VISIBLE);
        //}
        //else{
        //    lock_button.setVisibility(View.GONE);
        //}
//
        //orangeworld_button = (Button) findViewById(R.id.button7);
        //if(orangelevel_completed == 1){
        //    orangeworld_button.setVisibility(View.VISIBLE);
        //}
        //else{
        //    orangeworld_button.setVisibility(View.GONE);
        //}

    }

    @Override
    protected void onStop() {
        Log.w("Tagg", "App stopped");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.w("Tagg", "App destoryed");

        super.onDestroy();
    }

    public void MainMenu(View view){

        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //super.onBackPressed();
    }

    public void orangeWorldMenu(View view){
        finish();
        Intent intent = new Intent(this, orangeworld_menu.class);
        startActivity(intent);
    }


    public  void levelTwentyOne(View view){
        Intent intent = new Intent(this, levelTwentyOne.class);
        startActivity(intent);
    }

    public  void levelTwentyTwo(View view){
        Intent intent2 = new Intent(this, levelTwentyTwo.class);
        startActivity(intent2);
    }

    public  void levelTwentyThree(View view){
        Intent intent3 = new Intent(this, levelTwentyThree.class);
        startActivity(intent3);
    }

    public  void levelTwentyFour(View view){
        Intent intent4 = new Intent(this, levelTwentyFour.class);
        startActivity(intent4);
    }

    public  void levelTwentyFive(View view){
        Intent intent5 = new Intent(this, levelTwentyFive.class);
        startActivity(intent5);
    }

    public  void levelSixteen(View view){
        Intent intent6 = new Intent(this, levelSixteen.class);
        startActivity(intent6);
    }

    public  void levelSeventeen(View view){
        Intent intent7 = new Intent(this, levelSeventeen.class);
        startActivity(intent7);
    }

    public  void levelEighteen(View view){
        Intent intent8 = new Intent(this, levelEighteen.class);
        startActivity(intent8);
    }

    public  void levelNineteen(View view){
        Intent intent9 = new Intent(this, levelNineteen.class);
        startActivity(intent9);
    }

    public  void levelTwenty(View view){
        Intent intent10 = new Intent(this, levelTwenty.class);
        startActivity(intent10);
    }

    public void lookNote(View view) {
        Intent intent11 = new Intent(this, note.class);
        startActivity(intent11);
    }

    public void bulbLevel(View view) {
        Intent intent11 = new Intent(this, bulbLevel.class);
        startActivity(intent11);
    }

    public void fourthWorld(View view) {
        Intent intent11 = new Intent(this, thirdWorld.class);
        startActivity(intent11);
    }
}
