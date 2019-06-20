package com.muthohhari.myrecyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.muthohhari.myrecyclerview.DataPariwisata;
import com.muthohhari.myrecyclerview.ListOnClickListener;
import com.muthohhari.myrecyclerview.R;
import com.muthohhari.myrecyclerview.adapter.AdapterCard;
import com.muthohhari.myrecyclerview.model.Pariwisata;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListPariwisata extends AppCompatActivity implements ListOnClickListener {

    @BindView(R.id.list_pariwisata)
    RecyclerView rvPariwisata;

    private ArrayList<Pariwisata> pariwisata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pariwisata);
        ButterKnife.bind(this);

        setupAdapter();
        pariwisata.addAll(DataPariwisata.getListData());

    }

    private void setupAdapter() {
        AdapterCard adapter = new AdapterCard(this, pariwisata);
        adapter.setClickListener(this);
        rvPariwisata.setLayoutManager(new LinearLayoutManager(this));
        rvPariwisata.setHasFixedSize(true);
        rvPariwisata.setAdapter(adapter);
    }

    @Override
    public void onClick(View view, int position) {
        int id = view.getId();
        if (id == R.id.btn_set_share)
            Toast.makeText(this, "you share " + pariwisata.get(position).getName(), Toast.LENGTH_SHORT).show();
        else if (id == R.id.btn_set_favorite)
            Toast.makeText(this, pariwisata.get(position).getName() + " add to favorite", Toast.LENGTH_SHORT).show();
        else {
            Bundle bundle = new Bundle();
            bundle.putString("NAMA", pariwisata.get(position).getName());
            bundle.putString("DESCRIPTION", pariwisata.get(position).getDescription());
            bundle.putString("PHOTO", pariwisata.get(position).getPhoto());
            Intent intent = new Intent(ListPariwisata.this, DetailPariwisata.class);
            intent.putExtra(DetailPariwisata.EXTRA_POSITION, bundle);
            startActivity(intent);
        }
    }
}
