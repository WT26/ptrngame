package wt.ptrngame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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


    public static final String myPrefsKey4 = "MyPrefsFile";
    int level_one_completed;

    public static final String myPrefsKey5 = "MyPrefsFile";
    int level_one_starred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopage);

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        total_completed = preferences2.getInt("TotalCompleted", 0);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        total_toggles = preferences.getInt("TotalToggles", 0);

        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        total_starred = preferences3.getInt("TotalStarred", 0);


        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_completed = preferences4.getInt("LevelOneCompleted", 0);

        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        level_one_starred = preferences5.getInt("LevelOneStarred", 0);

        infotext = (TextView) findViewById(R.id.textView23);

        text_to_set = "Thank you for downloading!" +
                "\n\n\nStats:\nTotal Toggles: " + total_toggles +
                "\nTotal levels completed: " + total_completed +
                "\nTotal levels starred: "+ total_starred;

        infotext.setText(text_to_set);


        reset = (Button) findViewById(R.id.button3);
        back = (Button) findViewById(R.id.button2);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                mp.start();
                MainMenu(view);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                mp.start();

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
                                        "\nTotal levels completed: " + total_completed +
                                        "\nTotal levels starred: "+ total_starred;

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

    }
}
