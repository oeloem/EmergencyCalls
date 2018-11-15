package com.example.oeloem.emergencycalls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.oeloem.emergencycalls.Adapter.AdapterEmergency;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleEmergency extends AppCompatActivity {

    @BindView(R.id.myRecycle)
    RecyclerView myRecycle;

    String[] daftar,nomor;
    int[] gambar = {R.drawable.satupolisi,R.drawable.duaambulan,R.drawable.tigabasarnas,R.drawable.empatposkobencana,R.drawable.limapln,R.drawable.enampemadam,R.drawable.tujuhsatelit,R.drawable.delapankeracunan,R.drawable.sembilanbunuhdiri,R.drawable.sepuluhkejiwaan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_emergency);
        ButterKnife.bind(this);

        daftar = getResources().getStringArray(R.array.daftar);
        nomor = getResources().getStringArray(R.array.nomor);

        AdapterEmergency adapterEmergency = new AdapterEmergency(this,daftar,gambar,nomor);

        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapterEmergency);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);//klik cntrol + o lalu pilih onCreateOptionsMenu
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent1 = new Intent(this, About.class);
                startActivity(intent1);
                break;
            case R.id.action_profile:
                Intent intent2 = new Intent(this, Profile.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class Profile {
    }
}


