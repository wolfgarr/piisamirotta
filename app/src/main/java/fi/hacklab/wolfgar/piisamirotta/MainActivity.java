package fi.hacklab.wolfgar.piisamirotta;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int PERCENTAGE = 3;
    private static final int FOOTHEALTH = 3;

    private MediaPlayer m_player;
    private MediaPlayer m_secondaryPlayer;

    private ImageButton m_foot;
    private int m_footLife = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        m_foot = (ImageButton)findViewById(R.id.footButton);

        m_player = MediaPlayer.create(this, R.raw.typeranainen);
        m_secondaryPlayer = MediaPlayer.create(this, R.raw.jalkahoitaja);
    }

    public void playSound(View v){
        m_footLife++;
        if (m_footLife == FOOTHEALTH) m_foot.setVisibility(View.GONE);
        m_player.seekTo(0);
        m_player.start();
        int rnd = (int)(Math.random()*100);
        Log.d("rnd", Integer.toString(rnd));
        if(rnd <= PERCENTAGE) {
            m_foot.setVisibility(View.VISIBLE);
            m_footLife = 0;
        }
    }

    public void footClick(View v) {
        m_secondaryPlayer.seekTo(0);
        m_secondaryPlayer.start();
        m_foot.setVisibility(View.GONE);
    }
}
