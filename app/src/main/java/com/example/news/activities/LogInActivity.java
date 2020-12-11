package com.example.news.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.news.R;
import com.example.news.databinding.ActivityLogInBinding;
import com.example.news.fragments.RegisterFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private ActivityLogInBinding B;
    RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        B = DataBindingUtil.setContentView(LogInActivity.this, R.layout.activity_log_in);


        /* Khởi tạo FirebaseAuth */
        mAuth = FirebaseAuth.getInstance();

        /* Khởi tạo Button logIn sẽ chuyển hướng */
        B.registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerFragment= new RegisterFragment();
                getSupportFragmentManager().beginTransaction().add(registerFragment,"e").commit();
                getSupportFragmentManager().beginTransaction().show(registerFragment).commit();
            }
        });

        /* Nhấn vào Button đăng nhập */
        B.logInBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
                case R.id.logInBtn : {

                    String emai = B.usernameEt.getText().toString().trim();
                    String password = B.passwordEt.getText().toString().trim();

                    mAuth.signInWithEmailAndPassword(emai, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {


                                // Lớp User
                                // Lấy dữ liệu User từ Firestore
                                Toast.makeText(LogInActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();


        /* Kiểm trq nếu người dùng đã đăng nhập và cập nhật giao diện người dùng */
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {


    }
}