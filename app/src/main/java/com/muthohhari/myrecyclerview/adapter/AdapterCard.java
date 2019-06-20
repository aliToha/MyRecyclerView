package com.muthohhari.myrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.muthohhari.myrecyclerview.ListOnClickListener;
import com.muthohhari.myrecyclerview.R;
import com.muthohhari.myrecyclerview.model.Pariwisata;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.HolderList> {

    private Context context;
    private ArrayList<Pariwisata> listPariwisata;
    private ListOnClickListener clickListener;

    public AdapterCard(Context context, ArrayList<Pariwisata> listPariwisata) {
        this.context = context;
        this.listPariwisata = listPariwisata;
    }

    public void setClickListener(ListOnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public HolderList onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_cardview_presiden, viewGroup, false);
        return new HolderList(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderList holderList, int i) {
        holderList.name.setText(listPariwisata.get(i).getName());
        Glide.with(context).load(listPariwisata.get(i).getPhoto())
                .apply(new RequestOptions().override(500, 500))
                .into(holderList.photo);

    }

    @Override
    public int getItemCount() {
        return listPariwisata.size();
    }

    class HolderList extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.image_item_photo)
        ImageView photo;
        @BindView(R.id.tv_item_name)
        TextView name;
        @BindView(R.id.btn_set_favorite)
        ImageButton btnFavorite;
        @BindView(R.id.btn_set_share)
        ImageButton btnShare;

        HolderList(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            btnShare.setOnClickListener(this);
            btnFavorite.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }
}
