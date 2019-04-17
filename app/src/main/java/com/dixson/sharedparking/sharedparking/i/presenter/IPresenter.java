package com.dixson.sharedparking.sharedparking.i.presenter;

import android.content.Context;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dixson.sharedparking.R;



import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class IPresenter extends AppCompatActivity {
    public Context context;
   public String username;

    Button checkInfo = (Button)findViewById(R.id.checkInfo);
    TextView personinfo = (TextView)findViewById(R.id.personinfo);

    public IPresenter(Context context){
        this.context = context;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doit(username);
    }

    public void doit(String username){

        final String url = "/checkInfo.do?" + "username=" +username;
        Toast.makeText(context,"服务器准备连接", Toast.LENGTH_SHORT).show();
        checkInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"服务器连接", Toast.LENGTH_SHORT).show();
                    com.dixson.sharedparking.untils.myokhttp.sendRequest(url, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText(context,"服务器连接失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {


                        Toast.makeText(context,"服务器连接成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    private void ShowResponse(final String res){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
              personinfo.setText(res);
            }
        });
    }

}
