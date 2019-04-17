package com.dixson.sharedparking.untils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class myokhttp {
    public static OkHttpClient client = new OkHttpClient();

    //异步网络请求
    public static synchronized void sendRequest(String url , final okhttp3.Callback callback) {

        String myurl = "";

        Request request = new Request
                .Builder() //利用建造者模式创建Request对象
                .url("http://www.baidu.com/" + myurl) //设置请求的URL
                .get()
                .build(); //生成Request对象

        client.newCall(request).enqueue(callback); //发送请求 交给callback处理


    }

}
