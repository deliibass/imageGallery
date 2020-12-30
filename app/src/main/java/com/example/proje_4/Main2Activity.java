package com.example.proje_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");

        textView.setText(name);

        //imageView.setImageBitmap(MainActivity.selectedImage);

        Globals globals = Globals.getInstance();
        Bitmap bitmap = globals.getData();

        imageView.setImageBitmap(bitmap);
    }
}
