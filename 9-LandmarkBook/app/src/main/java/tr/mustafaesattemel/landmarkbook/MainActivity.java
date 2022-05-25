package tr.mustafaesattemel.landmarkbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.stream.Collectors;

import tr.mustafaesattemel.landmarkbook.databinding.ActivityDetailsBinding;
import tr.mustafaesattemel.landmarkbook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList=new ArrayList<>();

        //Data
        Landmark amasya = new Landmark("Amasya Nehri","Turkey",R.drawable.amasya);
        Landmark kutuphane = new Landmark("İl halk kütüphanesi","Turkey",R.drawable.konyakutuphane);
        Landmark ayasofya = new Landmark("Ayasofya camii","Turkey",R.drawable.ayasofya);
        Landmark kizKulesi = new Landmark("Kız kulesi","Turkey",R.drawable.kizkulesi);

        landmarkArrayList.add(amasya);
        landmarkArrayList.add(kutuphane);
        landmarkArrayList.add(ayasofya);
        landmarkArrayList.add(kizKulesi);

        //ListView : Bunun yerine RecycleView'i kullan o daha optimizeli.
        //Asagida yaptigimiz olay tum landmarklarin isimlerini yazdirmak.
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1
                ,landmarkArrayList.stream().map(landmark -> landmark.getName()).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position)); //Serializable sayesinde yababildin.
                startActivity(intent);

            }
        });

    }
}