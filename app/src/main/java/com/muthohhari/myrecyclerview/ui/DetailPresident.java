package com.muthohhari.myrecyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.muthohhari.myrecyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailPresident extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_positon";
    @BindView(R.id.image_president)
    CircleImageView imagePresident;
    @BindView(R.id.president_name)
    TextView presidentName;
    @BindView(R.id.president_remarks)
    TextView presidentRemarks;
    @BindView(R.id.president_description)
    TextView presidentDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatil_president);
        ButterKnife.bind(this);

        getData();

    }

    private void getData() {
        Bundle bundle = getIntent().getBundleExtra(EXTRA_POSITION);

        presidentName.setText(bundle.getString("NAMA"));
        presidentRemarks.setText(bundle.getString("REMARKS"));
        presidentDescription.setText(bundle.getString("DESCRIPTION"));

        Glide.with(this).load(bundle.get("PHOTO"))
                .apply(new RequestOptions().override(400, 400))
                .into(imagePresident);
    }
}
