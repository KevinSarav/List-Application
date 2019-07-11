package com.example.list;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent inting = getIntent();
        int ind = getIntent().getExtras().getInt("com.example.list");

        if(ind > -1){
            int pic = getImg(ind);
            ImageView img = findViewById(R.id.itemImg);
            scaleImg(img, pic);
        }
    }

    private int getImg(int index){
        switch(index){
            case 0: return R.drawable.pepper;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.orange;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pict){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options opt = new BitmapFactory.Options();

        opt.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pict, opt);

        int imgWidth = opt.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth){
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            opt.inSampleSize = ratio;
        }

        opt.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pict, opt);
        img.setImageBitmap(scaledImg);
    }
}
