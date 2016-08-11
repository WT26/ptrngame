package wt.ptrngame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
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

public class levelTwentyThree extends AppCompatActivity {
    public static final String myPrefsKey13 = "MyPrefsFile";
    int sounds_toggle;

    Intent intent = getIntent();
    ToggleButton toggle;
    ToggleButton toggle2;
    ToggleButton toggle3;
    ToggleButton toggle4;
    ToggleButton toggle5;
    ToggleButton toggle6;

    ToggleButton togglecirc1;
    ToggleButton togglecirc2;
    ToggleButton togglecirc3;
    ToggleButton togglecirc4;
    ToggleButton togglecirc5;
    ToggleButton togglecirc6;
    ToggleButton togglecirc7;
    ToggleButton togglecirc8;
    ToggleButton togglecirc9;


    Button back;
    Button restart;
    Button makeptrn;

    TextView infotext;

    public static final String totalstatics = "MyPrefsFile";
    int total_toggles;
    int total_completed;
    int total_starred;
    int total_retrys;

    public static final String myPrefsKey3 = "MyPrefsFile";
    int level_twentythree_completed;
    int level_twentythree_starred;

    int current_toggles;
    int toggles_for_star;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_twenty_three);

        current_toggles = 0;
        toggles_for_star = 3;

        // Getting information
        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = totalstatics.getInt("TotalToggles", 0);
        total_starred = totalstatics.getInt("TotalStarred", 0);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 0);
        total_retrys = totalstatics.getInt("TotalRetrys", 0);
        total_completed = totalstatics.getInt("TotalCompleted", 0);

        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);

        back = (Button) findViewById(R.id.angry_btn);
        restart = (Button) findViewById(R.id.button5);
        makeptrn = (Button) findViewById(R.id.button8);

        toggle = (ToggleButton) findViewById(R.id.b1);
        toggle2 = (ToggleButton) findViewById(R.id.b2);
        toggle3 = (ToggleButton) findViewById(R.id.b3);
        toggle4 = (ToggleButton) findViewById(R.id.b4);
        toggle5 = (ToggleButton) findViewById(R.id.b5);
        toggle6 = (ToggleButton) findViewById(R.id.b6);


        togglecirc1 = (ToggleButton) findViewById(R.id.circle1);
        togglecirc2 = (ToggleButton) findViewById(R.id.circle2);
        togglecirc3 = (ToggleButton) findViewById(R.id.circle3);
        togglecirc4 = (ToggleButton) findViewById(R.id.circle4);
        togglecirc5 = (ToggleButton) findViewById(R.id.circle5);
        togglecirc6 = (ToggleButton) findViewById(R.id.circle6);
        togglecirc7 = (ToggleButton) findViewById(R.id.circle7);
        togglecirc8 = (ToggleButton) findViewById(R.id.circle8);
        togglecirc9 = (ToggleButton) findViewById(R.id.circle9);


        infotext = (TextView) findViewById(R.id.textView32);

        final Animation animCircChange = AnimationUtils.loadAnimation(this, R.anim.anim_circle_change);

        levelStartToggles();

        toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                togglecirc1.toggle();
                togglecirc2.toggle();
                togglecirc3.toggle();
                togglecirc1.startAnimation(animCircChange);
                togglecirc2.startAnimation(animCircChange);
                togglecirc3.startAnimation(animCircChange);

                clickked();
            }
        });

        toggle2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                togglecirc4.toggle();
                togglecirc5.toggle();
                togglecirc6.toggle();

                togglecirc4.startAnimation(animCircChange);
                togglecirc5.startAnimation(animCircChange);
                togglecirc6.startAnimation(animCircChange);

                clickked();
            }
        });

        toggle3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                togglecirc7.toggle();
                togglecirc8.toggle();
                togglecirc9.toggle();

                togglecirc7.startAnimation(animCircChange);
                togglecirc8.startAnimation(animCircChange);
                togglecirc9.startAnimation(animCircChange);

                clickked();
            }
        });

        toggle4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                togglecirc1.toggle();
                togglecirc4.toggle();
                togglecirc7.toggle();

                togglecirc1.startAnimation(animCircChange);
                togglecirc4.startAnimation(animCircChange);
                togglecirc7.startAnimation(animCircChange);

                clickked();
            }
        });

        toggle5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                togglecirc2.toggle();
                togglecirc5.toggle();
                togglecirc8.toggle();

                togglecirc2.startAnimation(animCircChange);
                togglecirc5.startAnimation(animCircChange);
                togglecirc8.startAnimation(animCircChange);

                clickked();
            }
        });

        toggle6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                togglecirc3.toggle();
                togglecirc6.toggle();
                togglecirc9.toggle();

                togglecirc3.startAnimation(animCircChange);
                togglecirc6.startAnimation(animCircChange);
                togglecirc9.startAnimation(animCircChange);

                clickked();
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
        if(togglecirc1.isChecked() && togglecirc2.isChecked()
                && togglecirc3.isChecked() && togglecirc4.isChecked()
                && togglecirc5.isChecked() && togglecirc6.isChecked()
                && togglecirc7.isChecked() && togglecirc8.isChecked()
                && togglecirc9.isChecked() ){
            return true;
        }
        else{
            return false;
        }
    }

    public void levelWon(){

        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 1);



        if(level_twentythree_completed == 0){
            level_twentythree_completed = 1;
            total_completed += 1;
        }
        else{
            level_twentythree_completed = 1;
        }

        if(current_toggles <= toggles_for_star){
            if(level_twentythree_starred == 0){
                level_twentythree_starred = 1;
                total_starred += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.levelcompletedsfx);
                    mp.start();
                }
            }
            else{
                level_twentythree_starred = 1;
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

        editor.putInt("LevelTwentythreeCompleted", level_twentythree_completed);
        editor.putInt("LevelTwentythreeStarred", level_twentythree_starred);
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

        togglesOff();
        levelStartToggles();

        //toggle.clearAnimation();
        //toggle2.clearAnimation();
        //toggle3.clearAnimation();

        current_toggles = 0;
    }

    public void clickked(){
        total_toggles += 1;
        current_toggles += 1;
        if (sounds_toggle == 0) {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
            mp.start();
        }

        if (CheckWinningCondition()) {
            levelWon();
        }
    }

    public void levelStartToggles(){
        togglecirc2.toggle();
        togglecirc3.toggle();
        togglecirc4.toggle();
        togglecirc7.toggle();
    }

    public void togglesOff(){
        if(togglecirc1.isChecked()){
            togglecirc1.setChecked(false);
        }
        if(togglecirc2.isChecked()){
            togglecirc2.setChecked(false);
        }
        if(togglecirc3.isChecked()){
            togglecirc3.setChecked(false);
        }
        if(togglecirc4.isChecked()){
            togglecirc4.setChecked(false);
        }
        if(togglecirc5.isChecked()){
            togglecirc5.setChecked(false);
        }
        if(togglecirc6.isChecked()){
            togglecirc6.setChecked(false);
        }
        if(togglecirc7.isChecked()){
            togglecirc7.setChecked(false);
        }
        if(togglecirc8.isChecked()){
            togglecirc8.setChecked(false);
        }
        if(togglecirc9.isChecked()){
            togglecirc9.setChecked(false);
        }
    }
}
