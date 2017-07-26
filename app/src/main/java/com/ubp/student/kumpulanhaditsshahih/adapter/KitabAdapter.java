package com.ubp.student.kumpulanhaditsshahih.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ubp.student.kumpulanhaditsshahih.R;
import com.ubp.student.kumpulanhaditsshahih.clients.model.BabModel;
import com.ubp.student.kumpulanhaditsshahih.clients.model.ImamModel;
import com.ubp.student.kumpulanhaditsshahih.clients.model.KitabModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class KitabAdapter extends RecyclerView.Adapter<KitabAdapter.ViewHolder> {


    public interface OnItemClickListener {
        void onItemClick(KitabModel model);
    }

    private ArrayList<KitabModel> list;
    private Context context;
    private final OnItemClickListener listener;

    public KitabAdapter(Context context, ArrayList<KitabModel> list, OnItemClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kitab, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final KitabModel model = list.get(position);
        ImamModel imamModel = ImamModel.findById(ImamModel.class, model.getIdImam());
//        BabModel.findById()
        int size = BabModel.find(BabModel.class, "id_kitab = ?", new String[]{String.valueOf(model.getId())}).size();
        holder.tvJudul.setText(model.getNama());
        holder.tvImam.setText(imamModel.getNamaImam());
        Glide.with(context).load(R.drawable.nav).into(holder.ivThumbnail);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(model);
            }
        });
//        holder.tvCount.setVisibility(View.GONE);
        holder.tvCount.setText(String.valueOf(size));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_judul)
        TextView tvJudul;
        @BindView(R.id.tv_deskripsi)
        TextView tvDeskripsi;
        @BindView(R.id.iv_thumbnail)
        ImageView ivThumbnail;
        @BindView(R.id.tv_imam)
        TextView tvImam;
        @BindView(R.id.tv_count)
        TextView tvCount;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
