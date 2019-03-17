package com.man.share.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.man.share.R;
import com.man.share.home.MainActivity;
import com.man.share.model.Users;
import com.man.share.registrasi.RegistrasiActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView txtRegis;

    private Users mUsers;
    private EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        txtRegis = findViewById(R.id.regis_txt);

        mUsers = new Users();
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        btnLogin.setOnClickListener(v -> {

            validasi();
        });

        txtRegis.setOnClickListener(v -> {
            // pindah intent
            startActivity(new Intent(LoginActivity.this, RegistrasiActivity.class));
            finish();
        });


    }

    void validasi(){
        mUsers.email = edtEmail.getText().toString();
        mUsers.password = edtPassword.getText().toString();
        if (TextUtils.isEmpty(mUsers.email) && TextUtils.isEmpty(mUsers.password)){
            showToast("Harap Isi Email Dan Password");

        } else if (TextUtils.isEmpty(mUsers.email)){
            edtEmail.setError("Isi Email");

        } else if (TextUtils.isEmpty(mUsers.password)){
            edtPassword.setError("Password Salah");
        } else {
            login();
        }
    }

    void login(){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
