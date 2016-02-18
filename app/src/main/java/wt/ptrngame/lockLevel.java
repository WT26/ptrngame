package wt.ptrngame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class lockLevel extends AppCompatActivity {
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
    ToggleButton toggle9;
    ToggleButton toggle10;
    ToggleButton toggle11;
    ToggleButton toggle12;
    ToggleButton toggle13;

    Button back;
    Button restart;

    public static final String mykeyorangelevel = "MyPrefsFile";
    int orangelevel_completed;

    public static final String myPrefsKey = "MyPrefsFile";
    int total_toggles;

    public static final String myPrefsKey6 = "MyPrefsFile";
    int total_retrys;




    int current_toggles;
    int toggles_for_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_level);

        current_toggles = 0;
        toggles_for_star = 6;

        // Getting information
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = preferences.getInt("TotalToggles", 0);

        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        orangelevel_completed = preferences3.getInt("OrangeLevelCompleted", 0);

        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 0);

        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        total_retrys = preferences6.getInt("TotalRetrys", 0);


        back = (Button) findViewById(R.id.angry_btn);
        restart = (Button) findViewById(R.id.button5);

        toggle = (ToggleButton) findViewById(R.id.chkState);
        toggle2 = (ToggleButton) findViewById(R.id.toggleButton2);
        toggle3 = (ToggleButton) findViewById(R.id.button4);
        toggle4 = (ToggleButton) findViewById(R.id.toggleButton);
        toggle5 = (ToggleButton) findViewById(R.id.toggleButton3);
        toggle6 = (ToggleButton) findViewById(R.id.toggleButton4);
        toggle7 = (ToggleButton) findViewById(R.id.toggleButton5);
        toggle8 = (ToggleButton) findViewById(R.id.toggleButton6);
        toggle9 = (ToggleButton) findViewById(R.id.toggleButton7);
        toggle10 = (ToggleButton) findViewById(R.id.toggleButton8);
        toggle11 = (ToggleButton) findViewById(R.id.button1);
        toggle12 = (ToggleButton) findViewById(R.id.button2);
        toggle13 = (ToggleButton) findViewById(R.id.button3);




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
                if(toggle6.isChecked()){
                    toggle6.setChecked(false);
                }
                else {
                    toggle6.setChecked(true);
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
                if(toggle6.isChecked()){
                    toggle6.setChecked(false);
                }
                else {
                    toggle6.setChecked(true);
                }
                if(toggle11.isChecked()){
                    toggle11.setChecked(false);
                }
                else {
                    toggle11.setChecked(true);
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

                if(toggle12.isChecked()){
                    toggle12.setChecked(false);
                }
                else {
                    toggle12.setChecked(true);
                }
                if(toggle7.isChecked()){
                    toggle7.setChecked(false);
                }
                else {
                    toggle7.setChecked(true);
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

                if(toggle13.isChecked()){
                    toggle13.setChecked(false);
                }
                else {
                    toggle13.setChecked(true);
                }
                if(toggle2.isChecked()){
                    toggle2.setChecked(false);
                }
                else {
                    toggle2.setChecked(true);
                }
                if(toggle8.isChecked()){
                    toggle8.setChecked(false);
                }
                else {
                    toggle8.setChecked(true);
                }


                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle5.setOnClickListener(new View.OnClickListener() {
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
                if(toggle12.isChecked()){
                    toggle12.setChecked(false);
                }
                else {
                    toggle12.setChecked(true);
                }
                if(toggle13.isChecked()){
                    toggle13.setChecked(false);
                }
                else {
                    toggle13.setChecked(true);
                }



                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;
                current_toggles += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }


                if(toggle8.isChecked()){
                    toggle8.setChecked(false);
                }
                else {
                    toggle8.setChecked(true);
                }
                if(toggle5.isChecked()){
                    toggle5.setChecked(false);
                }
                else {
                    toggle5.setChecked(true);
                }
                if(toggle7.isChecked()){
                    toggle7.setChecked(false);
                }
                else {
                    toggle7.setChecked(true);
                }
                if(toggle10.isChecked()){
                    toggle10.setChecked(false);
                }
                else {
                    toggle10.setChecked(true);
                }
                if(toggle11.isChecked()){
                    toggle11.setChecked(false);
                }
                else {
                    toggle11.setChecked(true);
                }




                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle7.setOnClickListener(new View.OnClickListener() {
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
                if(toggle5.isChecked()){
                    toggle5.setChecked(false);
                }
                else {
                    toggle5.setChecked(true);
                }
                if(toggle8.isChecked()){
                    toggle8.setChecked(false);
                }
                else {
                    toggle8.setChecked(true);
                }
                if(toggle9.isChecked()){
                    toggle9.setChecked(false);
                }
                else {
                    toggle9.setChecked(true);
                }


                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle8.setOnClickListener(new View.OnClickListener() {
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
                if(toggle11.isChecked()){
                    toggle11.setChecked(false);
                }
                else {
                    toggle11.setChecked(true);
                }
                if(toggle13.isChecked()){
                    toggle13.setChecked(false);
                }
                else {
                    toggle13.setChecked(true);
                }


                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle9.setOnClickListener(new View.OnClickListener() {
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
                if(toggle7.isChecked()){
                    toggle7.setChecked(false);
                }
                else {
                    toggle7.setChecked(true);
                }
                if(toggle8.isChecked()){
                    toggle8.setChecked(false);
                }
                else {
                    toggle8.setChecked(true);
                }
                if(toggle10.isChecked()){
                    toggle10.setChecked(false);
                }
                else {
                    toggle10.setChecked(true);
                }


                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle10.setOnClickListener(new View.OnClickListener() {
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
                if(toggle8.isChecked()){
                    toggle8.setChecked(false);
                }
                else {
                    toggle8.setChecked(true);
                }
                if(toggle12.isChecked()){
                    toggle12.setChecked(false);
                }
                else {
                    toggle12.setChecked(true);
                }


                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;
                current_toggles += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }




                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;
                current_toggles += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }

                if(toggle6.isChecked()){
                    toggle6.setChecked(false);
                }
                else {
                    toggle6.setChecked(true);
                }
                if(toggle8.isChecked()){
                    toggle8.setChecked(false);
                }
                else {
                    toggle8.setChecked(true);
                }
                if(toggle10.isChecked()){
                    toggle10.setChecked(false);
                }
                else {
                    toggle10.setChecked(true);
                }


                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

        toggle13.setOnClickListener(new View.OnClickListener() {
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
                if(toggle5.isChecked()){
                    toggle5.setChecked(false);
                }
                else {
                    toggle5.setChecked(true);
                }
                if(toggle8.isChecked()){
                    toggle8.setChecked(false);
                }
                else {
                    toggle8.setChecked(true);
                }
                if(toggle9.isChecked()){
                    toggle9.setChecked(false);
                }
                else {
                    toggle9.setChecked(true);
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
                && toggle4.isChecked() && toggle5.isChecked() && toggle6.isChecked()
                && toggle7.isChecked() && toggle8.isChecked() && toggle9.isChecked()
                && toggle10.isChecked() && toggle11.isChecked() && toggle12.isChecked()
                && toggle13.isChecked()){
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


        if(sounds_toggle == 0){
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.levelcompletedsfx);
            mp.start();
        }

        orangelevel_completed = 1;

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor2 = preferences2.edit();
        editor2.putInt("OrangeLevelCompleted", orangelevel_completed);
        editor2.apply();

        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor6 = preferences6.edit();
        editor6.putInt("TotalRetrys", total_retrys);
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
        if(toggle5.isChecked()){
            toggle5.setChecked(false);
        }
        if(toggle6.isChecked()){
            toggle6.setChecked(false);
        }
        if(toggle7.isChecked()){
            toggle7.setChecked(false);
        }
        if(toggle8.isChecked()){
            toggle8.setChecked(false);
        }
        if(toggle9.isChecked()){
            toggle9.setChecked(false);
        }
        if(toggle10.isChecked()){
            toggle10.setChecked(false);
        }
        if(toggle11.isChecked()){
            toggle11.setChecked(false);
        }
        if(toggle12.isChecked()){
            toggle12.setChecked(false);
        }
        if(toggle13.isChecked()){
            toggle13.setChecked(false);
        }
        current_toggles = 0;

    }
}
