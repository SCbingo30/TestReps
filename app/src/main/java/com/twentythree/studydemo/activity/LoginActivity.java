package com.twentythree.studydemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.twentythree.studydemo.databinding.ActivityLoginBinding;

/**
 * 登录界面
 * Activity之间如何传递参数
 */
public class LoginActivity extends AppCompatActivity {


    ActivityLoginBinding loginBinding;

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*
        ViewBinding 是 Android 中的一个工具，用于简化视图（View）的绑定和访问。
        它允许您在不再需要使用传统的 findViewById 方法或手动创建视图引用的情况下，
        通过生成的绑定类来访问 XML 布局中的视图。ViewBinding 是从 Android Gradle 插件 3.6.0 版本开始引入的。
        */
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());


        /*
        通过registerForActivityResult 这个方法跳转从 LoginActivity 跳转到 RegisterActivity，
        在从 RegisterActivity 返回 LoginActivity 时，可以从 RegisterActivity 带回自己想要的参数
         */
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            // 处理从 RegisterActivity 返回的结果
                            Intent data = result.getData();
                            assert data != null;
                            String resultValue = data.getStringExtra("userName");

                            // 处理返回的数据
                            loginBinding.userName.setText(resultValue);
                        }

                    }
                });


        loginBinding.register.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            // 使用ActivityResultLauncher启动RegisterActivity
            activityResultLauncher.launch(intent);
        });


        loginBinding.login.setOnClickListener(view -> {
            /*
            从 LoginActivity 跳转到 MainActivity 并且将自己想要的数据带到 MainActivity 去
             */
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userName", loginBinding.userName.getText().toString());
            startActivity(intent);
            finish();
        });

    }


}