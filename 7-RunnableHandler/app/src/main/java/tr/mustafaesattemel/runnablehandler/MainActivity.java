package tr.mustafaesattemel.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Runnable runnable;
    Handler handler;
    int number =0;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

    }
    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time : "+number);
                number++;

                //Donguye sokmusuz gibi dusun bu satira gelince 1(1000) saniye bekler sonra tekrar bu runnable(methodunu)'yi calistirir.
                handler.postDelayed(runnable,1000);
            }
        };

        //yukarida yazdigimiz kodlari bu handler sayesinde calistiriyoruz.
        //Sonrasinda o runnable fonksiyonu her 1 saniyede 1 kendisini calistirarak numberi vb artiriyor zaten.
        handler.post(runnable);

        //Butona birden fazla kez tiklanmasin. Sen butona 2 kere tikladigini dusun 2 kat daha hizli caliscak, cunku 2 thread calisacak arkada.
        button.setEnabled(false);
    }
    public void stop(View view){
        button.setEnabled(true);

        //Runnableyi durdur(threadi durdur).
        handler.removeCallbacks(runnable);
    }
}