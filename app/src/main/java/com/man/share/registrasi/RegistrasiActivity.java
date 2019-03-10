package com.man.share.registrasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.man.share.R;
import com.man.share.home.MainActivity;
import com.man.share.login.LoginActivity;
import com.man.share.model.Users;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrasiActivity extends AppCompatActivity {

    @BindView(R.id.img_taskbar_back)
    ImageView backToLogin;
    @BindView(R.id.regisEditTextEmail)
    EditText regisEditTextEmail;
    @BindView(R.id.regisEditTextPassword)
    EditText regisEditTextPassword;
    @BindView(R.id.registEditTextRetryPassword)
    EditText registEditTextRetryPassword;
    @BindView(R.id.regisButtonSumbit)
    Button regisButtonSumbit;

    private Users mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        ButterKnife.bind(this);

        mUsers = new Users();

        backToLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegistrasiActivity.this, LoginActivity.class));
            finish();
        });

        regisButtonSumbit.setOnClickListener((v)->{
            validasi();
        });


    }

    void validasi(){
        String retry;
        mUsers.email = regisEditTextEmail.getText().toString();
        mUsers.password = regisEditTextPassword.getText().toString();
        retry = registEditTextRetryPassword.getText().toString();

        if (!TextUtils.isEmpty(mUsers.email) && !TextUtils.isEmpty(mUsers.password) && !TextUtils.isEmpty(retry)){
            if (retry.equals(mUsers.password)){
                login();
            } else {
                registEditTextRetryPassword.setError("Password Tidak Cocok");
            }
        } else if (TextUtils.isEmpty(mUsers.email)){
            regisEditTextEmail.setError("Isi Email");

        } else if (TextUtils.isEmpty(mUsers.password)){
            regisEditTextPassword.setError("Password Salah");
        } else {
            showToast("Isi Data dengan Lengkap");
        }
    }

    void login(){
        startActivity(new Intent(RegistrasiActivity.this, MainActivity.class));
        finish();
    }


    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
