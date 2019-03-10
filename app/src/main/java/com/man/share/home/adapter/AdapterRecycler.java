package com.man.share.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.man.share.R;
import com.man.share.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 09, March, 2019
 */
public class AdapterRecycler extends RecyclerView.Adapter<ViewHolder> {

    private List<News> list = new ArrayList<>();
    private Context context;


    public AdapterRecycler(List<News> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_berita, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindView(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
