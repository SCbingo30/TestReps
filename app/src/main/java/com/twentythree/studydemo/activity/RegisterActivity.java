package com.twentythree.studydemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.twentythree.studydemo.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {


    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goLogin.setOnClickListener(view -> {



            if (binding.password.getText().toString().equals(binding.checkPassword.getText().toString())){

                /*
                如何将参数带回到LoginActivity
                 */
                Intent resultIntent = new Intent();
                resultIntent.putExtra("userName", binding.userName.getText().toString());
                // 设置返回结果码为 RESULT_OK
                setResult(RESULT_OK, resultIntent);
                // 关闭当前 Activity
                finish();
            }else {
                Toast.makeText(this,"两次密码不一致",Toast.LENGTH_SHORT).show();
            }
        });
    }



}