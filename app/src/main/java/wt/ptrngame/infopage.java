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

    public static final String totalstatics = "MyPrefsFile";
    int total_toggles;
    int total_completed;
    int total_starred;
    int total_retrys;
    int total_ptrns;

    int sounds_toggle;
    int orangelevel_completed;


    // Levels
    public static final String levelsaves = "MyPrefsFile";
    int level_one_completed;
    int level_one_starred;

    int level_two_completed;
    int level_two_starred;

    int level_three_completed;
    int level_three_starred;

    int level_four_completed;
    int level_four_starred;

    int level_five_completed;
    int level_five_starred;

    int level_six_completed;
    int level_six_starred;

    int level_seven_completed;
    int level_seven_starred;

    int level_eight_completed;
    int level_eight_starred;

    int level_nine_completed;
    int level_nine_starred;

    int level_ten_completed;
    int level_ten_starred;

    int level_eleven_completed;
    int level_eleven_starred;

    int level_twelve_completed;
    int level_twelve_starred;

    int level_thirteen_completed;
    int level_thirteen_starred;

    int level_fourteen_completed;
    int level_fourteen_starred;

    int level_fifteen_completed;
    int level_fifteen_starred;

    int level_sixteen_completed;
    int level_sixteen_starred;

    int level_seventeen_completed;
    int level_seventeen_starred;

    int level_eighteen_completed;
    int level_eighteen_starred;

    int level_nineteen_completed;
    int level_nineteen_starred;

    int level_twenty_completed;
    int level_twenty_starred;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopage);

        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 0);
        total_completed = totalstatics.getInt("TotalCompleted", 0);
        total_toggles = totalstatics.getInt("TotalToggles", 0);
        total_starred = totalstatics.getInt("TotalStarred", 0);
        total_retrys = totalstatics.getInt("TotalRetrys", 0);
        total_ptrns = totalstatics.getInt("TotalPtrns", 0);
        orangelevel_completed = totalstatics.getInt("OrangeLevelCompleted", 0);


        // Levels
        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_completed = levelsaves.getInt("LevelOneCompleted", 0);
        level_one_starred = levelsaves.getInt("LevelOneStarred", 0);

        level_two_completed = levelsaves.getInt("LevelTwoCompleted", 0);
        level_two_starred = levelsaves.getInt("LevelTwoStarred", 0);

        level_three_completed = levelsaves.getInt("LevelThreeCompleted", 0);
        level_three_starred = levelsaves.getInt("LevelThreeStarred", 0);

        level_four_completed = levelsaves.getInt("LevelFourCompleted", 0);
        level_four_starred = levelsaves.getInt("LevelFourStarred", 0);

        level_five_completed = levelsaves.getInt("LevelFiveCompleted", 0);
        level_five_starred = levelsaves.getInt("LevelFiveStarred", 0);

        level_six_completed = levelsaves.getInt("LevelSixCompleted", 0);
        level_six_starred = levelsaves.getInt("LevelSixStarred", 0);

        level_seven_completed = levelsaves.getInt("LevelSevenCompleted", 0);
        level_seven_starred = levelsaves.getInt("LevelSevenStarred", 0);

        level_eight_completed = levelsaves.getInt("LevelEightCompleted", 0);
        level_eight_starred = levelsaves.getInt("LevelEightStarred", 0);

        level_nine_completed = levelsaves.getInt("LevelNineCompleted", 0);
        level_nine_starred = levelsaves.getInt("LevelNineStarred", 0);

        level_ten_completed = levelsaves.getInt("LevelTenCompleted", 0);
        level_ten_starred = levelsaves.getInt("LevelTenStarred", 0);

        level_eleven_completed = levelsaves.getInt("LevelElevenCompleted", 0);
        level_eleven_starred = levelsaves.getInt("LevelElevenStarred", 0);

        level_twelve_completed = levelsaves.getInt("LevelTwelveCompleted", 0);
        level_twelve_starred = levelsaves.getInt("LevelTwelveStarred", 0);

        level_thirteen_completed = levelsaves.getInt("LevelThirteenCompleted", 0);
        level_thirteen_starred = levelsaves.getInt("LevelThirteenStarred", 0);

        level_fourteen_completed = levelsaves.getInt("LevelFourteenCompleted", 0);
        level_fourteen_starred = levelsaves.getInt("LevelFourteenStarred", 0);

        level_fifteen_completed = levelsaves.getInt("LevelFifteenCompleted", 0);
        level_fifteen_starred = levelsaves.getInt("LevelFifteenStarred", 0);

        level_sixteen_completed = levelsaves.getInt("LevelSixteenCompleted", 0);
        level_sixteen_starred = levelsaves.getInt("LevelSixteenStarred", 0);

        level_seventeen_completed = levelsaves.getInt("LevelSeventeenCompleted", 0);
        level_seventeen_starred = levelsaves.getInt("LevelSeventeenStarred", 0);

        level_eighteen_completed = levelsaves.getInt("LevelEighteenCompleted", 0);
        level_eighteen_starred = levelsaves.getInt("LevelEighteenStarred", 0);

        level_nineteen_completed = levelsaves.getInt("LevelNineteenCompleted", 0);
        level_nineteen_starred = levelsaves.getInt("LevelNineteenStarred", 0);

        level_twenty_completed = levelsaves.getInt("LevelTwentyCompleted", 0);
        level_twenty_starred = levelsaves.getInt("LevelTwentyStarred", 0);


        infotext = (TextView) findViewById(R.id.textView23);

        text_to_set = "Thank you for downloading!" +
                "\n\n\nStats:\nTotal Toggles: " + total_toggles +
                "\nTotal PTRNs Made: " + total_ptrns +
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
                                        "\nTotal PTRNs Made: " + total_ptrns +
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
        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = totalstatics.edit();
        editor.putInt("TotalToggles", total_toggles);
        editor.apply();

        total_completed = 0;
        editor.putInt("TotalCompleted", total_completed);
        editor.apply();

        total_starred = 0;
        editor.putInt("TotalStarred", total_starred);
        editor.apply();

        total_retrys = 0;
        editor.putInt("TotalRetrys", total_retrys);
        editor.apply();

        total_ptrns = 0;
        editor.putInt("TotalPtrns", total_ptrns);
        editor.apply();

        orangelevel_completed = 0;
        editor.putInt("OrangeLevelCompleted", orangelevel_completed);
        editor.apply();


        // Levels
        SharedPreferences levelsaves = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor2 = levelsaves.edit();

        level_one_completed = 0;
        editor2.putInt("LevelOneCompleted", level_one_completed);
        editor2.apply();

        level_one_starred = 0;
        editor2.putInt("LevelOneStarred", level_one_starred);
        editor2.apply();

        level_two_completed = 0;
        editor2.putInt("LevelTwoCompleted", level_two_completed);
        editor2.apply();
        level_two_starred = 0;
        editor2.putInt("LevelTwoStarred", level_two_starred);
        editor2.apply();

        level_three_completed = 0;
        editor2.putInt("LevelThreeCompleted", level_three_completed);
        editor2.apply();
        level_three_starred = 0;
        editor2.putInt("LevelThreeStarred", level_three_starred);
        editor2.apply();

        level_four_completed = 0;
        editor2.putInt("LevelFourCompleted", level_four_completed);
        editor2.apply();
        level_four_starred = 0;
        editor2.putInt("LevelFourStarred", level_four_starred);
        editor2.apply();

        level_five_completed = 0;
        editor2.putInt("LevelFiveCompleted", level_five_completed);
        editor2.apply();
        level_five_starred = 0;
        editor2.putInt("LevelFiveStarred", level_five_starred);
        editor2.apply();

        level_six_completed = 0;
        editor2.putInt("LevelSixCompleted", level_six_completed);
        editor2.apply();
        level_six_starred = 0;
        editor2.putInt("LevelSixStarred", level_six_starred);
        editor2.apply();

        level_seven_completed = 0;
        editor2.putInt("LevelSevenCompleted", level_seven_completed);
        editor2.apply();
        level_seven_starred = 0;
        editor2.putInt("LevelSevenStarred", level_seven_starred);
        editor2.apply();

        level_eight_completed = 0;
        editor2.putInt("LevelEightCompleted", level_eight_completed);
        editor2.apply();
        level_eight_starred = 0;
        editor2.putInt("LevelEightStarred", level_eight_starred);
        editor2.apply();

        level_nine_completed = 0;
        editor2.putInt("LevelNineCompleted", level_nine_completed);
        editor2.apply();
        level_nine_starred = 0;
        editor2.putInt("LevelNineStarred", level_nine_starred);
        editor2.apply();

        level_ten_completed = 0;
        editor2.putInt("LevelTenCompleted", level_ten_completed);
        editor2.apply();
        level_ten_starred = 0;
        editor2.putInt("LevelTenStarred", level_ten_starred);
        editor2.apply();

        level_eleven_completed = 0;
        editor2.putInt("LevelElevenCompleted", level_eleven_completed);
        editor2.apply();
        level_eleven_starred = 0;
        editor2.putInt("LevelElevenStarred", level_eleven_starred);
        editor2.apply();

        level_twelve_completed = 0;
        editor2.putInt("LevelTwelveCompleted", level_twelve_completed);
        editor2.apply();
        level_twelve_starred = 0;
        editor2.putInt("LevelTwelveStarred", level_twelve_starred);
        editor2.apply();

        level_thirteen_completed = 0;
        editor2.putInt("LevelThirteenCompleted", level_thirteen_completed);
        editor2.apply();
        level_thirteen_starred = 0;
        editor2.putInt("LevelThirteenStarred", level_thirteen_starred);
        editor2.apply();

        level_fourteen_completed = 0;
        editor2.putInt("LevelFourteenCompleted", level_fourteen_completed);
        editor2.apply();
        level_fourteen_starred = 0;
        editor2.putInt("LevelFourteenStarred", level_fourteen_starred);
        editor2.apply();

        level_fifteen_completed = 0;
        editor2.putInt("LevelFifteenCompleted", level_fifteen_completed);
        editor2.apply();
        level_fifteen_starred = 0;
        editor2.putInt("LevelFifteenStarred", level_fifteen_starred);
        editor2.apply();

        level_sixteen_completed = 0;
        editor2.putInt("LevelSixteenCompleted", level_sixteen_completed);
        editor2.apply();
        level_sixteen_starred = 0;
        editor2.putInt("LevelSixteenStarred", level_sixteen_starred);
        editor2.apply();

        level_seventeen_completed = 0;
        editor2.putInt("LevelSeventeenCompleted", level_seventeen_completed);
        editor2.apply();
        level_seventeen_starred = 0;
        editor2.putInt("LevelSeventeenStarred", level_seventeen_starred);
        editor2.apply();

        level_eighteen_completed = 0;
        editor2.putInt("LevelEighteenCompleted", level_eighteen_completed);
        editor2.apply();
        level_eighteen_starred = 0;
        editor2.putInt("LevelEighteenStarred", level_eighteen_starred);
        editor2.apply();

        level_nineteen_completed = 0;
        editor2.putInt("LevelNineteenCompleted", level_nineteen_completed);
        editor2.apply();
        level_nineteen_starred = 0;
        editor2.putInt("LevelNineteenStarred", level_nineteen_starred);
        editor2.apply();

        level_twenty_completed = 0;
        editor2.putInt("LevelTwentyCompleted", level_twenty_completed);
        editor2.apply();
        level_twenty_starred = 0;
        editor2.putInt("LevelTwentyStarred", level_twenty_starred);
        editor2.apply();

    }
}
