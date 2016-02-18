package wt.ptrngame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class infopage extends AppCompatActivity {
    Button reset;
    Button back;
    TextView infotext;

    final Context context = this;

    String text_to_set;

    public static final String myPrefsKey = "MyPrefsFile";
    int total_toggles;

    public static final String myPrefsKey2 = "MyPrefsFile";
    int total_completed;

    public static final String myPrefsKey3 = "MyPrefsFile";
    int total_starred;

    public static final String myPrefsKey8 = "MyPrefsFile";
    int total_retrys;

    public static final String mySounds = "MyPrefsFile";
    int sounds_toggle;

    public static final String mykeyorangelevel = "MyPrefsFile";
    int orangelevel_completed;


    // Levels
    public static final String myPrefsKey4 = "MyPrefsFile";
    int level_one_completed;
    public static final String myPrefsKey5 = "MyPrefsFile";
    int level_one_starred;

    public static final String myPrefsKey6 = "MyPrefsFile";
    int level_two_completed;
    public static final String myPrefsKey7 = "MyPrefsFile";
    int level_two_starred;

    public static final String myPrefsKey9 = "MyPrefsFile";
    int level_three_completed;
    public static final String myPrefsKey10 = "MyPrefsFile";
    int level_three_starred;

    public static final String myPrefsKey11 = "MyPrefsFile";
    int level_four_completed;
    public static final String myPrefsKey12 = "MyPrefsFile";
    int level_four_starred;

    public static final String myPrefsKey13 = "MyPrefsFile";
    int level_five_completed;
    public static final String myPrefsKey14 = "MyPrefsFile";
    int level_five_starred;

    public static final String myPrefsKey15 = "MyPrefsFile";
    int level_six_completed;
    public static final String myPrefsKey16 = "MyPrefsFile";
    int level_six_starred;

    public static final String myPrefsKey17 = "MyPrefsFile";
    int level_seven_completed;
    public static final String myPrefsKey18 = "MyPrefsFile";
    int level_seven_starred;

    public static final String myPrefsKey19 = "MyPrefsFile";
    int level_eight_completed;
    public static final String myPrefsKey20 = "MyPrefsFile";
    int level_eight_starred;

    public static final String myPrefsKey21 = "MyPrefsFile";
    int level_nine_completed;
    public static final String myPrefsKey22 = "MyPrefsFile";
    int level_nine_starred;

    public static final String myPrefsKey23 = "MyPrefsFile";
    int level_ten_completed;
    public static final String myPrefsKey24 = "MyPrefsFile";
    int level_ten_starred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopage);

        SharedPreferences preferences99 = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = preferences99.getInt("SoundsToggle", 0);

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        total_completed = preferences2.getInt("TotalCompleted", 0);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = preferences.getInt("TotalToggles", 0);

        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        total_starred = preferences3.getInt("TotalStarred", 0);

        SharedPreferences preferences8 = PreferenceManager.getDefaultSharedPreferences(this);
        total_retrys = preferences8.getInt("TotalRetrys", 0);

        SharedPreferences preferences0 = PreferenceManager.getDefaultSharedPreferences(this);
        orangelevel_completed = preferences3.getInt("OrangeLevelCompleted", 0);


        // Levels
        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_completed = preferences4.getInt("LevelOneCompleted", 0);
        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_starred = preferences5.getInt("LevelOneStarred", 0);

        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        level_two_completed = preferences6.getInt("LevelTwoCompleted", 0);
        SharedPreferences preferences7 = PreferenceManager.getDefaultSharedPreferences(this);
        level_two_starred = preferences7.getInt("LevelTwoStarred", 0);

        SharedPreferences preferences9 = PreferenceManager.getDefaultSharedPreferences(this);
        level_three_completed = preferences9.getInt("LevelThreeCompleted", 0);
        SharedPreferences preferences10 = PreferenceManager.getDefaultSharedPreferences(this);
        level_three_starred = preferences10.getInt("LevelThreeStarred", 0);

        SharedPreferences preferences11 = PreferenceManager.getDefaultSharedPreferences(this);
        level_four_completed = preferences11.getInt("LevelFourCompleted", 0);
        SharedPreferences preferences12 = PreferenceManager.getDefaultSharedPreferences(this);
        level_four_starred = preferences12.getInt("LevelFourStarred", 0);

        SharedPreferences preferences13 = PreferenceManager.getDefaultSharedPreferences(this);
        level_five_completed = preferences13.getInt("LevelFiveCompleted", 0);
        SharedPreferences preferences14 = PreferenceManager.getDefaultSharedPreferences(this);
        level_five_starred = preferences14.getInt("LevelFiveStarred", 0);

        SharedPreferences preferences15 = PreferenceManager.getDefaultSharedPreferences(this);
        level_six_completed = preferences15.getInt("LevelSixCompleted", 0);
        SharedPreferences preferences16 = PreferenceManager.getDefaultSharedPreferences(this);
        level_six_starred = preferences16.getInt("LevelSixStarred", 0);

        SharedPreferences preferences17 = PreferenceManager.getDefaultSharedPreferences(this);
        level_seven_completed = preferences17.getInt("LevelSevenCompleted", 0);
        SharedPreferences preferences18 = PreferenceManager.getDefaultSharedPreferences(this);
        level_seven_starred = preferences18.getInt("LevelSevenStarred", 0);

        SharedPreferences preferences19 = PreferenceManager.getDefaultSharedPreferences(this);
        level_eight_completed = preferences19.getInt("LevelEightCompleted", 0);
        SharedPreferences preferences20 = PreferenceManager.getDefaultSharedPreferences(this);
        level_eight_starred = preferences20.getInt("LevelEightStarred", 0);

        SharedPreferences preferences21 = PreferenceManager.getDefaultSharedPreferences(this);
        level_nine_completed = preferences21.getInt("LevelNineCompleted", 0);
        SharedPreferences preferences22 = PreferenceManager.getDefaultSharedPreferences(this);
        level_nine_starred = preferences22.getInt("LevelNineStarred", 0);

        SharedPreferences preferences23 = PreferenceManager.getDefaultSharedPreferences(this);
        level_ten_completed = preferences23.getInt("LevelTenCompleted", 0);
        SharedPreferences preferences24 = PreferenceManager.getDefaultSharedPreferences(this);
        level_ten_starred = preferences24.getInt("LevelTenStarred", 0);



        infotext = (TextView) findViewById(R.id.textView23);

        text_to_set = "Thank you for downloading!" +
                "\n\n\nStats:\nTotal Toggles: " + total_toggles +
                "\nTotal Levels Completed: " + total_completed +
                "\nTotal Levels Starred: "+ total_starred +
                "\nTotal Retrys: " + total_retrys;

        infotext.setText(text_to_set);


        reset = (Button) findViewById(R.id.button3);
        back = (Button) findViewById(R.id.button2);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                    mp.start();
                }
                MainMenu(view);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.selectsound);
                    mp.start();
                }
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("WARNING");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Do you really want to reset all of the stats?")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                ResetGame();

                                text_to_set = "Thank you for downloading!" +
                                        "\n\n\nStats:\nTotal Toggles: " + total_toggles +
                                        "\nTotal Levels Completed: " + total_completed +
                                        "\nTotal Levels Starred: "+ total_starred +
                                        "\nTotal Retrys: " + total_retrys;

                                infotext.setText(text_to_set);
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_infopage, menu);
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

    public void MainMenu(View view){
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //super.onBackPressed();
    }

    public void ResetGame(){
        total_toggles = 0;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("TotalToggles", total_toggles);
        editor.apply();

        total_completed = 0;
        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor3 = preferences3.edit();
        editor3.putInt("TotalCompleted", total_completed);
        editor3.apply();

        total_starred = 0;
        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor4 = preferences4.edit();
        editor4.putInt("TotalStarred", total_starred);
        editor4.apply();

        total_retrys = 0;
        SharedPreferences preferences8 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor8 = preferences8.edit();
        editor8.putInt("TotalRetrys", total_retrys);
        editor8.apply();

        orangelevel_completed = 0;
        SharedPreferences preferences0 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor0 = preferences0.edit();
        editor0.putInt("OrangeLevelCompleted", orangelevel_completed);
        editor0.apply();


        // Levels
        level_one_completed = 0;
        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor2 = preferences2.edit();
        editor2.putInt("LevelOneCompleted", level_one_completed);
        editor2.apply();
        level_one_starred = 0;
        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor5 = preferences5.edit();
        editor5.putInt("LevelOneStarred", level_one_starred);
        editor5.apply();

        level_two_completed = 0;
        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor6 = preferences6.edit();
        editor6.putInt("LevelTwoCompleted", level_two_completed);
        editor6.apply();
        level_two_starred = 0;
        SharedPreferences preferences7 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor7 = preferences7.edit();
        editor7.putInt("LevelTwoStarred", level_two_starred);
        editor7.apply();

        level_three_completed = 0;
        SharedPreferences preferences12 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor12 = preferences12.edit();
        editor12.putInt("LevelThreeCompleted", level_three_completed);
        editor12.apply();
        level_three_starred = 0;
        SharedPreferences preferences13 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor13 = preferences13.edit();
        editor13.putInt("LevelThreeStarred", level_three_starred);
        editor13.apply();

        level_four_completed = 0;
        SharedPreferences preferences14 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor14 = preferences14.edit();
        editor14.putInt("LevelFourCompleted", level_four_completed);
        editor14.apply();
        level_four_starred = 0;
        SharedPreferences preferences15 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor15 = preferences15.edit();
        editor15.putInt("LevelFourStarred", level_four_starred);
        editor15.apply();

        level_five_completed = 0;
        SharedPreferences preferences16 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor16 = preferences16.edit();
        editor16.putInt("LevelFiveCompleted", level_five_completed);
        editor16.apply();
        level_five_starred = 0;
        SharedPreferences preferences17 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor17 = preferences17.edit();
        editor17.putInt("LevelFiveStarred", level_five_starred);
        editor17.apply();

        level_six_completed = 0;
        SharedPreferences preferences18 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor18 = preferences18.edit();
        editor18.putInt("LevelSixCompleted", level_six_completed);
        editor18.apply();
        level_six_starred = 0;
        SharedPreferences preferences19 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor19 = preferences19.edit();
        editor19.putInt("LevelSixStarred", level_six_starred);
        editor19.apply();

        level_seven_completed = 0;
        SharedPreferences preferences20 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor20 = preferences20.edit();
        editor20.putInt("LevelSevenCompleted", level_seven_completed);
        editor20.apply();
        level_seven_starred = 0;
        SharedPreferences preferences21 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor21 = preferences21.edit();
        editor21.putInt("LevelSevenStarred", level_seven_starred);
        editor21.apply();

        level_eight_completed = 0;
        SharedPreferences preferences22 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor22 = preferences22.edit();
        editor22.putInt("LevelEightCompleted", level_eight_completed);
        editor22.apply();
        level_eight_starred = 0;
        SharedPreferences preferences23 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor23 = preferences23.edit();
        editor23.putInt("LevelEightStarred", level_eight_starred);
        editor23.apply();

        level_nine_completed = 0;
        SharedPreferences preferences24 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor24 = preferences24.edit();
        editor24.putInt("LevelNineCompleted", level_nine_completed);
        editor24.apply();
        level_nine_starred = 0;
        SharedPreferences preferences25 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor25 = preferences25.edit();
        editor25.putInt("LevelNineStarred", level_nine_starred);
        editor25.apply();

        level_ten_completed = 0;
        SharedPreferences preferences26 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor26 = preferences26.edit();
        editor26.putInt("LevelTenCompleted", level_ten_completed);
        editor26.apply();
        level_ten_starred = 0;
        SharedPreferences preferences27 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor27 = preferences27.edit();
        editor27.putInt("LevelTenStarred", level_ten_starred);
        editor27.apply();

    }
}
