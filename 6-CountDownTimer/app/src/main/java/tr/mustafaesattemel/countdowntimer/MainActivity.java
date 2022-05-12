package tr.mustafaesattemel.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        //10 Saniye sursun(10000), her 1 saniyede(1000=1saniye) bir islesin(Tick).
        new CountDownTimer(10000,1000){


            @Override
            public void onTick(long millisUntilFinished) {//Eger millisUntilFinished'i kullanirsan milisaniye cinsinden isler.
                textView.setText("Timer : "+millisUntilFinished/1000);//10000 9000 8000 vb gibi isler bunun icin 1000'e boluyoryz.
            }

            @Override
            public void onFinish() {
                textView.setText("Finished.");
            }
        }.start();
    }

}