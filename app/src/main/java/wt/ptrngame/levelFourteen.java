package wt.ptrngame;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class levelFourteen extends AppCompatActivity {
    public static final String myPrefsKey13 = "MyPrefsFile";
    int sounds_toggle;

    Intent intent = getIntent();
    ToggleButton toggle;
    ToggleButton toggle2;
    ToggleButton toggle3;
    ToggleButton toggle4;
    ToggleButton toggle5;
    ToggleButton toggle6;

    Button back;
    Button restart;
    Button makeptrn;
    Button rate_game;


    TextView infotext;

    public static final String totalstatics = "MyPrefsFile";
    int total_toggles;
    int total_completed;
    int total_starred;
    int total_retrys;
    int total_ptrns;

    public static final String myPrefsKey3 = "MyPrefsFile";
    int level_fourteen_completed;
    int level_fourteen_starred;

    int current_toggles;
    int toggles_for_star;

    int pattern_state;
    int ptrn;
    int programmed;
    int note_combination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_fourteen);

        current_toggles = 0;
        toggles_for_star = 3;

        // Getting information
        final SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = totalstatics.getInt("TotalToggles", 0);
        total_starred = totalstatics.getInt("TotalStarred", 0);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 0);
        total_retrys = totalstatics.getInt("TotalRetrys", 0);
        total_completed = totalstatics.getInt("TotalCompleted", 0);
        total_ptrns = totalstatics.getInt("TotalPtrns", 0);
        note_combination = totalstatics.getInt("NoteCombination", 0);


        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        level_fourteen_completed = levelsaves.getInt("LevelFourteenCompleted", 0);
        level_fourteen_starred = levelsaves.getInt("LevelFourteenStarred", 0);

        back = (Button) findViewById(R.id.angry_btn);
        restart = (Button) findViewById(R.id.button5);
        makeptrn = (Button) findViewById(R.id.button8);
        rate_game = (Button) findViewById(R.id.button9);

        toggle = (ToggleButton) findViewById(R.id.button2);
        toggle.toggle();
        toggle2 = (ToggleButton) findViewById(R.id.button1);
        toggle3 = (ToggleButton) findViewById(R.id.button3);
        toggle4 = (ToggleButton) findViewById(R.id.toggleButton9);
        toggle5 = (ToggleButton) findViewById(R.id.toggleButton10);
        toggle6 = (ToggleButton) findViewById(R.id.toggleButton11);


        infotext = (TextView) findViewById(R.id.textView32);


        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        final Animation animSelect = AnimationUtils.loadAnimation(this, R.anim.anim_select);


        pattern_state = 0;
        ptrn = 0;
        programmed = 0;


        toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (pattern_state == 0){
                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle3.toggle();
                    toggle6.toggle();

                    if(CheckWinningCondition()){
                        levelWon();
                    }
                    // NORMAL LOGIC
                }

                // ###PROGRAMMING THE BUTTON
                else if(pattern_state == 1){
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle.toggle();
                    ptrn = 1;
                    pattern_state = 2;
                    //infotext.setText("Connect it.");
                    toggle.startAnimation(animRotate);
                }
                else if(pattern_state == 2){
                    if(ptrn == 1){
                        toggle.toggle();
                    }
                    else if(ptrn == 2){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 1;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle2.clearAnimation();
                        toggle.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }

                    else if(ptrn == 4){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 1;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle4.clearAnimation();
                        toggle.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 5){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 1;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle5.clearAnimation();
                        toggle.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 6){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 1;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle6.clearAnimation();
                        toggle.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }

                    else{
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 1;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle3.clearAnimation();
                        toggle.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                }
                // #########################

                else {
                    if(ptrn == 1){
                        if(programmed == 2){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle2.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 3){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle3.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 4){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle4.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 5){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle5.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 6){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle6.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }


                    }
                    else{
                        // NORMAL LOGIC
                        total_toggles += 1;
                        current_toggles += 1;
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }

                        toggle3.toggle();

                        if(CheckWinningCondition()){
                            levelWon();
                        }
                        // NORMAL LOGIC
                    }
                }
            }
        });

        toggle2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (pattern_state == 0){
                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle5.toggle();


                    if(CheckWinningCondition()){
                        levelWon();
                    }
                    // NORMAL LOGIC
                }

                // ###PROGRAMMING THE BUTTON
                else if(pattern_state == 1){
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle2.toggle();
                    ptrn = 2;
                    pattern_state = 2;
                    //infotext.setText("Connect it.");
                    toggle2.startAnimation(animRotate);
                }
                else if(pattern_state == 2){
                    if(ptrn == 2){
                        toggle2.toggle();
                    }
                    else if(ptrn == 3){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle2.toggle();
                        programmed = 2;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle3.clearAnimation();
                        toggle2.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;

                    }
                    else if(ptrn == 4){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 2;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle4.clearAnimation();
                        toggle2.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 5){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 2;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle5.clearAnimation();
                        toggle2.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 6){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 2;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle6.clearAnimation();
                        toggle2.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else{
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle2.toggle();
                        programmed = 2;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle.clearAnimation();
                        toggle2.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;

                    }
                }
                // #########################

                else {
                    if(ptrn == 2){
                        if(programmed == 1){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 3){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle3.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 4){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle4.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 5){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle5.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 6){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle6.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                    }
                    else{
                        // NORMAL LOGIC
                        total_toggles += 1;
                        current_toggles += 1;
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }


                        toggle5.toggle();

                        if(CheckWinningCondition()){
                            levelWon();
                        }
                        // NORMAL LOGIC
                    }
                }
            }
        });

        toggle3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (pattern_state == 0){

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle2.toggle();

                    if(CheckWinningCondition()){
                        levelWon();
                    }
                    // NORMAL LOGIC
                }

                // ###PROGRAMMING THE BUTTON
                else if(pattern_state == 1){
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle3.toggle();
                    ptrn = 3;
                    pattern_state = 2;
                    //infotext.setText("Connect it.");
                    toggle3.startAnimation(animRotate);
                }
                else if(pattern_state == 2){
                    if(ptrn == 3){
                        toggle3.toggle();
                    }
                    else if(ptrn == 2){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle3.toggle();
                        programmed = 3;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle2.clearAnimation();
                        toggle3.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;

                    }
                    else if(ptrn == 4){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle3.toggle();
                        programmed = 3;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle4.clearAnimation();
                        toggle3.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 5){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle3.toggle();
                        programmed = 3;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle5.clearAnimation();
                        toggle3.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 6){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle3.toggle();
                        programmed = 3;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle6.clearAnimation();
                        toggle3.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else{
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle3.toggle();
                        programmed = 3;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle.clearAnimation();
                        toggle3.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                }
                // #########################

                else {
                    if(ptrn == 3){
                        if(programmed == 1){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 2){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle2.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 4){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle4.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 5){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle5.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 6){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle6.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                    }
                    else{
                        // NORMAL LOGIC
                        total_toggles += 1;
                        current_toggles += 1;
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }

                        toggle2.toggle();

                        if(CheckWinningCondition()){
                            levelWon();
                        }
                        // NORMAL LOGIC
                    }
                }
            }
        });

        toggle4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (pattern_state == 0){

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle.toggle();
                    //toggle5.toggle();

                    if(CheckWinningCondition()){
                        levelWon();
                    }
                    // NORMAL LOGIC
                }

                // ###PROGRAMMING THE BUTTON
                else if(pattern_state == 1){
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle4.toggle();
                    ptrn = 4;
                    pattern_state = 2;
                    //infotext.setText("Connect it.");
                    toggle4.startAnimation(animRotate);
                }
                else if(pattern_state == 2){
                    if(ptrn == 4){
                        toggle4.toggle();
                    }
                    else if(ptrn == 2){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle4.toggle();
                        programmed = 4;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle2.clearAnimation();
                        toggle4.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;

                    }
                    else if(ptrn == 1){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle4.toggle();
                        programmed = 4;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle.clearAnimation();
                        toggle4.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 5){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle4.toggle();
                        programmed = 4;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle5.clearAnimation();
                        toggle4.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 6){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle4.toggle();
                        programmed = 4;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle6.clearAnimation();
                        toggle4.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else{
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle4.toggle();
                        programmed = 4;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle3.clearAnimation();
                        toggle4.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                }
                // #########################

                else {
                    if(ptrn == 4){
                        if(programmed == 1){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 2){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle2.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 3){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle3.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 5){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle5.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 6){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle6.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                    }
                    else{
                        // NORMAL LOGIC
                        total_toggles += 1;
                        current_toggles += 1;
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }

                        toggle.toggle();
                        //toggle5.toggle();

                        if(CheckWinningCondition()){
                            levelWon();
                        }
                        // NORMAL LOGIC
                    }
                }
            }
        });

        toggle5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (pattern_state == 0){

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle2.toggle();

                    if(CheckWinningCondition()){
                        levelWon();
                    }
                    // NORMAL LOGIC
                }

                // ###PROGRAMMING THE BUTTON
                else if(pattern_state == 1){
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle5.toggle();
                    ptrn = 5;
                    pattern_state = 2;
                    //infotext.setText("Connect it.");
                    toggle5.startAnimation(animRotate);
                }
                else if(pattern_state == 2){
                    if(ptrn == 5){
                        toggle5.toggle();
                    }
                    else if(ptrn == 2){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle5.toggle();
                        programmed = 5;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle2.clearAnimation();
                        toggle5.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;

                    }
                    else if(ptrn == 1){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle5.toggle();
                        programmed = 5;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle.clearAnimation();
                        toggle5.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 4){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle5.toggle();
                        programmed = 5;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle4.clearAnimation();
                        toggle5.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 6){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle5.toggle();
                        programmed = 5;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle6.clearAnimation();
                        toggle5.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else{
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle5.toggle();
                        programmed = 5;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle3.clearAnimation();
                        toggle5.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                }
                // #########################

                else {
                    if(ptrn == 5){
                        if(programmed == 1){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 2){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle2.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 3){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle3.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 4){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle4.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 6){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle6.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                    }
                    else{
                        // NORMAL LOGIC
                        total_toggles += 1;
                        current_toggles += 1;
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }

                        toggle2.toggle();


                        if(CheckWinningCondition()){
                            levelWon();
                        }
                        // NORMAL LOGIC
                    }
                }
            }
        });

        toggle6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (pattern_state == 0){

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle2.toggle();

                    if(CheckWinningCondition()){
                        levelWon();
                    }
                    // NORMAL LOGIC
                }

                // ###PROGRAMMING THE BUTTON
                else if(pattern_state == 1){
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle6.toggle();
                    ptrn = 6;
                    pattern_state = 2;
                    //infotext.setText("Connect it.");
                    toggle6.startAnimation(animRotate);
                }
                else if(pattern_state == 2){
                    if(ptrn == 6){
                        toggle6.toggle();
                    }
                    else if(ptrn == 2){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle6.toggle();
                        programmed = 6;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle2.clearAnimation();
                        toggle6.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;

                    }
                    else if(ptrn == 1){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle6.toggle();
                        programmed = 6;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle.clearAnimation();
                        toggle6.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 4){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle6.toggle();
                        programmed = 6;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle4.clearAnimation();
                        toggle6.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 5){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle6.toggle();
                        programmed = 6;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle5.clearAnimation();
                        toggle6.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else{
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle6.toggle();
                        programmed = 6;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle3.clearAnimation();
                        toggle6.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                }
                // #########################

                else {
                    if(ptrn == 6){
                        if(programmed == 1){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 2){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle2.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 3){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle3.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 4){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle4.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 5){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle5.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                    }
                    else{
                        // NORMAL LOGIC
                        total_toggles += 1;
                        current_toggles += 1;
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }

                        toggle2.toggle();


                        if(CheckWinningCondition()){
                            levelWon();
                        }
                        // NORMAL LOGIC
                    }
                }
            }
        });


        makeptrn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }

                if(pattern_state == 0){
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                        mp.start();
                    }
                    makeptrn.setText("CANCEL");
                    //infotext.setText("Select button to program.");
                    pattern_state = 1;
                }
                else if(pattern_state == 1) {
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                        mp.start();
                    }
                    ptrn = 0;
                    pattern_state = 0;
                    makeptrn.setText("MAKE PTRN");
                    infotext.setText("");
                    toggle.clearAnimation();
                    toggle2.clearAnimation();
                    toggle3.clearAnimation();
                    toggle4.clearAnimation();
                    toggle5.clearAnimation();
                    toggle6.clearAnimation();

                }
                else if(pattern_state == 2){
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                        mp.start();
                    }
                    ptrn = 0;
                    pattern_state = 0;
                    makeptrn.setText("MAKE PTRN");
                    infotext.setText("");
                    toggle.clearAnimation();
                    toggle2.clearAnimation();
                    toggle3.clearAnimation();
                    toggle4.clearAnimation();
                    toggle5.clearAnimation();
                    toggle6.clearAnimation();


                }
                else if(pattern_state == 3){
                }
            }
        });



        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_retrys += 1;

                restart_level();
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
            }
        });

        rate_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_retrys += 1;

                rate_application();
                if (sounds_toggle == 0) {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
            }
        });

    }

    public void BackButton(View view){
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        //finish();
        super.onBackPressed();
    }

    public boolean CheckWinningCondition(){
        if(toggle.isChecked() && toggle2.isChecked() && toggle3.isChecked()
                && toggle4.isChecked() && toggle5.isChecked()
                && toggle6.isChecked()){
            return true;
        }
        else{
            return false;
        }
    }

    public void levelWon(){

        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 1);



        if(level_fourteen_completed == 0){
            level_fourteen_completed = 1;
            total_completed += 1;
        }
        else{
            level_fourteen_completed = 1;
        }

        if(current_toggles <= toggles_for_star){
            if(level_fourteen_starred == 0){
                level_fourteen_starred = 1;
                total_starred += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.levelcompletedsfx);
                    mp.start();
                }
            }
            else{
                level_fourteen_starred = 1;
            }
        }

        Log.d("TAG", Integer.toString(total_completed));
        // Commit current TotalToggles to save
        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = totalstatics.edit();
        editor.putInt("TotalToggles", total_toggles);
        editor.apply();
        editor.putInt("TotalCompleted", total_completed);
        editor.apply();
        editor.putInt("TotalStarred", total_starred);
        editor.apply();
        editor.putInt("TotalRetrys", total_retrys);
        editor.apply();
        editor.putInt("TotalPtrns", total_ptrns);
        editor.apply();

        editor.putInt("LevelFourteenCompleted", level_fourteen_completed);
        editor.putInt("LevelFourteenStarred", level_fourteen_starred);
        editor.apply();
        note_combination = 0;
        editor.putInt("NoteCombination", note_combination);
        editor.apply();


        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.completedmessageorange,
                (ViewGroup) findViewById(R.id.custom_toast_layout_id));

        // Toast...
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

        finish();
    }

    public void rate_application(){
        Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }

    public void restart_level(){
        if(toggle.isChecked()){
            toggle.setChecked(true);
        }
        else{
            toggle.setChecked(true);

        }
        if(toggle2.isChecked()){
            toggle2.setChecked(false);
        }

        if(toggle3.isChecked()){
            toggle3.setChecked(false);
        }

        if(toggle4.isChecked()){
            toggle4.setChecked(false);
        }
        if(toggle5.isChecked()){
            toggle5.setChecked(false);
        }
        if(toggle6.isChecked()){
            toggle6.setChecked(false);
        }
        toggle.clearAnimation();
        toggle2.clearAnimation();
        toggle3.clearAnimation();
        toggle4.clearAnimation();
        toggle5.clearAnimation();
        toggle6.clearAnimation();


        infotext.setText("");
        makeptrn.setText("MAKE PTRN");
        makeptrn.setVisibility(View.VISIBLE);

        current_toggles = 0;
        pattern_state = 0;
        ptrn = 0;
        programmed = 0;
    }
}
