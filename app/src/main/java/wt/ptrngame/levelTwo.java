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
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class levelTwo extends AppCompatActivity {
    public static final String myPrefsKey13 = "MyPrefsFile";
    int sounds_toggle;

    Intent intent = getIntent();
    ToggleButton toggle;
    ToggleButton toggle2;
    ToggleButton toggle3;
    ToggleButton toggle4;
    Button back;
    Button restart;

    public static final String totalstatics = "MyPrefsFile";
    int total_toggles;
    int total_completed;
    int total_starred;
    int total_retrys;
    int note_combination;

    public static final String levelsaves = "MyPrefsFile";
    int level_two_completed;
    int level_two_starred;

    int current_toggles;
    int toggles_for_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);

        current_toggles = 0;
        toggles_for_star = 3;

        // Getting information
        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = totalstatics.getInt("TotalToggles", 0);
        total_completed = totalstatics.getInt("TotalCompleted", 0);
        total_starred = totalstatics.getInt("TotalStarred", 0);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 0);
        note_combination = totalstatics.getInt("NoteCombination", 0);

        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        level_two_completed = levelsaves.getInt("LevelTwoCompleted", 0);
        level_two_starred = levelsaves.getInt("LevelTwoStarred", 0);





        back = (Button) findViewById(R.id.angry_btn);
        restart = (Button) findViewById(R.id.button5);

        toggle = (ToggleButton) findViewById(R.id.chkState);
        toggle2 = (ToggleButton) findViewById(R.id.toggleButton2);
        toggle3 = (ToggleButton) findViewById(R.id.button4);
        toggle4 = (ToggleButton) findViewById(R.id.toggleButton);

        toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;
                current_toggles += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }


                if(toggle2.isChecked()){
                    toggle2.setChecked(false);
                }
                else {
                    toggle2.setChecked(true);
                }
                if(toggle3.isChecked()){
                    toggle3.setChecked(false);
                }
                else {
                    toggle3.setChecked(true);
                }
                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;
                current_toggles += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }

                if(toggle3.isChecked()){
                    toggle3.setChecked(false);
                }
                else {
                    toggle3.setChecked(true);
                }
                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;
                current_toggles += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }

                if(toggle.isChecked()){
                    toggle.setChecked(false);
                }
                else {
                    toggle.setChecked(true);
                }
                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;
                current_toggles += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }

                if(toggle3.isChecked()){
                    toggle3.setChecked(false);
                }
                else {
                    toggle3.setChecked(true);
                }
                if(CheckWinningCondition()){
                    levelWon();
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
                && toggle4.isChecked()){
            return true;
        }
        else{
            return false;
        }
    }

    public void levelWon(){

        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 1);

        if(level_two_completed == 0){
            level_two_completed = 1;
            total_completed += 1;
        }
        else{
            level_two_completed = 1;
        }

        if(current_toggles <= toggles_for_star){
            if(level_two_starred == 0){
                level_two_starred = 1;
                total_starred += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.levelcompletedsfx);
                    mp.start();
                }
            }
            else{
                level_two_starred = 1;
            }
        }

        if(note_combination == 1){
            note_combination = 2;
        }
        else {
            note_combination = 0;
        }
        Log.d("moi", Integer.toString(note_combination));
        SharedPreferences.Editor editor = totalstatics.edit();
        editor.putInt("TotalToggles", total_toggles);
        editor.apply();
        editor.putInt("TotalCompleted", total_completed);
        editor.apply();
        editor.putInt("TotalStarred", total_starred);
        editor.apply();
        editor.putInt("TotalRetrys", total_retrys);
        editor.apply();
        editor.putInt("NoteCombination", note_combination);
        editor.apply();


        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor2 = levelsaves.edit();
        editor2.putInt("LevelTwoCompleted", level_two_completed);
        editor2.apply();
        editor2.putInt("LevelTwoStarred", level_two_starred);
        editor2.apply();



        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.completedmessage,
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
            toggle.setChecked(false);
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
        current_toggles = 0;

    }
}
