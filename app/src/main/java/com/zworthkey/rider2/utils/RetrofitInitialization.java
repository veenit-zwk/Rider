package com.zworthkey.rider2.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInitialization {

    /*public RetrofitInitialization(){}*/

    public static Retrofit builder(String url, final String token)

    {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Accept","Application/json")
                        .addHeader("Authorization", "Bearer " + token )
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(/*new Config().getBaseUrl()*/ url)

                .addConverterFactory( GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }


   /* public static Retrofit builder(String url)

    {
      HttpLoggingInterceptor   loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Accept","Application/json")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(*//*new Config().getBaseUrl()*//* url)

                .addConverterFactory( GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }*/


}
