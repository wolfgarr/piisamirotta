package fi.hacklab.wolfgar.piisamirotta;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer m_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_player = MediaPlayer.create(this, R.raw.typeranainen);
    }

    public void playSound(View v){
        m_player.start();
    }
}
