package wt.ptrngame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;




public class levelMenuActivity extends AppCompatActivity {

    public static final String myPrefsKey13 = "MyPrefsFile";
    int sounds_toggle;

    public static final String myPrefsKey3 = "MyPrefsFile";
    int level_one_completed;
    public static final String myPrefsKey4 = "MyPrefsFile";
    int level_one_starred;

    public static final String myPrefsKey5 = "MyPrefsFile";
    int level_two_completed;
    public static final String myPrefsKey6 = "MyPrefsFile";
    int level_two_starred;

    public static final String myPrefsKey7 = "MyPrefsFile";
    int level_three_completed;
    public static final String myPrefsKey8 = "MyPrefsFile";
    int level_three_starred;

    public static final String myPrefsKey9 = "MyPrefsFile";
    int level_four_completed;
    public static final String myPrefsKey10 = "MyPrefsFile";
    int level_four_starred;


    Intent intent = getIntent();
    //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    Button back;
    Button levelone_button;
    Button leveltwo_button;
    Button levelthree_button;
    Button levelfour_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 1);


        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_completed = preferences3.getInt("LevelOneCompleted", 0);
        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_starred = preferences4.getInt("LevelOneStarred", 0);

        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        level_two_completed = preferences5.getInt("LevelTwoCompleted", 0);
        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        level_two_starred = preferences6.getInt("LevelTwoStarred", 0);

        SharedPreferences preferences7 = PreferenceManager.getDefaultSharedPreferences(this);
        level_three_completed = preferences7.getInt("LevelThreeCompleted", 0);
        SharedPreferences preferences8 = PreferenceManager.getDefaultSharedPreferences(this);
        level_three_starred = preferences8.getInt("LevelThreeStarred", 0);

        SharedPreferences preferences9 = PreferenceManager.getDefaultSharedPreferences(this);
        level_three_completed = preferences9.getInt("LevelFourCompleted", 0);
        SharedPreferences preferences10 = PreferenceManager.getDefaultSharedPreferences(this);
        level_three_starred = preferences10.getInt("LevelFourStarred", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_menu);

        back = (Button) findViewById(R.id.angry_btn);
        levelone_button = (Button) findViewById(R.id.level1);
        leveltwo_button = (Button) findViewById(R.id.level2);
        levelthree_button = (Button) findViewById(R.id.level3);
        levelfour_button = (Button) findViewById(R.id.level4);

        //level1
        if(level_one_completed == 1 && level_one_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            levelone_button.setBackground(drawable);
        }
        else if(level_one_starred == 1 && level_one_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            levelone_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            levelone_button.setBackground(drawable);
        }

        //level2
        if(level_two_completed == 1 && level_two_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            leveltwo_button.setBackground(drawable);
        }
        else if(level_two_starred == 1 && level_two_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            leveltwo_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            leveltwo_button.setBackground(drawable);
        }

        //level3
        if(level_three_completed == 1 && level_three_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            levelthree_button.setBackground(drawable);
        }
        else if(level_three_starred == 1 && level_three_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            levelthree_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            levelthree_button.setBackground(drawable);
        }

        //level4
        if(level_four_completed == 1 && level_four_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            levelthree_button.setBackground(drawable);
        }
        else if(level_four_starred == 1 && level_four_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            levelfour_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            levelfour_button.setBackground(drawable);
        }



        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                    mp.start();
                }
                MainMenu(view);
            }
        });

       levelone_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelOne(view);
            }
        });
        leveltwo_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelTwo(view);
            }
        });
        levelthree_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelThree(view);
            }
        });
        levelfour_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                levelFour(view);
            }
        });

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    protected void onResume() {
        super.onResume();

        // Level one completed?
        levelone_button = (Button) findViewById(R.id.level1);
        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_completed = preferences3.getInt("LevelOneCompleted", 0);
        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_starred = preferences4.getInt("LevelOneStarred", 0);

        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        level_two_completed = preferences5.getInt("LevelTwoCompleted", 0);
        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        level_two_starred = preferences6.getInt("LevelTwoStarred", 0);

        SharedPreferences preferences7 = PreferenceManager.getDefaultSharedPreferences(this);
        level_three_completed = preferences7.getInt("LevelThreeCompleted", 0);
        SharedPreferences preferences8 = PreferenceManager.getDefaultSharedPreferences(this);
        level_three_starred = preferences8.getInt("LevelThreeStarred", 0);

        SharedPreferences preferences9 = PreferenceManager.getDefaultSharedPreferences(this);
        level_four_completed = preferences9.getInt("LevelFourCompleted", 0);
        SharedPreferences preferences10 = PreferenceManager.getDefaultSharedPreferences(this);
        level_four_starred = preferences10.getInt("LevelFourStarred", 0);

        if(level_one_completed == 1 && level_one_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            levelone_button.setBackground(drawable);
        }
        else if(level_one_starred == 1 && level_one_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            levelone_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            levelone_button.setBackground(drawable);
        }


        // Level two completed?
        leveltwo_button = (Button) findViewById(R.id.level2);
        if(level_two_completed == 1 && level_two_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            leveltwo_button.setBackground(drawable);
        }
        else if(level_two_starred == 1 && level_two_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            leveltwo_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            leveltwo_button.setBackground(drawable);
        }

        // Level three completed?
        levelthree_button = (Button) findViewById(R.id.level3);
        if(level_three_completed == 1 && level_three_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            levelthree_button.setBackground(drawable);
        }
        else if(level_three_starred == 1 && level_three_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            levelthree_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            levelthree_button.setBackground(drawable);
        }

        // Level four completed?
        levelfour_button = (Button) findViewById(R.id.level4);
        if(level_four_completed == 1 && level_four_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            levelfour_button.setBackground(drawable);
        }
        else if(level_four_starred == 1 && level_four_completed == 1){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            levelfour_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            levelfour_button.setBackground(drawable);
        }
    }

    @Override
    protected void onStop() {
        Log.w("Tagg", "App stopped");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.w("Tagg", "App destoryed");

        super.onDestroy();
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

    public void MainMenu(View view){
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        //finish();
        super.onBackPressed();
    }


    public  void levelOne(View view){
        Intent intent = new Intent(this, levelOne.class);
        startActivity(intent);
    }

    public  void levelTwo(View view){
        Intent intent2 = new Intent(this, levelTwo.class);
        startActivity(intent2);
    }

    public  void levelThree(View view){
        Intent intent3 = new Intent(this, levelThree.class);
        startActivity(intent3);
    }

    public  void levelFour(View view){
        Intent intent4 = new Intent(this, levelFour.class);
        startActivity(intent4);
    }

}
