package com.twentythree.studydemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import com.twentythree.studydemo.R;
import com.twentythree.studydemo.RetrofitSingleton;
import com.twentythree.studydemo.databinding.ActivityMainBinding;




public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //获取从 LoginActivity 传过来的参数
        userName = getIntent().getStringExtra("userName");

        //AndroidX Navigation 的使用
        NavController navController = Navigation.findNavController(this, R.id.fragment_container);
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);

        //网络请求需要接口
        //RetrofitSingleton.getApiService().listRepos("1");

    }

    public String getUserName() {
        return userName;
    }
}