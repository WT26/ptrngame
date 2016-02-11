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

    public static final String myPrefsKey3 = "MyPrefsFile";
    int level_one_completed;

    public static final String myPrefsKey4 = "MyPrefsFile";
    int level_one_starred;


    Intent intent = getIntent();
    //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    Button back;
    Button levelone_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_completed = preferences3.getInt("LevelOneCompleted", 0);
        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_starred = preferences4.getInt("LevelOneStarred", 0);

        Log.d("TAGG", Integer.toString(level_one_starred));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_menu);

        back = (Button) findViewById(R.id.angry_btn);
        levelone_button = (Button) findViewById(R.id.angry_btn2);

        Log.d("TAGG", Integer.toString(level_one_starred));

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

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                mp.start();
                MainMenu(view);
            }

        });

       levelone_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                mp.start();
                levelOne(view);
            }
        });

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    protected void onResume() {
        super.onResume();
        levelone_button = (Button) findViewById(R.id.angry_btn2);

        if(level_one_completed == 0 || level_one_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.notcompleted);
            levelone_button.setBackground(drawable);
        }
        else if(level_one_completed == 1 || level_one_starred == 0){
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.completed);
            levelone_button.setBackground(drawable);
        }
        else{
            Resources res = getResources();
            Drawable drawable = res.getDrawable(R.drawable.starred);
            levelone_button.setBackground(drawable);
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
}
