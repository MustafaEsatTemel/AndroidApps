package tr.mustafaesattemel.catchtheagentp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timeText;
    TextView scoreText;
    int score ;
    ImageView []imageView;
    Handler handler ;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = new ImageView[]{findViewById(R.id.imageView)
                ,findViewById(R.id.imageView2)
                ,findViewById(R.id.imageView3)
                ,findViewById(R.id.imageView4)
                ,findViewById(R.id.imageView5)
                ,findViewById(R.id.imageView6)
                ,findViewById(R.id.imageView7)
                ,findViewById(R.id.imageView8)
                ,findViewById(R.id.imageView9)};
        hideImages();

        timeText = findViewById(R.id.timeText);

        scoreText = findViewById(R.id.scoreText);



        new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time : "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                timeText.setText("Time off");
                handler.removeCallbacks(runnable);
                for(ImageView image : imageView){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart?");
                alert.setMessage("Are you sure to restart game ?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Intent intent = getIntent();
                        finish();//Uygulamayi sonlandir.
                        startActivity(intent); //Uygulamayi baslat.

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Game over!",Toast.LENGTH_SHORT).show();

                    }
                });

                alert.show();



            }
        }.start();

    }

    public void increaseScore(View view){

        score ++;
        scoreText.setText("Score : "+score);

    }
    public void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageView){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageView[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);


            }
        };

        handler.post(runnable);

    }
}