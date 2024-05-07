package com.example.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import android.widget.TextView;

import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;


public class Zonas extends AppCompatActivity {
    TextView zona1, zona2;
    ImageView imgZona;
    RatingBar rbZona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zonas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        zona1 = (TextView) findViewById(R.id.text_zona1);
        zona2 = (TextView) findViewById(R.id.text_zona2);
        imgZona = (ImageView) findViewById(R.id.imgZona1);
        rbZona = (RatingBar) findViewById(R.id.rtgZona);


        Intent intent = getIntent();
        Lugar lugar = (Lugar) intent.getSerializableExtra("lugar");
        zona1.setText(lugar.getNombre());
        zona2.setText(lugar.getDesc());
        Picasso.get()
                .load(lugar.getImgurl())
                .error(R.mipmap.ic_launcher_round)
                .into(imgZona);
        rbZona.setRating(Float.parseFloat(lugar.getCalifica()));


    }
}