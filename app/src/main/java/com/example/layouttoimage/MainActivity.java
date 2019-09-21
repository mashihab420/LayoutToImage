package com.example.layouttoimage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.layouttoimage.R.color.blue;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonid);
        relativeLayout = findViewById(R.id.relativeLayout1);
       imageView = findViewById(R.id.imageview);

        Button button1,button2 ;
        button2= findViewById(R.id.bt_blue);
        button1 = findViewById(R.id.bt_red);
        textView = findViewById(R.id.tv_cp);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = R.color.red;

              //  relativeLayout.setBackgroundColor(Color.parseColor("#F01306"));
                textView.setTextColor(Color.parseColor("#F01306"));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = blue;
                relativeLayout.setBackgroundColor(Color.blue(color));
                textView.setTextColor(Color.parseColor("#2196F3"));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap bitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(),
                        Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(bitmap);

                relativeLayout.draw(canvas);

                imageView.setImageBitmap(bitmap);

            }
        });

    }
}
