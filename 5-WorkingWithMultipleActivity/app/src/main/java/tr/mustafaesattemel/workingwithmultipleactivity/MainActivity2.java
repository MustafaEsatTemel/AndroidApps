package tr.mustafaesattemel.workingwithmultipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView getMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getMessage = findViewById(R.id.textView3);


        Intent intent = getIntent();
        String mesajimiz =intent.getStringExtra("yollanacakEleman");
        getMessage.setText("Value : "+mesajimiz);
    }
    public void changeActivity(View view){

        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);

    }
}