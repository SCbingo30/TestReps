package com.twentythree.studydemo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "https://api.example.com/";
    private static Retrofit retrofit;

    // 私有构造函数，防止外部实例化
    private RetrofitSingleton() {}

    // 获取 Retrofit 实例的方法
    public static Retrofit getInstance() {
        if (retrofit == null) {
            synchronized (RetrofitSingleton.class) {
                if (retrofit == null) {
                    // 创建 OkHttpClient，可以根据需要添加拦截器等配置
                    OkHttpClient client = new OkHttpClient.Builder()
                        .build();

                    // 创建 Retrofit 实例
                    retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                }
            }
        }
        return retrofit;
    }

    // 创建 API 接口的方法
    public static ApiService getApiService() {
        return getInstance().create(ApiService.class);
    }
}
