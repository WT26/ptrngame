package wt.ptrngame;

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

public class note extends AppCompatActivity {

    Button back;
    int sounds_toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        SharedPreferences totalstatics = PreferenceManager.getDefaultSharedPreferences(this);
        sounds_toggle = totalstatics.getInt("SoundsToggle", 0);

        back = (Button) findViewById(R.id.button10);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(sounds_toggle == 0){
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.backsound);
                    mp.start();
                }
                returning(view);
            }
        });
    }

    public void returning(View view){
        finish();
        Intent intent = new Intent(this, orangeworld_menu.class);
        startActivity(intent);
    }
}
