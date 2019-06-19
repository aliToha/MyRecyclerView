package com.muthohhari.myrecyclerview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.muthohhari.myrecyclerview.DataPariwisata;
import com.muthohhari.myrecyclerview.R;
import com.muthohhari.myrecyclerview.model.Pariwisata;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListPariwisata extends AppCompatActivity {

    @BindView(R.id.list_pariwisata)
    RecyclerView listPariwisata;

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
    }
}
