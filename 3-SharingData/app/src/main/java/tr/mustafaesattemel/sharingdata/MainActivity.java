package tr.mustafaesattemel.sharingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ageInput;
    TextView showAge;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageInput= findViewById(R.id.editTextNumberSigned);
        showAge=findViewById(R.id.textView);

        //Programi tekrar actigimizda uygulama hafizasina aldigimiz veriyi gorebilecegiz.
        sharedPreferences =
                getSharedPreferences("tr.mustafaesattemel.sharingdata", Context.MODE_PRIVATE);
        showAge.setText("Your age :"+sharedPreferences.getInt("storedAge",0));

    }
    public void save(View view){
        if(!ageInput.getText().toString().matches("")){
            int age = Integer.parseInt(ageInput.getText().toString());
            showAge.setText("Your age : "+ age);
            sharedPreferences.edit().putInt("storedAge",age).apply();
        }else{
            showAge.setText("You cannot leave this part blank");
        }


    }
    public void delete(View view){

        if(sharedPreferences.getInt("storedAge",0) != 0){
            sharedPreferences.edit().remove("storedAge").apply();
            showAge.setText("Your age :");
        }

    }
}