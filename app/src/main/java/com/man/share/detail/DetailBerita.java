package com.man.share.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.man.share.R;
import com.man.share.profil.ProfilActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBerita extends AppCompatActivity {

    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_DESC = "extra_desc";
    public static final String EXTRA_IMG = "extra_img";

    @BindView(R.id.detailImage)
    ImageView detailImage;
    @BindView(R.id.detailTitle)
    TextView detailTitle;
    @BindView(R.id.detailDesc)
    TextView detailDesc;
    @BindView(R.id.detailCallCenter)
    ImageView imgCall;
    @BindView(R.id.imageJumpProfile)
    ImageView imgToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        ButterKnife.bind(this);

        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String desc = getIntent().getStringExtra(EXTRA_DESC);
        int img = getIntent().getIntExtra(EXTRA_IMG, 0);

        detailImage.setImageResource(img);
        detailTitle.setText(title);
        detailDesc.setText(desc);

        imgCall.setOnClickListener(v -> {
            String phoneNumber = "022-7100124";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        });

        imgToProfile.setOnClickListener(v -> {
            startActivity(new Intent(DetailBerita.this, ProfilActivity.class));
        });

    }
}
