package com.man.share.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.man.share.R;
import com.man.share.home.adapter.AdapterRecycler;
import com.man.share.login.LoginActivity;
import com.man.share.model.ImageResource;
import com.man.share.model.News;
import com.man.share.profil.ProfilActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imageJumpProfile)
    ImageView imgToProfile;
    @BindView(R.id.rvListNews)
    RecyclerView rvListNews;
    @BindView(R.id.imgLogOut)
    ImageView imgExit;

    private AdapterRecycler mAdapter;
    private List<News> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setViews();
        rvListNews.setAdapter(mAdapter);


        imgExit.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });

        imgToProfile.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfilActivity.class));
        });

    }

    private void setViews(){
        list.add(new News(ImageResource.img_news_satu,getString(R.string.title_news_satu),getString(R.string.desc_news_satu)));
        list.add(new News(ImageResource.img_news_dua,getString(R.string.title_news_dua),getString(R.string.desc_news_dua)));
        list.add(new News(ImageResource.img_news_tiga,getString(R.string.title_news_satu),getString(R.string.desc_news_satu)));
        list.add(new News(ImageResource.img_news_empat,getString(R.string.title_news_dua),getString(R.string.desc_news_dua)));
        list.add(new News(ImageResource.img_news_tiga,getString(R.string.title_news_satu),getString(R.string.desc_news_satu)));
        list.add(new News(ImageResource.img_news_empat,getString(R.string.title_news_dua),getString(R.string.desc_news_dua)));

        mAdapter = new AdapterRecycler(list, this);
        rvListNews.setLayoutManager(new LinearLayoutManager(this));
        rvListNews.setHasFixedSize(true);
    }

}
