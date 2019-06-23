package com.muthohhari.myrecyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.muthohhari.myrecyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPariwisata extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_positon";
    @BindView(R.id.img_pariwisata)
    ImageView imgPariwisata;
    @BindView(R.id.name_pariwisata)
    TextView namePariwisata;
    @BindView(R.id.description)
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pariwisata);
        ButterKnife.bind(this);

        getData();
    }

    private void getData() {

        Bundle bundle = getIntent().getBundleExtra(EXTRA_POSITION);

        namePariwisata.setText(bundle.getString("NAMA"));
        description.setText(bundle.getString("DESCRIPTION"));

        Glide.with(this).load(bundle.get("PHOTO"))
                .apply(new RequestOptions().override(600, 400))
                .into(imgPariwisata);
    }
}
