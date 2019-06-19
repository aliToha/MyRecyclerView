package com.muthohhari.myrecyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.muthohhari.myrecyclerview.DataPresident;
import com.muthohhari.myrecyclerview.ListOnClickListener;
import com.muthohhari.myrecyclerview.R;
import com.muthohhari.myrecyclerview.adapter.AdapterCardPresident;
import com.muthohhari.myrecyclerview.adapter.AdapterGridPresident;
import com.muthohhari.myrecyclerview.adapter.AdapterListPresident;
import com.muthohhari.myrecyclerview.model.President;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListPresident extends AppCompatActivity implements ListOnClickListener {
    @BindView(R.id.rv_president)
    RecyclerView rvPresident;

    private ArrayList<President> presidents = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupListAdapter();
        presidents.addAll(DataPresident.getListData());
    }

    private void setupGridAdapter() {
        AdapterGridPresident adapterGridPresident = new AdapterGridPresident(this, presidents);
        adapterGridPresident.setClickListener(this);
        rvPresident.setLayoutManager(new GridLayoutManager(this, 2));
        rvPresident.setHasFixedSize(true);
        rvPresident.setAdapter(adapterGridPresident);
    }

    private void setupListAdapter() {
        AdapterListPresident adapterListPresident = new AdapterListPresident(this, presidents);
        adapterListPresident.setClickListener(this);
        rvPresident.setLayoutManager(new LinearLayoutManager(this));
        rvPresident.setHasFixedSize(true);
        rvPresident.setAdapter(adapterListPresident);
    }

    private void setupCardAdapter() {
        AdapterCardPresident adapterCardPresident = new AdapterCardPresident(this, presidents);
        adapterCardPresident.setClickListener(this);
        rvPresident.setLayoutManager(new LinearLayoutManager(this));
        rvPresident.setHasFixedSize(true);
        rvPresident.setAdapter(adapterCardPresident);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.list:
                setupListAdapter();
                break;
            case R.id.grid:
                setupGridAdapter();
                break;
            case R.id.card:
                setupCardAdapter();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view, int position) {
        int id = view.getId();
        if (id == R.id.btn_set_share)
            Toast.makeText(this, "you share " + presidents.get(position).getName(), Toast.LENGTH_SHORT).show();
        else if (id == R.id.btn_set_favorite)
            Toast.makeText(this, presidents.get(position).getName() + " add to favorite", Toast.LENGTH_SHORT).show();
        else {
            Bundle bundle = new Bundle();
            bundle.putString("NAMA", presidents.get(position).getName());
            bundle.putString("REMARKS", presidents.get(position).getRemarks());
            bundle.putString("DESCRIPTION", presidents.get(position).getDescription());
            bundle.putString("PHOTO", presidents.get(position).getPhoto());
            Intent intent = new Intent(ListPresident.this, DetailPresident.class);
            intent.putExtra(DetailPresident.EXTRA_POSITION, bundle);
            startActivity(intent);
        }
    }
}
