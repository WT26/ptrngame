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

public class levelFour extends AppCompatActivity {
    public static final String myPrefsKey13 = "MyPrefsFile";
    int sounds_toggle;

    Intent intent = getIntent();
    ToggleButton toggle;
    ToggleButton toggle2;
    ToggleButton toggle3;
    ToggleButton toggle4;
    Button back;
    Button restart;

    public static final String myPrefsKey = "MyPrefsFile";
    int total_toggles;

    public static final String myPrefsKey2 = "MyPrefsFile";
    int total_completed;

    public static final String myPrefsKey3 = "MyPrefsFile";
    int level_four_completed;
    public static final String myPrefsKey4 = "MyPrefsFile";
    int level_four_starred;

    public static final String myPrefsKey5 = "MyPrefsFile";
    int total_starred;

    public static final String myPrefsKey6 = "MyPrefsFile";
    int total_retrys;

    int current_toggles;
    int toggles_for_star;

    int note_combination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four);

        current_toggles = 0;
        toggles_for_star = 4;

        // Getting information
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = preferences.getInt("TotalToggles", 0);

        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        level_four_completed = preferences3.getInt("LevelFourCompleted", 0);

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        total_completed = preferences2.getInt("TotalCompleted", 0);

        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        level_four_starred = preferences4.getInt("LevelFourStarred", 0);

        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        total_starred = preferences5.getInt("TotalStarred", 0);

        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 0);
        note_combination = preferences99.getInt("NoteCombination", 0);

        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        total_retrys = preferences6.getInt("TotalRetrys", 0);


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

                if(toggle4.isChecked()){
                    toggle4.setChecked(false);
                }
                else {
                    toggle4.setChecked(true);
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
                if(toggle4.isChecked()){
                    toggle4.setChecked(false);
                }
                else {
                    toggle4.setChecked(true);
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
                if(toggle.isChecked()){
                    toggle.setChecked(false);
                }
                else {
                    toggle.setChecked(true);
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
        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 1);

        // Commit current TotalToggles to save
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("TotalToggles", total_toggles);
        editor.apply();

        if(level_four_completed == 0){
            level_four_completed = 1;
            total_completed += 1;
        }
        else{
            level_four_completed = 1;
        }

        Log.d("current toggles", Integer.toString(current_toggles));
        Log.d("ster toggles", Integer.toString(toggles_for_star));

        if(current_toggles <= toggles_for_star){
            if(level_four_starred == 0){
                level_four_starred = 1;
                total_starred += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.levelcompletedsfx);
                    mp.start();
                }
            }
            else{
                level_four_starred = 1;
            }
        }

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor2 = preferences2.edit();
        editor2.putInt("LevelFourCompleted", level_four_completed);
        editor2.apply();

        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor3 = preferences3.edit();
        editor3.putInt("TotalCompleted", total_completed);
        editor3.apply();

        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor4 = preferences4.edit();
        editor4.putInt("TotalStarred", total_starred);
        editor4.apply();

        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor5 = preferences5.edit();
        editor5.putInt("LevelFourStarred", level_four_starred);
        editor5.apply();

        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor6 = preferences6.edit();
        editor6.putInt("TotalRetrys", total_retrys);
        editor6.apply();

        note_combination = 0;
        editor6.putInt("NoteCombination", note_combination);
        editor6.apply();

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
