package com.example.proje_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> landmarkNames = new ArrayList<String>();
        landmarkNames.add("Anıtkabir");
        landmarkNames.add("TBMM");
        landmarkNames.add("Atatürk Heykeli");
        landmarkNames.add("Ankara Kalesi");

        Bitmap anitkabir = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.anitkabir);
        Bitmap tbmm = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tbmm);
        Bitmap ataturk_heykeli = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ataturk_heykeli);
        Bitmap ankara_kalesi = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ankara_kalesi);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();

        landmarkImages.add(anitkabir);
        landmarkImages.add(tbmm);
        landmarkImages.add(ataturk_heykeli);
        landmarkImages.add(ankara_kalesi);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("name", landmarkNames.get(position));

                //selectedImage = landmarkImages.get(position);

                Bitmap bitmap = landmarkImages.get(position);

                Globals globals = Globals.getInstance();
                globals.setData(bitmap);

                startActivity(intent);
            }
        });
    }
}
