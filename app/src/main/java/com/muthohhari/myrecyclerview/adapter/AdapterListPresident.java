package com.muthohhari.myrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.muthohhari.myrecyclerview.ListOnClickListener;
import com.muthohhari.myrecyclerview.R;
import com.muthohhari.myrecyclerview.model.President;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterListPresident extends RecyclerView.Adapter<AdapterListPresident.HolderList> {

    private Context context;
    private ArrayList<President> listPresident;
    private ListOnClickListener clickListener;

    public AdapterListPresident(Context context, ArrayList<President> listPresident) {
        this.context = context;
        this.listPresident = listPresident;
    }

    public void setClickListener(ListOnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public HolderList onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_list_presiden, viewGroup, false);
        return new HolderList(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderList holderList, int i) {
        holderList.presidentName.setText(listPresident.get(i).getName());
        holderList.presidentRemarks.setText(listPresident.get(i).getRemarks());
        Glide.with(context).load(listPresident.get(i).getPhoto())
                .into(holderList.presidentPhoto);

    }

    @Override
    public int getItemCount() {
        return listPresident.size();
    }

    class HolderList extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.image_item_photo)
        CircleImageView presidentPhoto;
        @BindView(R.id.tv_item_name)
        TextView presidentName;
        @BindView(R.id.tv_item_remarks)
        TextView presidentRemarks;

        HolderList(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setTag(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }
}
