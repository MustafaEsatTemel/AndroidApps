package com.atilsamancioglu.myfirstapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


     //changeImage , butonumuzun onClickEvent'inin ismi. Oyuzden methodun ismini oyle yaptik.
    //Burada parametre olarak "View" kullanma sebebimiz, programa bu bir gorunum(buton,text,label,image vb) tarafindan cagirilacak demek icin.
    public void changeImage(View view){
        //ImageView türünden imageView değişkeni oluşturup, o değişkene findViewById ile gorsel kodlama yaparken ekledigimiz ImageView'in id'sini veriyoruz.
	//Bir nevi gorsel islemlerde ekledigimiz buttonlardir,text alanlaridir vb onlarin tanimlarini yapiyoruz yani. 
	//Benim imageView diye kullandigim degisken ekrandaki resime denk geliyor artik. Ekrandaki resimi o degisken araciligi ile kontrol edecegim.
        ImageView imageView = findViewById(R.id.imageView);

        //Yukarıdaki kod ile gerekli resmimizi almıştık, şimdi ise bu aldığımız resmi farklı bir resimle değiştireceğiz.
        //R ile şuanki projemizdeyiz diyoruz, drawable klasörüne girip ordaki bir resmi seçiyoruz.
        imageView.setImageResource(R.drawable.ic_launcher_background);
    }


}
