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

public class levelTwentyOne extends AppCompatActivity {
    public static final String myPrefsKey13 = "MyPrefsFile";
    int sounds_toggle;

    Intent intent = getIntent();
    ToggleButton toggle;
    ToggleButton toggle2;
    ToggleButton toggle3;
    ToggleButton toggle4;


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
    int level_twentyone_completed;
    int level_twentyone_starred;

    int current_toggles;
    int toggles_for_star;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_twenty_one);

        current_toggles = 0;
        toggles_for_star = 1;

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

        infotext = (TextView) findViewById(R.id.textView32);


        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        final Animation animSelect = AnimationUtils.loadAnimation(this, R.anim.anim_select);


        toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                toggle2.toggle();

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
        if(toggle.isChecked() && toggle2.isChecked() && toggle3.isChecked()){
            return true;
        }
        else{
            return false;
        }
    }

    public void levelWon(){

        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 1);



        if(level_twentyone_completed == 0){
            level_twentyone_completed = 1;
            total_completed += 1;
        }
        else{
            level_twentyone_completed = 1;
        }

        if(current_toggles <= toggles_for_star){
            if(level_twentyone_starred == 0){
                level_twentyone_starred = 1;
                total_starred += 1;
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.levelcompletedsfx);
                    mp.start();
                }
            }
            else{
                level_twentyone_starred = 1;
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

        editor.putInt("LevelTwentyoneCompleted", level_twentyone_completed);
        editor.putInt("LevelTwentyoneStarred", level_twentyone_starred);
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
            toggle.setChecked(false);
        }
        if(toggle2.isChecked()){
            toggle2.setChecked(true);
        }
        else{
            toggle2.setChecked(true);

        }
        if(toggle3.isChecked()){
            toggle3.setChecked(false);
        }

        toggle.clearAnimation();
        toggle2.clearAnimation();
        toggle3.clearAnimation();

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
}
