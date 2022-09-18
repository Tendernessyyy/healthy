package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class health extends AppCompatActivity {
    private Handler handler = new Handler();
    private Runnable runnableToMainActivity
            = new Runnable() {
        @Override
        public void run() {
            toMainActivity();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        this.getWindow().setFlags
                (WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.
                                FLAG_FULLSCREEN);
        setContentView(R.layout.activity_health);
        handler.postDelayed
                (runnableToMainActivity,10000);
    }
    private void toMainActivity() {
        Intent intent = new Intent(this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄漏
        handler.removeCallbacks
                (runnableToMainActivity);
    }
}
