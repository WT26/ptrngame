package wt.ptrngame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
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

public class levelSixteen extends AppCompatActivity {
    public static final String myPrefsKey13 = "MyPrefsFile";
    int sounds_toggle;

    Intent intent = getIntent();
    ToggleButton toggle;
    ToggleButton toggle2;
    ToggleButton toggle3;
    ToggleButton toggle4;
    ToggleButton toggle5;
    ToggleButton toggle6;
    ToggleButton toggle7;
    ToggleButton toggle8;


    Button back;
    Button restart;
    Button makeptrn;

    TextView infotext;

    public static final String totalstatics = "MyPrefsFile";
    int total_toggles;
    int total_completed;
    int total_starred;
    int total_retrys;
    int total_ptrns;

    public static final String myPrefsKey3 = "MyPrefsFile";
    int level_sixteen_completed;
    int level_sixteen_starred;

    int current_toggles;
    int toggles_for_star;

    int pattern_state;
    int ptrn;
    int programmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_sixteen);

        current_toggles = 0;
        toggles_for_star = 4;

        // Getting information
        final SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = totalstatics.getInt("TotalToggles", 0);
        total_starred = totalstatics.getInt("TotalStarred", 0);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 0);
        total_retrys = totalstatics.getInt("TotalRetrys", 0);
        total_completed = totalstatics.getInt("TotalCompleted", 0);
        total_ptrns = totalstatics.getInt("TotalPtrns", 0);


        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        level_sixteen_completed = levelsaves.getInt("LevelSixteenCompleted", 0);
        level_sixteen_starred = levelsaves.getInt("LevelSixteenStarred", 0);

        back = (Button) findViewById(R.id.angry_btn);
        restart = (Button) findViewById(R.id.button5);
        makeptrn = (Button) findViewById(R.id.button8);

        toggle = (ToggleButton) findViewById(R.id.button2);
        toggle.toggle();
        toggle2 = (ToggleButton) findViewById(R.id.button1);
        toggle3 = (ToggleButton) findViewById(R.id.button3);
        toggle4 = (ToggleButton) findViewById(R.id.toggleButton9);
        toggle4.toggle();
        toggle5 = (ToggleButton) findViewById(R.id.toggleButton10);
        toggle5.toggle();
        toggle6 = (ToggleButton) findViewById(R.id.toggleButton11);
        toggle6.toggle();
        toggle7 = (ToggleButton) findViewById(R.id.toggleButton12);
        toggle8 = (ToggleButton) findViewById(R.id.toggleButton13);


        infotext = (TextView) findViewById(R.id.textView32);


        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        final Animation animSelect = AnimationUtils.loadAnimation(this, R.anim.anim_select);


        pattern_state = 0;
        ptrn = 0;
        programmed = 0;


        toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (pattern_state == 0){
                    pattern_state = 3;
                    makeptrn.setVisibility(view.GONE);


                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle5.toggle();
                    toggle6.toggle();
                    toggle7.toggle();
                    toggle4.toggle();


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
                    else if(ptrn == 7){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 1;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle7.clearAnimation();
                        toggle.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }

                    else if(ptrn == 8){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle.toggle();
                        programmed = 1;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle8.clearAnimation();
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
                        else if(programmed == 7){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle7.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 8){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle8.toggle();

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

                        toggle6.toggle();
                        toggle7.toggle();
                        toggle5.toggle();
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

                    pattern_state = 3;
                    makeptrn.setVisibility(view.GONE);

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }
                    toggle.toggle();
                    toggle5.toggle();
                    toggle3.toggle();
                    toggle4.toggle();

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
                        toggle2.toggle();
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
                        toggle2.toggle();
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
                        toggle2.toggle();
                        programmed = 2;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle6.clearAnimation();
                        toggle2.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 7){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle2.toggle();
                        programmed = 2;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle7.clearAnimation();
                        toggle2.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 8){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle2.toggle();
                        programmed = 2;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle8.clearAnimation();
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
                        else if(programmed == 7){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle7.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 8){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle8.toggle();

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
                        toggle5.toggle();
                        toggle3.toggle();
                        toggle4.toggle();

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
                    pattern_state = 3;
                    makeptrn.setVisibility(view.GONE);

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle.toggle();
                    toggle4.toggle();
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
                    else if(ptrn == 7){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle3.toggle();
                        programmed = 3;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle7.clearAnimation();
                        toggle3.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 8){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle3.toggle();
                        programmed = 3;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle8.clearAnimation();
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
                        else if(programmed == 7){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle7.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 8){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle8.toggle();

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
                        toggle4.toggle();
                        toggle6.toggle();

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
                    pattern_state = 3;
                    makeptrn.setVisibility(view.GONE);

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle.toggle();
                    toggle2.toggle();
                    toggle5.toggle();
                    toggle6.toggle();
                    toggle8.toggle();

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
                    else if(ptrn == 7){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle4.toggle();
                        programmed = 4;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle7.clearAnimation();
                        toggle4.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 8){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle4.toggle();
                        programmed = 4;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle8.clearAnimation();
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
                        else if(programmed == 7){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle7.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 8){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle8.toggle();

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
                        toggle2.toggle();
                        toggle5.toggle();
                        toggle6.toggle();
                        toggle8.toggle();

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
                    pattern_state = 3;
                    makeptrn.setVisibility(view.GONE);
                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle.toggle();
                    toggle4.toggle();
                    toggle7.toggle();
                    toggle8.toggle();
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
                    else if(ptrn == 7){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle5.toggle();
                        programmed = 5;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle7.clearAnimation();
                        toggle5.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 8){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle5.toggle();
                        programmed = 5;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle8.clearAnimation();
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
                        else if(programmed == 7){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle7.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 8){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle8.toggle();

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
                        toggle4.toggle();
                        toggle7.toggle();
                        toggle8.toggle();
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
                    pattern_state = 3;
                    makeptrn.setVisibility(view.GONE);

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle7.toggle();
                    toggle.toggle();
                    toggle2.toggle();
                    toggle8.toggle();


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
                    else if(ptrn == 7){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle6.toggle();
                        programmed = 6;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle7.clearAnimation();
                        toggle6.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 8){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle6.toggle();
                        programmed = 6;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle8.clearAnimation();
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
                        else if(programmed == 7){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle7.toggle();

                            if(CheckWinningCondition()){
                                levelWon();
                            }
                        }
                        else if(programmed == 8){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle8.toggle();

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

                        toggle7.toggle();
                        toggle.toggle();
                        toggle2.toggle();
                        toggle8.toggle();

                        if(CheckWinningCondition()){
                            levelWon();
                        }
                        // NORMAL LOGIC
                    }
                }
            }
        });

        toggle7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (pattern_state == 0){
                    pattern_state = 3;
                    makeptrn.setVisibility(view.GONE);

                    // NORMAL LOGIC
                    total_toggles += 1;
                    current_toggles += 1;
                    if(sounds_toggle == 0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                        mp.start();
                    }

                    toggle4.toggle();
                    toggle5.toggle();
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
                    toggle7.toggle();
                    ptrn = 7;
                    pattern_state = 2;
                    //infotext.setText("Connect it.");
                    toggle7.startAnimation(animRotate);
                }
                else if(pattern_state == 2){
                    if(ptrn == 7){
                        toggle7.toggle();
                    }
                    else if(ptrn == 2){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle7.toggle();
                        programmed = 7;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle2.clearAnimation();
                        toggle7.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;

                    }
                    else if(ptrn == 1){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle7.toggle();
                        programmed = 7;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle.clearAnimation();
                        toggle7.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 4){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle7.toggle();
                        programmed = 7;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle4.clearAnimation();
                        toggle7.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 5){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle7.toggle();
                        programmed = 7;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle5.clearAnimation();
                        toggle7.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 6){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle7.toggle();
                        programmed = 7;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle6.clearAnimation();
                        toggle7.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 8){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle7.toggle();
                        programmed = 7;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle8.clearAnimation();
                        toggle7.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else{
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle7.toggle();
                        programmed = 7;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle3.clearAnimation();
                        toggle7.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                }
                // #########################

                else {
                    if(ptrn == 7){
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
                        else if(programmed == 8){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle8.toggle();

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

                        toggle4.toggle();
                        toggle5.toggle();
                        toggle6.toggle();

                        if(CheckWinningCondition()){
                            levelWon();
                        }
                        // NORMAL LOGIC
                    }
                }
            }
        });

        toggle8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (pattern_state == 0){
                    pattern_state = 3;
                    makeptrn.setVisibility(view.GONE);

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
                    toggle8.toggle();
                    ptrn = 8;
                    pattern_state = 2;
                    //infotext.setText("Connect it.");
                    toggle8.startAnimation(animRotate);
                }
                else if(pattern_state == 2){
                    if(ptrn == 8){
                        toggle8.toggle();
                    }
                    else if(ptrn == 2){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle8.toggle();
                        programmed = 8;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle2.clearAnimation();
                        toggle8.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;

                    }
                    else if(ptrn == 1){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle8.toggle();
                        programmed = 8;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle.clearAnimation();
                        toggle8.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 4){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle8.toggle();
                        programmed = 8;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle4.clearAnimation();
                        toggle8.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 5){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle8.toggle();
                        programmed = 8;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle5.clearAnimation();
                        toggle8.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 6){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle8.toggle();
                        programmed = 8;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle6.clearAnimation();
                        toggle8.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else if(ptrn == 7){
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle8.toggle();
                        programmed = 8;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle7.clearAnimation();
                        toggle8.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                    else{
                        if(sounds_toggle == 0){
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                            mp.start();
                        }
                        toggle8.toggle();
                        programmed = 8;
                        pattern_state = 3;
                        //infotext.setText("Now its connected.");
                        makeptrn.setText("MAKE PTRN");
                        toggle3.clearAnimation();
                        toggle8.startAnimation(animSelect);
                        makeptrn.setVisibility(view.GONE);
                        total_ptrns += 1;
                    }
                }
                // #########################

                else {
                    if(ptrn == 8){
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
                        else if(programmed == 7){
                            total_toggles += 1;
                            current_toggles += 1;
                            if(sounds_toggle == 0){
                                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                                mp.start();
                            }

                            toggle7.toggle();

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
                    toggle7.clearAnimation();
                    toggle8.clearAnimation();

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
                    toggle7.clearAnimation();
                    toggle8.clearAnimation();


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
                && toggle6.isChecked() && toggle7.isChecked()
                && toggle8.isChecked()){
            return true;
        }
        else{
            return false;
        }
    }

    public void levelWon(){

        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 1);



        if(level_sixteen_completed == 0){
            level_sixteen_completed = 1;
            total_completed += 1;
        }
        else{
            level_sixteen_completed = 1;
        }

        if(current_toggles <= toggles_for_star){
            if(level_sixteen_starred == 0){
                level_sixteen_starred = 1;
                total_starred += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.levelcompletedsfx);
                    mp.start();
                }
            }
            else{
                level_sixteen_starred = 1;
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

        editor.putInt("LevelSixteenCompleted", level_sixteen_completed);
        editor.putInt("LevelSixteenStarred", level_sixteen_starred);
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
            toggle4.setChecked(true);
        }
        else{
            toggle4.setChecked(true);
        }

        if(toggle5.isChecked()){
            toggle5.setChecked(true);
        }
        else {
            toggle5.setChecked(true);
        }

        if(toggle6.isChecked()){
            toggle6.setChecked(true);
        }
        else{
            toggle6.setChecked(true);
        }

        if(toggle7.isChecked()){
            toggle7.setChecked(false);
        }

        if(toggle8.isChecked()){
            toggle8.setChecked(false);
        }
        toggle.clearAnimation();
        toggle2.clearAnimation();
        toggle3.clearAnimation();
        toggle4.clearAnimation();
        toggle5.clearAnimation();
        toggle6.clearAnimation();
        toggle7.clearAnimation();
        toggle8.clearAnimation();


        infotext.setText("");
        makeptrn.setText("MAKE PTRN");
        makeptrn.setVisibility(View.VISIBLE);

        current_toggles = 0;
        pattern_state = 0;
        ptrn = 0;
        programmed = 0;
    }
}
