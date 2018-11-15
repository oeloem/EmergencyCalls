package com.example.oeloem.emergencycalls;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class About extends AppCompatActivity {

    @BindView(R.id.BtnEmail)
    Button BtnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.BtnEmail)
    public void onViewClicked() {

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","rosihululum2@gmail.com",null));

        intent.putExtra(Intent.EXTRA_SUBJECT,"Kritik dan saran aplikasi");
        intent.putExtra(Intent.EXTRA_TEXT," ");

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(Intent.createChooser(intent,"pilih email client"));
        }else {
            Toast.makeText(this,"Tidak ada Email client",Toast.LENGTH_SHORT).show();
        }
    }
}

