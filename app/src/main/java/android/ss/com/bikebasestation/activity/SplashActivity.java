package android.ss.com.bikebasestation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.ss.com.bikebasestation.MainActivity;
import android.ss.com.bikebasestation.R;
import android.support.v7.app.AppCompatActivity;
// Kh Sipar Hassan , id 16045
public class SplashActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    private String TAG = SplashActivity.class.getSimpleName();
    private Context context = SplashActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(context, HomeActivity.class));

            }
        };
        handler.postDelayed(runnable, 2000);
    }
}
