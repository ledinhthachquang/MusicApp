package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.appnhac.Model.Baihat;
import com.example.appnhac.R;

import java.util.ArrayList;

public class PlayNhacAcitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac_acitvity);
        Intent intent = getIntent();
        if (intent.hasExtra("cakhuc")){
            Baihat baihat = intent.getParcelableExtra("cakhuc");
            Toast.makeText(this, baihat.getTenbaihat(), Toast.LENGTH_SHORT).show();
        }
        if (intent.hasExtra("cacbaihat")){
            ArrayList<Baihat> mangbaihat = intent.getParcelableArrayListExtra("cacbaihat");
            for (int i = 0; i < mangbaihat.size(); i ++){
                Log.d("BBB",mangbaihat.get(i).getTenbaihat());
            }
        }
    }
}