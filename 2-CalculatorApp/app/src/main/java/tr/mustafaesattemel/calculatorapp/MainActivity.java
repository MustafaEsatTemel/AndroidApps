package tr.mustafaesattemel.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText number1;
    EditText number2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.txtNumber1);
        number2 = findViewById(R.id.txtNumber2);
        result = findViewById(R.id.txtSonuc);


    }

    public void sum(View view){
        try{
            int sayi1 = Integer.parseInt(number1.getText().toString());
            int sayi2 = Integer.parseInt(number2.getText().toString());
            int result = sayi1+sayi2;
            this.result.setText("Result : "+result);
        }catch(Exception e){
            this.result.setText("Please enter number !");
        }

    }
    public void decal(View view){
        try{
            int sayi1 = Integer.parseInt(number1.getText().toString());
            int sayi2 = Integer.parseInt(number2.getText().toString());
            int result = sayi1-sayi2;
            this.result.setText("Result : "+result);
        }catch(Exception e){
            this.result.setText("Please enter number !");
        }

    }
    //Multiply
    public void multiply(View view){

        try{
            int sayi1 = Integer.parseInt(number1.getText().toString());
            int sayi2 = Integer.parseInt(number2.getText().toString());
            int result = sayi1*sayi2;
            this.result.setText("Result : "+result);
        }catch(Exception e){
            this.result.setText("Please enter number !");
        }


    }
    public void divide(View view){
        try{
            DecimalFormat df = new DecimalFormat("0.00");
            int sayi1 = Integer.parseInt(number1.getText().toString());
            int sayi2 = Integer.parseInt(number2.getText().toString());
            if(sayi2==0){
                this.result.setText("Number 2 cannot be 0.");
                return;
            }
            double result = sayi1/(double)sayi2;
            this.result.setText("Result : "+df.format(result));
        }catch(Exception e){
            this.result.setText("Please enter number !");
        }
    }

}