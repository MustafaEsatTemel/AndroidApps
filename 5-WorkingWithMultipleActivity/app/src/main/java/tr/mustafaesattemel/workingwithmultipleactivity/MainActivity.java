package tr.mustafaesattemel.workingwithmultipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText getMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMessage = findViewById(R.id.editTextTextPersonName);


    }
    public void changeActivity(View view){
        String mesaj = getMessage.getText().toString();

        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("yollanacakEleman",mesaj);//2. Aktiviteye bu veriyi yolliyoruz.
        startActivity(intent);

    }
}