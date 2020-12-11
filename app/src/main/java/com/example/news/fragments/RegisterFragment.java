package com.example.news.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.news.R;
import com.example.news.activities.LogInActivity;
import com.example.news.databinding.ActivityRegisterBinding;
import com.example.news.databinding.FragmentRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FragmentRegisterBinding B;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_register,null);
        B = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_register);


        mAuth = FirebaseAuth.getInstance();


        /* Nhấn vào Button đăng ký */
        B.registerBtn.setOnClickListener(this);


        /* Nhấn vào Button logIn sẽ chuyển hướng */
        B.logInTv.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerBtn : {

                String emai = B.usernameEt.getText().toString().trim();
                String password = B.passwordEt.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(emai, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {


                            // Tạo lớp User
                            // Ghi dữ liệu User lên Firestore
                            Toast.makeText(getContext(), "Sign Up Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(), LogInActivity.class));
                        }
                        else {
                            Toast.makeText(getContext(), "Error Sign Up", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                break;
            }


            /* Nhấn vào TextView "Dang nhap" chuyển qua LogIn Activity layout */
            case R.id.logInTv :{
                startActivity(new Intent(getContext(), LogInActivity.class));


                break;
            }
        }
    }
}