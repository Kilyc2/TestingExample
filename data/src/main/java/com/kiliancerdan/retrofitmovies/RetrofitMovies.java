package com.kiliancerdan.retrofitmovies;


import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMovies {

    private static final String API_KEY = "8a45c0fa2c2e4b8db3ea6067cfac8928";
    private static RetrofitMovies retrofitMovies;
    private Retrofit retrofit;

    private RetrofitMovies() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor requestInterceptor = new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                HttpUrl originalUrl = originalRequest.url();

                HttpUrl urlWithParams = originalUrl.newBuilder()
                        .addQueryParameter("api_key", API_KEY)
                        .build();

                Request request = originalRequest.newBuilder()
                        .url(urlWithParams)
                        .build();

                return chain.proceed(request);
            }
        };

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public static Retrofit getRetrofit() {
        if (retrofitMovies == null) {
            retrofitMovies = new RetrofitMovies();
        }
        return retrofitMovies.retrofit;
    }

}
