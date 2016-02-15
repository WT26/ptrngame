package wt.ptrngame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class MainActivity extends AppCompatActivity {

    Button play;
    Button info;
    ToggleButton sounds;

    public static final String myPrefsKey13 = "MyPrefsFile";
    int sounds_toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences2.getInt("SoundsToggle", 1);

        play = (Button) findViewById(R.id.angry_btn);
        info = (Button) findViewById(R.id.button);
        sounds = (ToggleButton) findViewById(R.id.soundtogl);


        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelMenu(view);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                toInfopage(view);
            }
        });

        sounds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds.isChecked()){
                    sounds_toggle = 1;
                }
                else{
                    sounds_toggle = 0;
                }
                save_sound_settings();
            }
        });

    }

    public void levelMenu(View view){
        Intent intent = new Intent(this, levelMenuActivity.class);
        startActivity(intent);
    }

    public void toInfopage(View view){
        Intent intent = new Intent(this, infopage.class);
        startActivity(intent);
    }

    public void save_sound_settings(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("SoundToggle", sounds_toggle);
        editor.apply();
    }
}
