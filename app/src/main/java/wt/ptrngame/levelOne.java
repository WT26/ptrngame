package wt.ptrngame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class levelOne extends AppCompatActivity {
    Intent intent = getIntent();
    ToggleButton toggle;
    ToggleButton toggle2;
    ToggleButton toggle3;
    Button back;

    public static final String myPrefsKey = "MyPrefsFile";
    int total_toggles;

    public static final String myPrefsKey2 = "MyPrefsFile";
    int total_completed;

    public static final String myPrefsKey3 = "MyPrefsFile";
    int level_one_completed;

    public static final String myPrefsKey4 = "MyPrefsFile";
    int level_one_starred;

    public static final String myPrefsKey5 = "MyPrefsFile";
    int total_starred;

    int current_toggles;
    int toggles_for_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        current_toggles = 0;
        toggles_for_star = 2;

        // Getting information
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = preferences.getInt("TotalToggles", 0);

        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_completed = preferences3.getInt("LevelOneCompleted", 0);

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        total_completed = preferences2.getInt("TotalCompleted", 0);

        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_starred = preferences4.getInt("LevelOneStarred", 0);

        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        total_starred = preferences5.getInt("TotalStarred", 0);


        back = (Button) findViewById(R.id.angry_btn);
        toggle = (ToggleButton) findViewById(R.id.chkState);
        toggle2 = (ToggleButton) findViewById(R.id.chkState2);
        toggle3 = (ToggleButton) findViewById(R.id.toggleButton);

        toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;

                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                mp.start();
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
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                mp.start();
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

        toggle3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                total_toggles += 1;
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                mp.start();
                if(CheckWinningCondition()){
                    levelWon();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_level_one, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        // Commit current TotalToggles to save
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("TotalToggles", total_toggles);
        editor.apply();

        if(level_one_completed == 0){
            level_one_completed = 1;
            total_completed += 1;
        }
        else{
            level_one_completed = 1;
        }

        if(current_toggles <= toggles_for_star){
            if(level_one_starred == 0){
                level_one_starred = 1;
                total_starred += 1;
            }
            else{
                level_one_starred = 1;
            }
        }

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor2 = preferences2.edit();
        editor2.putInt("LevelOneCompleted", level_one_completed);
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
        editor5.putInt("LevelOneStarred", level_one_starred);
        editor5.apply();

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
}
