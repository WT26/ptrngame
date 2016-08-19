package wt.ptrngame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class MainActivity extends AppCompatActivity {

    Button play;
    Button info;
    ToggleButton sounds;
    ImageView logo;
    RelativeLayout bg;

    public static final String mysounds = "MyPrefsFile";
    int sounds_toggle;

    public static final String mykeyorangelevel = "MyPrefsFile";
    int orangelevel_completed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        orangelevel_completed = preferences3.getInt("OrangeLevelCompleted", 0);

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences2.getInt("SoundsToggle", 0);

        play = (Button) findViewById(R.id.angry_btn);
        info = (Button) findViewById(R.id.button);
        sounds = (ToggleButton) findViewById(R.id.soundtogl);
        logo = (ImageView) findViewById(R.id.imageView);
        bg = (RelativeLayout) findViewById(R.id.relativelo);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }

                if(orangelevel_completed != 1){
                    levelMenu(view);
                }
                else {
                    orangeWorld(view);
                    //thirdWorld(view);
                }
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
                    sounds_toggle = 0;
                }
                else{
                    sounds_toggle = 1;
                }
                save_sound_settings();
            }
        });

        if(orangelevel_completed == 1){
            bg.setBackgroundColor(Color.parseColor("#ffcfa5"));
            logo.setBackground(getResources().getDrawable(R.drawable.ptrnlogoorange));
            play.setBackground(getResources().getDrawable(R.drawable.playbuttonorange));
            play.setTextColor(Color.parseColor("#be6c22"));
            info.setBackground(getResources().getDrawable(R.drawable.playbuttonorange));
            info.setTextColor(Color.parseColor("#be6c22"));
            sounds.setBackgroundDrawable(getResources().getDrawable(R.drawable.soundstoggleorange));
        }
        else {
            bg.setBackgroundColor(Color.parseColor("#dcfdff"));
            logo.setBackground(getResources().getDrawable(R.drawable.ptrnlogo));
            play.setBackground(getResources().getDrawable(R.drawable.playbutton));
            play.setTextColor(Color.parseColor("#116d73"));
            info.setBackground(getResources().getDrawable(R.drawable.playbutton));
            info.setTextColor(Color.parseColor("#116d73"));
            sounds.setBackgroundDrawable(getResources().getDrawable(R.drawable.sound_toggle));
        }
    }

    public void levelMenu(View view){
        Intent intent = new Intent(this, levelMenuActivity.class);
        startActivity(intent);
    }

    public void orangeWorld(View view){
        Intent intent11 = new Intent(this, orangeworld_menu.class);
        startActivity(intent11);
    }

    public void thirdWorld(View view){
        Intent intent11 = new Intent(this, thirdWorld.class);
        startActivity(intent11);
    }

    public void toInfopage(View view){
        finish();
        Intent intent = new Intent(this, infopage.class);
        startActivity(intent);
    }

    public void save_sound_settings(){
        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor6 = preferences6.edit();
        editor6.putInt("SoundsToggle", sounds_toggle);
        editor6.apply();
    }

}
