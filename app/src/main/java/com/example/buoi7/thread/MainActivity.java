package com.example.buoi7.thread;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_buoi_5.R;


public class MainActivity extends AppCompatActivity {

    Thread background = new Thread(new Runnable() {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    Message msg = Message.obtain();
                    Bundle b = new Bundle();
                    b.putString("x", "My Value: " + i);
                    msg.setData(b);
                    handler.sendMessage(msg);
                } catch (Exception e) {
                }
            }
        }
    });
    private TextView countTv;
    //init handle
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(Looper.getMainLooper()) {
        @SuppressLint("SetTextI18n")
        public void handleMessage(Message msg) {
            countTv.setText(countTv.getText() + "Item " + msg.getData().getString("x") + "\n");
        }
    };

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setContentView(R.layout.activity_main);
        //init views
        countTv = findViewById(R.id.count_tv);

//        createThread();
    }

    @Override
    protected void onStart() {
        super.onStart();
        background.start();
    }

    private void createThread() {
        // viết thread theo cách thứ nhất
        class MyThread extends Thread {
            public void run() {
// phần thực thi của thread viết ở đây
            }
        }
// viết thread theo cách thứ hai
        class MyRunnable implements Runnable {
            public void run() {
// phần thực thi của thread viết ở đây
            }
        }
// tạo và chạy các thread
        MyThread t1 = new MyThread();
        t1.start();
        MyRunnable t2 = new MyRunnable();
        new Thread(t2).start();
    }
}
