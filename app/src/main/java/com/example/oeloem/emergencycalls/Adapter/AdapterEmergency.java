package com.example.oeloem.emergencycalls.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.oeloem.emergencycalls.R;

public class AdapterEmergency extends RecyclerView.Adapter<AdapterEmergency.ViewHolder> {
    Context context;
    String[] daftar,nomor;
    int[] gambar;

    public AdapterEmergency(Context context, String[] daftar, int[] gambar, String[] nomor) {
        this.context = context;
        this.daftar = daftar;
        this.gambar = gambar;
        this.nomor = nomor;
    }

    @NonNull
    @Override
    public AdapterEmergency.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_emergency,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEmergency.ViewHolder viewHolder, final int i) {
        viewHolder.txtDaftar.setText(daftar[i]);
        Glide.with(context).load(gambar[i]).into(viewHolder.imgDaftar);
        viewHolder.btnHubungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(Intent.ACTION_DIAL);

                pindah.setData(Uri.parse("tel:"+ nomor[i]));

                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnHubungi;
        TextView txtDaftar;
        ImageView imgDaftar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDaftar = itemView.findViewById(R.id.txtDaftar);
            imgDaftar = itemView.findViewById(R.id.imgGambar);
            btnHubungi = itemView.findViewById(R.id.btnHubungi);
        }
    }
}

