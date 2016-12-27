package com.lh.mywidget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);


        super.onCreate(savedInstanceState);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MainActivity.this, "x", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 5000);
        }
    };

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                mHandler.sendEmptyMessage(0);

//                OkHttpUtils.get().url("https://api.thinkpage.cn/v3/weather/now" +
//                        ".json?key=qyrggzdvkn9pnga3&location=ip").build().execute(new
// StringCallback() {
//
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Toast.makeText(MainActivity.this, "err", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        DataBean dataBean = (DataBean) DataFactory.getInstanceByJson(DataBean
//                                .class, response);
//                        Button button = (Button) findViewById(R.id.btn);
//                        button.setText("btN" + dataBean.getResults().get(0).getLocation().getName
//                                () + dataBean.getResults().get(0).getNow().getText() + dataBean
//                                .getResults().get(0).getNow().getTemperature());
//                        Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT)
// .show();
//                    }
//                });


                /**old*/
//                OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder().url("https://api.thinkpage" +
//                        ".cn/v3/weather/now.json?key=qyrggzdvkn9pnga3&location=ip").build();
//                Call call = client.newCall(request);
//                call.enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(Call call, final Response response) throws
// IOException {
//                        Looper.prepare();
//                        Toast.makeText(MainActivity.this, "" + response.body().string(), Toast
//                                .LENGTH_SHORT).show();
//                        Looper.loop();
//                        Log.d("#", "onResponse: " + response.body().string());
//                    }
//                });


                break;
            case R.id.btn2:
                mHandler.removeMessages(0);
                break;
        }
    }
}
