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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;




public class orangeworld_menu extends AppCompatActivity {

    public static final String totalstatics = "MyPrefsFile";
    //int orangelevel_completed;
    int sounds_toggle;
    int total_completed;
    int note_combination;
    int note_solved;

    public static final String levelsaves = "MyPrefsFile";
    int level_eleven_completed;
    int level_eleven_starred;

    int level_twelve_completed;
    int level_twelve_starred;

    int level_thirteen_completed;
    int level_thirteen_starred;

    int level_fourteen_completed;
    int level_fourteen_starred;

    int level_fifteen_completed;
    int level_fifteen_starred;

    int level_sixteen_completed;
    int level_sixteen_starred;

    int level_seventeen_completed;
    int level_seventeen_starred;

    int level_eighteen_completed;
    int level_eighteen_starred;

    int level_nineteen_completed;
    int level_nineteen_starred;

    int level_twenty_completed;
    int level_twenty_starred;


    Intent intent = getIntent();
    //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    Button back;
    Button leveleleven_button;
    Button leveltwelve_button;
    Button levelthirteen_button;
    Button levelfourteen_button;
    Button levelfifteen_button;
    Button levelsixteen_button;
    Button levelseventeen_button;
    Button leveleighteen_button;
    Button levelnineteen_button;
    Button leveltwenty_button;

    ImageView note;
    ImageView lightbulb;
    //Button lock_button;
    //Button orangeworld_button;

    //int lock_counter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        //orangelevel_completed = totalstatics.getInt("OrangeLevelCompleted", 0);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 0);
        total_completed = totalstatics.getInt("TotalCompleted", 0);
        note_combination = totalstatics.getInt("NoteCombination", 0);
        note_solved = totalstatics.getInt("NoteSolved", 0);


        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        level_eleven_completed = levelsaves.getInt("LevelElevenCompleted", 0);
        level_eleven_starred = levelsaves.getInt("LevelElevenStarred", 0);

        level_twelve_completed = levelsaves.getInt("LevelTwelveCompleted", 0);
        level_twelve_starred = levelsaves.getInt("LevelTwelveStarred", 0);

        level_thirteen_completed = levelsaves.getInt("LevelThirteenCompleted", 0);
        level_thirteen_starred = levelsaves.getInt("LevelThirteenStarred", 0);

        level_fourteen_completed = levelsaves.getInt("LevelFourteenCompleted", 0);
        level_fourteen_starred = levelsaves.getInt("LevelFourteenStarred", 0);

        level_fifteen_completed = levelsaves.getInt("LevelFifteenCompleted", 0);
        level_fifteen_starred = levelsaves.getInt("LevelFifteenStarred", 0);

        level_sixteen_completed = levelsaves.getInt("LevelSixteenCompleted", 0);
        level_sixteen_starred = levelsaves.getInt("LevelSixteenStarred", 0);

        level_seventeen_completed = levelsaves.getInt("LevelSeventeenCompleted", 0);
        level_seventeen_starred = levelsaves.getInt("LevelSeventeenStarred", 0);

        level_eighteen_completed = levelsaves.getInt("LevelEighteenCompleted", 0);
        level_eighteen_starred = levelsaves.getInt("LevelEighteenStarred", 0);

        level_nineteen_completed = levelsaves.getInt("LevelNineteenCompleted", 0);
        level_nineteen_starred = levelsaves.getInt("LevelNineteenStarred", 0);

        level_twenty_completed = levelsaves.getInt("LevelTwentyCompleted", 0);
        level_twenty_starred = levelsaves.getInt("LevelTwentyStarred", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orangeworld_menu);

        back = (Button) findViewById(R.id.angry_btn);
        leveleleven_button = (Button) findViewById(R.id.level1);
        leveltwelve_button = (Button) findViewById(R.id.level2);
        levelthirteen_button = (Button) findViewById(R.id.level3);
        levelfourteen_button = (Button) findViewById(R.id.level4);
        levelfifteen_button = (Button) findViewById(R.id.level5);
        levelsixteen_button = (Button) findViewById(R.id.level6);
        levelseventeen_button = (Button) findViewById(R.id.level7);
        leveleighteen_button = (Button) findViewById(R.id.level8);
        levelnineteen_button = (Button) findViewById(R.id.level9);
        leveltwenty_button = (Button) findViewById(R.id.level10);

        note = (ImageView) findViewById(R.id.imageView5);
        lightbulb = (ImageView) findViewById(R.id.imageView6);
        //lock_button = (Button) findViewById(R.id.button6);
        //orangeworld_button = (Button) findViewById(R.id.button7);


        //lock_counter = 0;

        //level1
        if(level_eleven_completed == 1 && level_eleven_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            leveleleven_button.setBackground(drawable);
        }
        else if(level_eleven_starred == 1 && level_eleven_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            leveleleven_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            leveleleven_button.setBackground(drawable);
        }

        //level2
        if(level_twelve_completed == 1 && level_twelve_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            leveltwelve_button.setBackground(drawable);
        }
        else if(level_twelve_starred == 1 && level_twelve_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            leveltwelve_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            leveltwelve_button.setBackground(drawable);
        }

        //level3
        if(level_thirteen_completed == 1 && level_thirteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelthirteen_button.setBackground(drawable);
        }
        else if(level_thirteen_starred == 1 && level_thirteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelthirteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelthirteen_button.setBackground(drawable);
        }

        //level4
        if(level_fourteen_completed == 1 && level_fourteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelfourteen_button.setBackground(drawable);
        }
        else if(level_fourteen_starred == 1 && level_fourteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelfourteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelfourteen_button.setBackground(drawable);
        }

        //level5
        if(level_fifteen_completed == 1 && level_fifteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelfifteen_button.setBackground(drawable);
        }
        else if(level_fifteen_starred == 1 && level_fifteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelfifteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelfifteen_button.setBackground(drawable);
        }

        //level6
        if(level_sixteen_completed == 1 && level_sixteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelsixteen_button.setBackground(drawable);
        }
        else if(level_sixteen_starred == 1 && level_sixteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelsixteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelsixteen_button.setBackground(drawable);
        }

        //level7
        if(level_seventeen_completed == 1 && level_seventeen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelseventeen_button.setBackground(drawable);
        }
        else if(level_seventeen_starred == 1 && level_seventeen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelseventeen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelseventeen_button.setBackground(drawable);
        }

        //level8
        if(level_eighteen_completed == 1 && level_eighteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            leveleighteen_button.setBackground(drawable);
        }
        else if(level_eighteen_starred == 1 && level_eighteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            leveleighteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            leveleighteen_button.setBackground(drawable);
        }

        //level9
        if(level_nineteen_completed == 1 && level_nineteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelnineteen_button.setBackground(drawable);
        }
        else if(level_nineteen_starred == 1 && level_nineteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelnineteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelnineteen_button.setBackground(drawable);
        }

        //level10
        if(level_twenty_completed == 1 && level_twenty_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            leveltwenty_button.setBackground(drawable);
        }
        else if(level_twenty_starred == 1 && level_twenty_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            leveltwenty_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            leveltwenty_button.setBackground(drawable);
        }

        ////10Completed->orangeButton
        if(total_completed >= 20){
            note.setVisibility(View.VISIBLE);
        }
        else{
            note.setVisibility(View.GONE);
        }

        if(note_solved == 1){
            lightbulb.setVisibility(View.VISIBLE);
        }
        else{
            lightbulb.setVisibility(View.GONE);
        }




        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                    mp.start();
                }
                MainMenu(view);
            }
        });

        leveleleven_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelEleven(view);
            }
        });
        leveltwelve_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwelve(view);
            }
        });
        levelthirteen_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelThirteen(view);
            }
        });
        levelfourteen_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelFourteen(view);
            }
        });

        levelfifteen_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelFifteen(view);
            }
        });

        levelsixteen_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelSixteen(view);
            }
        });

        levelseventeen_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelSeventeen(view);
            }
        });

        leveleighteen_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelEighteen(view);
            }
        });

        levelnineteen_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelNineteen(view);
            }
        });

        leveltwenty_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwenty(view);
            }
        });

        note.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                lookNote(view);
            }
        });

        lightbulb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                bulbLevel(view);
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


        // Level one completed?
        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        level_eleven_completed = levelsaves.getInt("LevelElevenCompleted", 0);
        level_eleven_starred = levelsaves.getInt("LevelElevenStarred", 0);

        level_twelve_completed = levelsaves.getInt("LevelTwelveCompleted", 0);
        level_twelve_starred = levelsaves.getInt("LevelTwelveStarred", 0);

        level_thirteen_completed = levelsaves.getInt("LevelThirteenCompleted", 0);
        level_thirteen_starred = levelsaves.getInt("LevelThirteenStarred", 0);

        level_fourteen_completed = levelsaves.getInt("LevelFourteenCompleted", 0);
        level_fourteen_starred = levelsaves.getInt("LevelFourteenStarred", 0);

        level_fifteen_completed = levelsaves.getInt("LevelFifteenCompleted", 0);
        level_fifteen_starred = levelsaves.getInt("LevelFifteenStarred", 0);

        level_sixteen_completed = levelsaves.getInt("LevelSixteenCompleted", 0);
        level_sixteen_starred = levelsaves.getInt("LevelSixteenStarred", 0);

        level_seventeen_completed = levelsaves.getInt("LevelSeventeenCompleted", 0);
        level_seventeen_starred = levelsaves.getInt("LevelSevenStarred", 0);

        level_eighteen_completed = levelsaves.getInt("LevelEighteenCompleted", 0);
        level_eighteen_starred = levelsaves.getInt("LevelEighteenStarred", 0);

        level_nineteen_completed = levelsaves.getInt("LevelNineteenCompleted", 0);
        level_nineteen_starred = levelsaves.getInt("LevelNineteenStarred", 0);

        level_twenty_completed = levelsaves.getInt("LevelTwentyCompleted", 0);
        level_twenty_starred = levelsaves.getInt("LevelTwentyStarred", 0);

        leveleleven_button = (Button) findViewById(R.id.level1);
        if(level_eleven_completed == 1 && level_eleven_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            leveleleven_button.setBackground(drawable);
        }
        else if(level_eleven_starred == 1 && level_eleven_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            leveleleven_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            leveleleven_button.setBackground(drawable);
        }


        // Level two completed?
        leveltwelve_button = (Button) findViewById(R.id.level2);
        if(level_twelve_completed == 1 && level_twelve_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            leveltwelve_button.setBackground(drawable);
        }
        else if(level_twelve_starred == 1 && level_twelve_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            leveltwelve_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            leveltwelve_button.setBackground(drawable);
        }

        // Level three completed?
        levelthirteen_button = (Button) findViewById(R.id.level3);
        if(level_thirteen_completed == 1 && level_thirteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelthirteen_button.setBackground(drawable);
        }
        else if(level_thirteen_starred == 1 && level_thirteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelthirteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelthirteen_button.setBackground(drawable);
        }

        // Level four completed?
        levelfourteen_button = (Button) findViewById(R.id.level4);
        if(level_fourteen_completed == 1 && level_fourteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelfourteen_button.setBackground(drawable);
        }
        else if(level_fourteen_starred == 1 && level_fourteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelfourteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelfourteen_button.setBackground(drawable);
        }

        // Level five completed?
        levelfifteen_button = (Button) findViewById(R.id.level5);
        if(level_fifteen_completed == 1 && level_fifteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelfifteen_button.setBackground(drawable);
        }
        else if(level_fifteen_starred == 1 && level_fifteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelfifteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelfifteen_button.setBackground(drawable);
        }

        // Level six completed?
        levelsixteen_button = (Button) findViewById(R.id.level6);
        if(level_sixteen_completed == 1 && level_sixteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelsixteen_button.setBackground(drawable);
        }
        else if(level_sixteen_starred == 1 && level_sixteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelsixteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelsixteen_button.setBackground(drawable);
        }

        // Level seven completed?
        levelseventeen_button = (Button) findViewById(R.id.level7);
        if(level_seventeen_completed == 1 && level_seventeen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelseventeen_button.setBackground(drawable);
        }
        else if(level_seventeen_starred == 1 && level_seventeen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelseventeen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelseventeen_button.setBackground(drawable);
        }

        // Level eight completed?
        leveleighteen_button = (Button) findViewById(R.id.level8);
        if(level_eighteen_completed == 1 && level_eighteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            leveleighteen_button.setBackground(drawable);
        }
        else if(level_eighteen_starred == 1 && level_eighteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            leveleighteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            leveleighteen_button.setBackground(drawable);
        }

        // Level nine completed?
        levelnineteen_button = (Button) findViewById(R.id.level9);
        if(level_nineteen_completed == 1 && level_nineteen_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            levelnineteen_button.setBackground(drawable);
        }
        else if(level_nineteen_starred == 1 && level_nineteen_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            levelnineteen_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            levelnineteen_button.setBackground(drawable);
        }

        // Level ten completed?
        leveltwenty_button = (Button) findViewById(R.id.level10);
        if(level_twenty_completed == 1 && level_twenty_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completedorange);
            leveltwenty_button.setBackground(drawable);
        }
        else if(level_twenty_starred == 1 && level_twenty_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starredorange);
            leveltwenty_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompletedorange);
            leveltwenty_button.setBackground(drawable);
        }

        if(total_completed >= 20){
            note.setVisibility(View.VISIBLE);
        }
        else{
            note.setVisibility(View.GONE);
        }
        if(note_solved == 1){
            lightbulb.setVisibility(View.VISIBLE);
        }
        else{
            lightbulb.setVisibility(View.GONE);
        }


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

    public void levelMenu(View view){
        finish();
        Intent intent = new Intent(this, levelMenuActivity.class);
        startActivity(intent);
    }


    public  void levelEleven(View view){
        Intent intent = new Intent(this, levelEleven.class);
        startActivity(intent);
    }

    public  void levelTwelve(View view){
        Intent intent2 = new Intent(this, levelTwelve.class);
        startActivity(intent2);
    }

    public  void levelThirteen(View view){
        Intent intent3 = new Intent(this, levelThirteen.class);
        startActivity(intent3);
    }

    public  void levelFourteen(View view){
        Intent intent4 = new Intent(this, levelFourteen.class);
        startActivity(intent4);
    }

    public  void levelFifteen(View view){
        Intent intent5 = new Intent(this, levelFifteen.class);
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

    //public  void lockLevel(View view){
    //    Intent intent11 = new Intent(this, lockLevel.class);
    //    startActivity(intent11);
    //}

    //public  void orangeWorld(View view){
    //    Intent intent11 = new Intent(this, orangeworld_menu.class);
    //    startActivity(intent11);
    //}
}
