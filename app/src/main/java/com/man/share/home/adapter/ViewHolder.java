package com.man.share.home.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.man.share.R;
import com.man.share.detail.DetailActivity;
import com.man.share.model.News;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 09, March, 2019
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageNews)
    RoundedImageView imgNews;
    @BindView(R.id.textViewTitleNews)
    TextView txtTitle;
    @BindView(R.id.textViewDescNews)
    TextView txtDesc;
    @BindView(R.id.cardNews)
    MaterialCardView cardNews;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public void bindView(final News news){
        txtTitle.setText(news.title);
        txtDesc.setText(news.desc);
        imgNews.setImageResource(news.img);

        cardNews.setOnClickListener(v -> {
            Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_DESC, news.desc);
            intent.putExtra(DetailActivity.EXTRA_TITLE, news.title);
            intent.putExtra(DetailActivity.EXTRA_IMG, news.img);
            itemView.getContext().startActivity(intent);
        });




    }

}
