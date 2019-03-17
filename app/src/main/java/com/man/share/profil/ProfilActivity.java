package com.man.share.profil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.man.share.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfilActivity extends AppCompatActivity {

    @BindView(R.id.img_taskbar_back)
    ImageView backTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        ButterKnife.bind(this);

        backTo.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });


    }
}
