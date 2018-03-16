package android.ss.com.bikebasestation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.ss.com.bikebasestation.R;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

// Kh Sipar Hassan , id 16045

public class HomeActivity extends AppCompatActivity {

    private String TAG = HomeActivity.class.getSimpleName();
    private Context context = HomeActivity.this;
    private Toolbar toolbar;
    private Button btn_map, btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.home);
        setSupportActionBar(toolbar);

        btn_list = (Button) findViewById(R.id.btn_list);
        btn_map = (Button) findViewById(R.id.btn_map);
        //Buttons on Page
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MapActivity.class));
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, BikeListActivity.class));
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
